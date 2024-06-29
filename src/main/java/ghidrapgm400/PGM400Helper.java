package ghidrapgm400;

import ghidra.app.util.cparser.C.CParser;
import ghidra.app.util.cparser.C.ParseException;
import ghidra.program.model.data.DataType;
import ghidra.program.model.data.DataTypeManager;
import ghidra.program.model.listing.Program;

public class PGM400Helper {
	public static boolean isEBCDICChar(byte b) {
		int uVal = b & 0xff;
		int uLow = uVal & 0x0f;
		int uHigh = uVal & 0xf0;
		
		/* Uppercase */
		if (uLow < 0x0A && uLow > 0 && uHigh > 0x70 && uHigh < 0xB0) {
			return true;
		}
		
		/* Lowercase + digits */
		if (uLow < 0x0A && uHigh > 0xB0) {
			return true;
		}
		
		/*Special chars*/
		if (uLow > 0x09 && uHigh > 0x30 && uHigh < 0x80) {
			return true;
		}
		
		/* Others (fuck EBCDIC)... */
		if (uVal == 0x40 || uVal == 0x50 || uVal == 0x60 || uVal == 0x61) {
			return true;
		}
		return false;
	}
	
	public static void createDataTypes(Program program) throws ParseException {
		DataTypeManager dtm = program.getDataTypeManager();
		CParser parser  = new CParser(dtm);
		DataType taggedPtrType = parser.parse("struct TaggedPtr {unsigned long long ptrtype; void* ptr;};");
		DataType r3StackType = parser.parse("struct R3Stack {TaggedPtr dummy0; TaggedPtr dummy10; TaggedPtr ptr20; TaggedPtr ptr30; TaggedPtr ptr40;};");
		
		int transaction = dtm.startTransaction("Adding tagged pointer type");
		dtm.addDataType(taggedPtrType, null);
		dtm.addDataType(r3StackType, null);
		dtm.endTransaction(transaction, true );
		
		
	}
}
