/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidrapgm400;

import java.io.*;
import java.util.*;

import ghidra.app.util.MemoryBlockUtils;
import ghidra.app.util.Option;
import ghidra.app.util.bin.ByteProvider;
import ghidra.app.util.cparser.C.CParser;
import ghidra.app.util.cparser.C.ParseException;
import ghidra.app.util.importer.MessageLog;
import ghidra.app.util.opinion.AbstractProgramWrapperLoader;
import ghidra.app.util.opinion.LoadSpec;
import ghidra.framework.model.DomainObject;
import ghidra.program.model.address.Address;
import ghidra.program.model.address.AddressFactory;
import ghidra.program.model.address.AddressOverflowException;
import ghidra.program.model.data.DataType;
import ghidra.program.model.data.DataTypeManager;
import ghidra.program.model.data.PointerDataType;
import ghidra.program.model.lang.LanguageCompilerSpecPair;
import ghidra.program.model.lang.Register;
import ghidra.program.model.listing.Program;
import ghidra.program.model.symbol.SourceType;
import ghidra.util.exception.CancelledException;
import ghidra.util.exception.DuplicateNameException;
import ghidra.util.exception.InvalidInputException;
import ghidra.util.task.TaskMonitor;
import ghidrapgm400.Pgm.ModuleTableEntry;
import ghidrapgm400.Pgm.ProcedureTableEntry;
import ghidra.program.flatapi.FlatProgramAPI;
import io.kaitai.struct.ByteBufferKaitaiStream;
import ghidra.program.model.listing.Parameter;
import ghidra.program.model.listing.ParameterImpl;
import ghidra.program.model.listing.Function;
import ghidra.program.model.listing.Function.FunctionUpdateType;

/**
 * TODO: Provide class-level documentation that describes what this loader does.
 */
public class GhidraPGM400Loader extends AbstractProgramWrapperLoader {

	@Override
	public String getName() {
		return "PGM400 loader";
	}

	@Override
	public Collection<LoadSpec> findSupportedLoadSpecs(ByteProvider provider) throws IOException {
		List<LoadSpec> loadSpecs = new ArrayList<>();

		loadSpecs.add(new LoadSpec(this, 0x400000, new LanguageCompilerSpecPair("PowerPC:BE:64:AS", "default"),true));
		return loadSpecs;
	}
	
	public static long addrToLong(Pgm.Addr addr) {
		return (addr.dwhigh() << 32) + addr.dwlow();
	}
	
	

	@Override
	protected void load(ByteProvider provider, LoadSpec loadSpec, List<Option> options,
			Program program, TaskMonitor monitor, MessageLog log)
			throws CancelledException, IOException {
		//AddressFactory af = program.getAddressFactory();
		
		// General utils
	    FlatProgramAPI api= new FlatProgramAPI(program);
	    
	    // Main program structure from Kaitai
	    Pgm kaitai = new Pgm(new ByteBufferKaitaiStream(provider.readBytes(0, provider.length())));
	    Pgm.ProgramHeaderBase programBaseHeader = kaitai.mainSegment().pgmHeader().programHeader();
	    
	    // Load segments
	    Pgm.SegmentTable segmentTable = kaitai.mainSegment().pgmHeader().programHeader().segmentTable();
	    ArrayList<Pgm.Segment> segments = kaitai.segments();
	    
	    long seek=0x1000;
	    
	    for (int i=0;i<segmentTable.tableEntryCount(); i++) {
	    	Pgm.SegmentTableEntry stEntry = segmentTable.entries().get(i);
	    	long segSize = 0;
	    	if (i==0) {
	    		segSize=kaitai.mainSegment().yysghdr().programSize()*0x200;
	    	}else {
	    		segSize=segments.get(i-1).segmentSize()*0x200;
	    	}
	    	
	    	long lStart = addrToLong(stEntry.segmentAddress());
	    	Address slsStart = api.toAddr( lStart ); // SLS address
	    	
	    	try {
	    		ByteArrayInputStream stream =new ByteArrayInputStream(provider.readBytes(seek ,segSize));
				MemoryBlockUtils.createInitializedBlock(program, false, "Segment "+i, slsStart, stream, segSize, "", "PGM400", true, true, true, log, monitor);
			} catch (AddressOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    	
	    	seek += segSize;
	    }
	    MemoryBlockUtils.createUninitializedBlock(program, false, "ExceptionSpace", api.toAddr(0xffffffffff000000L), 0xffffff, "", "", false, false, true, log);
	    MemoryBlockUtils.createUninitializedBlock(program, false, "StackSpace",     api.toAddr(0x57ACC57ACC000000L), 0xffffff, "", "", true, true, false, log);
	    
	    // Entry point
	    // TODO fix procedure table entry parsing bug!
	    Pgm.ActivationHeader activationHeader = programBaseHeader.activationHeader();
	    
	    try {
			PGM400Helper.createDataTypes(program);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	    
	    Address entryPointAddress = api.toAddr(addrToLong(activationHeader.pepEntryPoint()));
	    if (program.getAddressFactory().isValidAddress(entryPointAddress)) {
	    	api.addEntryPoint(entryPointAddress);
	    }
	    
	    for ( ModuleTableEntry modEntry : programBaseHeader.moduleTable().tableEntries()) {
	    	for (ProcedureTableEntry procEntry: modEntry.modules().procedureTable().entries()) {
	    		Pgm.Addr procAddr = procEntry.procStartPtr();
	    		Address funcAddr = api.toAddr(addrToLong(procAddr));
	    		Function func = api.createFunction(funcAddr, null);
	    		
	    		api.disassemble(funcAddr);
	    	}
	    }
	   
	    program.setExecutableFormat("ILE");
	    
	    
	}

	@Override
	public List<Option> getDefaultOptions(ByteProvider provider, LoadSpec loadSpec,
			DomainObject domainObject, boolean isLoadIntoProgram) {
		List<Option> list =
			super.getDefaultOptions(provider, loadSpec, domainObject, isLoadIntoProgram);

		// TODO: If this loader has custom options, add them to 'list'
		list.add(new Option("Option name goes here", "Default option value goes here"));

		return list;
	}

	@Override
	public String validateOptions(ByteProvider provider, LoadSpec loadSpec, List<Option> options, Program program) {

		// TODO: If this loader has custom options, validate them here.  Not all options require
		// validation.

		return super.validateOptions(provider, loadSpec, options, program);
	}
}
