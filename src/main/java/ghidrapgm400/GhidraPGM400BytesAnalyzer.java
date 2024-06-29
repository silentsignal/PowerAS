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

import ghidra.app.services.AbstractAnalyzer;
import ghidra.app.services.AnalyzerType;
import ghidra.app.util.importer.MessageLog;
import ghidra.framework.options.Options;
import ghidra.program.flatapi.FlatProgramAPI;
import ghidra.program.model.address.AddressIterator;
import ghidra.program.model.address.AddressSetView;
import ghidra.program.model.data.CharsetSettingsDefinition;
import ghidra.program.model.data.DataUtilities;
import ghidra.program.model.data.DataUtilities.ClearDataMode;
import ghidra.program.model.data.TerminatedStringDataType;
import ghidra.program.model.lang.CompilerSpec;
import ghidra.program.model.listing.Program;
import ghidra.program.model.mem.MemoryAccessException;
import ghidra.program.model.util.CodeUnitInsertionException;
import ghidra.util.exception.CancelledException;
import ghidra.util.task.TaskMonitor;
import ghidra.program.model.address.*;
import ghidra.program.model.listing.*;
/**
 * TODO: Provide class-level documentation that describes what this analyzer does.
 */
public class GhidraPGM400BytesAnalyzer extends AbstractAnalyzer {

	public GhidraPGM400BytesAnalyzer() {

		// TODO: Name the analyzer and give it a description.

		super("PGM400 Bytes Analyzer", "IBM i (AS/400) Bytes Analyzer", AnalyzerType.BYTE_ANALYZER);
	}

	@Override
	public boolean getDefaultEnablement(Program program) {
		return program.getExecutableFormat().equals("ILE");
		//return false;
	}

	@Override
	public boolean canAnalyze(Program program) {

		// TODO: Examine 'program' to determine of this analyzer should analyze it.  Return true
		// if it can.

		
		return program.getExecutableFormat().equals("ILE");
		//return false;
	}

	@Override
	public void registerOptions(Options options, Program program) {

		// TODO: If this analyzer has custom options, register them here

		/*options.registerOption("Option name goes here", false, null,
			"Option description goes here");*/
	}

	@Override
	public boolean added(Program program, AddressSetView set, TaskMonitor monitor, MessageLog log)
			throws CancelledException {

		FlatProgramAPI api= new FlatProgramAPI(program);
		
		
		AddressSetView initializedMemory = program.getMemory().getLoadedAndInitializedAddressSet();
		if (set == null) {
			set = new AddressSet(initializedMemory);
		}

		AddressSet searchSet = initializedMemory.intersect(set);
		AddressIterator addrIter = searchSet.getAddresses(true);
		
		monitor.setMaximum(searchSet.getNumAddresses());
		Address strBegin = null;
		Address strEnd = null;
		long progress = 0;
		while(addrIter.hasNext() && !monitor.isCancelled()) {
			progress++;
			monitor.setProgress(progress);
			Address addr = addrIter.next();
			try {
				byte b = api.getByte(addr);
				if (PGM400Helper.isEBCDICChar(b)) {
					if (strBegin == null) {
						strBegin = addr;
					}else {
						strEnd = addr;
					}
				}else {
					try {
						if (strBegin != null && strEnd != null) {
							if (strEnd.subtract(strBegin) >= 4) {
								System.out.println("Found string at "+strBegin.toString());
								Data data = DataUtilities.createData(program, strBegin, new TerminatedStringDataType(), 
										(int) strEnd.subtract(strBegin), ClearDataMode.CLEAR_ALL_UNDEFINED_CONFLICT_DATA);
								CharsetSettingsDefinition.CHARSET.setCharset(data, "IBM1140");
							}
						}
					}catch (CodeUnitInsertionException e) {
						e.printStackTrace();
					}finally {
						strBegin = null;
						strEnd = null;		
					}
					
				}
			
			}catch(MemoryAccessException e) {}
			
			
		}		
		return true;
	}
	

}
