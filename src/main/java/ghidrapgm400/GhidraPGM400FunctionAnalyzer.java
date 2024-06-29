package ghidrapgm400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ghidra.app.services.AbstractAnalyzer;
import ghidra.app.services.AnalyzerType;
import ghidra.app.util.cparser.C.ParseException;
import ghidra.app.util.importer.MessageLog;
import ghidra.program.flatapi.FlatProgramAPI;
import ghidra.program.model.address.AddressIterator;
import ghidra.program.model.address.AddressSet;
import ghidra.program.model.address.AddressSetView;
import ghidra.program.model.data.DataType;
import ghidra.program.model.data.PointerDataType;
import ghidra.program.model.lang.Register;
import ghidra.program.model.listing.Parameter;
import ghidra.program.model.listing.ParameterImpl;
import ghidra.program.model.listing.Program;
import ghidra.program.model.listing.Function;
import ghidra.program.model.listing.Function.FunctionUpdateType;
import ghidra.program.model.listing.Listing;
import ghidra.program.model.symbol.SourceType;
import ghidra.util.exception.CancelledException;
import ghidra.util.exception.DuplicateNameException;
import ghidra.util.exception.InvalidInputException;
import ghidra.util.task.TaskMonitor;

public class GhidraPGM400FunctionAnalyzer extends AbstractAnalyzer{

	public GhidraPGM400FunctionAnalyzer() {

		// TODO: Name the analyzer and give it a description.

		super("PGM400 Function Analyzer", "IBM i (AS/400) Functions Analyzer", AnalyzerType.FUNCTION_ANALYZER);
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
	public boolean added(Program program, AddressSetView set, TaskMonitor monitor, MessageLog log)
			throws CancelledException {
		// TODO Auto-generated method stub
		FlatProgramAPI api= new FlatProgramAPI(program);
		Listing listing = program.getListing();
		for (Function func : listing.getFunctions(set, true)) {
			Parameter[] params = func.getParameters();
			List<Parameter> paramList = new ArrayList<Parameter>();
			DataType[] dataTypesArr = api.getDataTypes("R3Stack");
			if (dataTypesArr.length == 0) {
				try {
					PGM400Helper.createDataTypes(program);
				} catch (ParseException e) {
					e.printStackTrace();
					return false;
				}
				dataTypesArr = api.getDataTypes("R3Stack");
			}
			DataType r3StackType = dataTypesArr[0];
			DataType r3StackPtr = new PointerDataType(r3StackType);
			Register r3 = program.getRegister("R3");
			Parameter newP0=null;
			try {
				newP0 = new ParameterImpl("r3Stack", r3StackPtr, r3, program);
			} catch (InvalidInputException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			}
			
			if (params.length > 0) {
				paramList =  Arrays.asList(params);
				paramList.set(0, newP0);
			
			}else{
				paramList.add(newP0);
			}
			try {
				func.replaceParameters(paramList, FunctionUpdateType.CUSTOM_STORAGE , true, SourceType.ANALYSIS);
			} catch (DuplicateNameException | InvalidInputException e) {
				e.printStackTrace();
			}
			
		}
		
		return true;
	}

}
