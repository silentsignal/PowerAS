// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild
package ghidrapgm400;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Pgm extends KaitaiStruct {
    public static Pgm fromFile(String fileName) throws IOException {
        return new Pgm(new ByteBufferKaitaiStream(fileName));
    }

    public enum ObjectType {
        ACCESS_GROUP(1),
        PGM(2),
        MODULE(3),
        PERMANENT_CONTEXT(4),
        TEMPORARY_CONTEXT(5),
        BYTE_STRING_SPACE(6),
        JOURNAL_SPACE(7),
        USER_PROFILE(8),
        JOURNAL_PORT(9),
        QUEUE(10),
        DATA_SPACE(11),
        DATA_SPACE_INDEX(12),
        CURSOR(13),
        INDEX(14),
        COMMIT_BLOCK(15),
        DEVICE_DESCRIPTION(16),
        LINE_DESCRIPTION(17),
        CONTROLLER_DESCRIPTION(18),
        DUMP_SPACE(19),
        CLASS_OF_SERVICE(20),
        MODE(21),
        NETWORK_INTERFCE_DESCRIPTION(22),
        CONNECTION_LIST(23),
        QUEUE_SPACE(24),
        SPACE(25),
        PROCESS_CONTROL_SPACE(26),
        AUTHORIZATION_LIST(27),
        DICTIONARY(28),
        AUXILIARY_SERVER_DESCRIPTION(29),
        BYTE_STREAM_FILE(30),
        COMPOSITE_OBJECT_GROUP(33),
        DIRECTORY(34),
        TRANSACTION_CONTROL_STRUCTURE(35),
        MACHINE_CONTEXT(36),
        STREAM(37);

        private final long id;
        ObjectType(long id) { this.id = id; }
        public long id() { return id; }
        private static final Map<Long, ObjectType> byId = new HashMap<Long, ObjectType>(35);
        static {
            for (ObjectType e : ObjectType.values())
                byId.put(e.id(), e);
        }
        public static ObjectType byId(long id) { return byId.get(id); }
    }

    public Pgm(KaitaiStream _io) {
        this(_io, null, null);
    }

    public Pgm(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public Pgm(KaitaiStream _io, KaitaiStruct _parent, Pgm _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.savf = new SavfHeader(this._io, this, _root);
        this.mainSegment = new MainSegmentHeader(this._io, this, _root);
        this.segments = new ArrayList<Segment>();
        {
            int i = 0;
            while (!this._io.isEof()) {
                this.segments.add(new Segment(this._io, this, _root));
                i++;
            }
        }
    }
    public static class ModuleStringDirectory extends KaitaiStruct {
        public static ModuleStringDirectory fromFile(String fileName) throws IOException {
            return new ModuleStringDirectory(new ByteBufferKaitaiStream(fileName));
        }

        public ModuleStringDirectory(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ModuleStringDirectory(KaitaiStream _io, Pgm.ModuleHeader _parent) {
            this(_io, _parent, null);
        }

        public ModuleStringDirectory(KaitaiStream _io, Pgm.ModuleHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.dirLength = this._io.readU4be();
            this.reserved0 = this._io.readBytes(12);
            this._raw_entries = this._io.readBytes((dirLength() - 16));
            KaitaiStream _io__raw_entries = new ByteBufferKaitaiStream(_raw_entries);
            this.entries = new StringDirectoryEntries(_io__raw_entries, this, _root);
        }
        private long dirLength;
        private byte[] reserved0;
        private StringDirectoryEntries entries;
        private Pgm _root;
        private Pgm.ModuleHeader _parent;
        private byte[] _raw_entries;
        public long dirLength() { return dirLength; }
        public byte[] reserved0() { return reserved0; }
        public StringDirectoryEntries entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm.ModuleHeader _parent() { return _parent; }
        public byte[] _raw_entries() { return _raw_entries; }
    }
    public static class VersionTable extends KaitaiStruct {
        public static VersionTable fromFile(String fileName) throws IOException {
            return new VersionTable(new ByteBufferKaitaiStream(fileName));
        }

        public VersionTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public VersionTable(KaitaiStream _io, Pgm.ModuleHeader _parent) {
            this(_io, _parent, null);
        }

        public VersionTable(KaitaiStream _io, Pgm.ModuleHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.version = this._io.readU1();
            this.mmVrmOxLevel = this._io.readU1();
            this.languageVrm = this._io.readU2be();
            this.mmVrm = this._io.readU2be();
            this.oxVrm = this._io.readU2be();
            this.modIntVrm = this._io.readU2be();
            this.instructionVrm = this._io.readU2be();
            this.targetVrm = this._io.readU2be();
            this.createOnVrm = this._io.readU2be();
            this.optLevel = this._io.readU2be();
            this.ccsid = this._io.readU2be();
            this.fromModName = this._io.readBytes(30);
            this.fromModQual = this._io.readBytes(30);
            this.compilerName = this._io.readBytes(20);
            this.earlyCompVrm = this._io.readU2be();
            this.reserved0 = this._io.readU2be();
        }
        private int version;
        private int mmVrmOxLevel;
        private int languageVrm;
        private int mmVrm;
        private int oxVrm;
        private int modIntVrm;
        private int instructionVrm;
        private int targetVrm;
        private int createOnVrm;
        private int optLevel;
        private int ccsid;
        private byte[] fromModName;
        private byte[] fromModQual;
        private byte[] compilerName;
        private int earlyCompVrm;
        private int reserved0;
        private Pgm _root;
        private Pgm.ModuleHeader _parent;
        public int version() { return version; }
        public int mmVrmOxLevel() { return mmVrmOxLevel; }
        public int languageVrm() { return languageVrm; }
        public int mmVrm() { return mmVrm; }
        public int oxVrm() { return oxVrm; }
        public int modIntVrm() { return modIntVrm; }
        public int instructionVrm() { return instructionVrm; }
        public int targetVrm() { return targetVrm; }
        public int createOnVrm() { return createOnVrm; }
        public int optLevel() { return optLevel; }
        public int ccsid() { return ccsid; }
        public byte[] fromModName() { return fromModName; }
        public byte[] fromModQual() { return fromModQual; }
        public byte[] compilerName() { return compilerName; }
        public int earlyCompVrm() { return earlyCompVrm; }
        public int reserved0() { return reserved0; }
        public Pgm _root() { return _root; }
        public Pgm.ModuleHeader _parent() { return _parent; }
    }
    public static class ModuleObservabilityInformation extends KaitaiStruct {
        public static ModuleObservabilityInformation fromFile(String fileName) throws IOException {
            return new ModuleObservabilityInformation(new ByteBufferKaitaiStream(fileName));
        }

        public ModuleObservabilityInformation(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ModuleObservabilityInformation(KaitaiStream _io, Pgm.ModuleHeader _parent) {
            this(_io, _parent, null);
        }

        public ModuleObservabilityInformation(KaitaiStream _io, Pgm.ModuleHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.version = this._io.readU1();
            this.reserved = this._io.readBytes(7);
            this.crtmodTmplPtr = this._io.readU8be();
            this.dictionaryPtr = this._io.readU8be();
            this.aliasPtr = this._io.readU8be();
            this.typeInfoPtr = this._io.readU8be();
            this.litPoolPtr = this._io.readU8be();
            this.instructionPtr = this._io.readU8be();
            this.initPtr = this._io.readU8be();
            this.bindSpecPtr = this._io.readU8be();
            this.dmtPtr = new Addr(this._io, this, _root);
            this.tmplExtSegoff = this._io.readU8be();
            this.bbpSegoff = this._io.readU8be();
            this.funcProSegoff = this._io.readU8be();
            this.class1ObsCrt = this._io.readU4be();
            this.obsExistNow = this._io.readU4be();
            this.obsDeletable = this._io.readU4be();
            this.reserved0 = this._io.readBytes(12);
        }
        private DictionaryMappingTable dictionaryMappingTable;
        public DictionaryMappingTable dictionaryMappingTable() {
            if (this.dictionaryMappingTable != null)
                return this.dictionaryMappingTable;
            long _pos = this._io.pos();
            this._io.seek((dmtPtr().offset() + 4096));
            this.dictionaryMappingTable = new DictionaryMappingTable(this._io, this, _root);
            this._io.seek(_pos);
            return this.dictionaryMappingTable;
        }
        private int version;
        private byte[] reserved;
        private long crtmodTmplPtr;
        private long dictionaryPtr;
        private long aliasPtr;
        private long typeInfoPtr;
        private long litPoolPtr;
        private long instructionPtr;
        private long initPtr;
        private long bindSpecPtr;
        private Addr dmtPtr;
        private long tmplExtSegoff;
        private long bbpSegoff;
        private long funcProSegoff;
        private long class1ObsCrt;
        private long obsExistNow;
        private long obsDeletable;
        private byte[] reserved0;
        private Pgm _root;
        private Pgm.ModuleHeader _parent;
        public int version() { return version; }
        public byte[] reserved() { return reserved; }
        public long crtmodTmplPtr() { return crtmodTmplPtr; }
        public long dictionaryPtr() { return dictionaryPtr; }
        public long aliasPtr() { return aliasPtr; }
        public long typeInfoPtr() { return typeInfoPtr; }
        public long litPoolPtr() { return litPoolPtr; }
        public long instructionPtr() { return instructionPtr; }
        public long initPtr() { return initPtr; }
        public long bindSpecPtr() { return bindSpecPtr; }
        public Addr dmtPtr() { return dmtPtr; }
        public long tmplExtSegoff() { return tmplExtSegoff; }
        public long bbpSegoff() { return bbpSegoff; }
        public long funcProSegoff() { return funcProSegoff; }
        public long class1ObsCrt() { return class1ObsCrt; }
        public long obsExistNow() { return obsExistNow; }
        public long obsDeletable() { return obsDeletable; }
        public byte[] reserved0() { return reserved0; }
        public Pgm _root() { return _root; }
        public Pgm.ModuleHeader _parent() { return _parent; }
    }
    public static class ProgramHeader extends KaitaiStruct {
        public static ProgramHeader fromFile(String fileName) throws IOException {
            return new ProgramHeader(new ByteBufferKaitaiStream(fileName));
        }

        public ProgramHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProgramHeader(KaitaiStream _io, Pgm.MainSegmentHeader _parent) {
            this(_io, _parent, null);
        }

        public ProgramHeader(KaitaiStream _io, Pgm.MainSegmentHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.programHeader = new ProgramHeaderBase(this._io, this, _root);
            this.programHeaderExt = new ProgramHeaderExtension(this._io, this, _root);
        }
        private ProgramHeaderBase programHeader;
        private ProgramHeaderExtension programHeaderExt;
        private Pgm _root;
        private Pgm.MainSegmentHeader _parent;
        public ProgramHeaderBase programHeader() { return programHeader; }
        public ProgramHeaderExtension programHeaderExt() { return programHeaderExt; }
        public Pgm _root() { return _root; }
        public Pgm.MainSegmentHeader _parent() { return _parent; }
    }
    public static class ExceptionHandlerDeclarationTable extends KaitaiStruct {
        public static ExceptionHandlerDeclarationTable fromFile(String fileName) throws IOException {
            return new ExceptionHandlerDeclarationTable(new ByteBufferKaitaiStream(fileName));
        }

        public ExceptionHandlerDeclarationTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ExceptionHandlerDeclarationTable(KaitaiStream _io, Pgm.EhTables _parent) {
            this(_io, _parent, null);
        }

        public ExceptionHandlerDeclarationTable(KaitaiStream _io, Pgm.EhTables _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.length = this._io.readU4be();
            this.version = this._io.readU4be();
            this.lastEntryIdx = this._io.readU4be();
            this.reserved0 = this._io.readU4be();
            this.pgmModel = this._io.readU1();
            this.reserved1 = this._io.readBytes(1);
            this.opmExcMonCnt = this._io.readU2be();
            this.iexitEntry = this._io.readU4be();
            this.reserved2 = this._io.readBytes(8);
            this.entries = new ArrayList<EhDeclarationEntry>();
            for (int i = 0; i < lastEntryIdx(); i++) {
                this.entries.add(new EhDeclarationEntry(this._io, this, _root));
            }
        }
        private long length;
        private long version;
        private long lastEntryIdx;
        private long reserved0;
        private int pgmModel;
        private byte[] reserved1;
        private int opmExcMonCnt;
        private long iexitEntry;
        private byte[] reserved2;
        private ArrayList<EhDeclarationEntry> entries;
        private Pgm _root;
        private Pgm.EhTables _parent;
        public long length() { return length; }
        public long version() { return version; }
        public long lastEntryIdx() { return lastEntryIdx; }
        public long reserved0() { return reserved0; }
        public int pgmModel() { return pgmModel; }
        public byte[] reserved1() { return reserved1; }
        public int opmExcMonCnt() { return opmExcMonCnt; }
        public long iexitEntry() { return iexitEntry; }
        public byte[] reserved2() { return reserved2; }
        public ArrayList<EhDeclarationEntry> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm.EhTables _parent() { return _parent; }
    }
    public static class SegmentGroupHeader extends KaitaiStruct {
        public static SegmentGroupHeader fromFile(String fileName) throws IOException {
            return new SegmentGroupHeader(new ByteBufferKaitaiStream(fileName));
        }

        public SegmentGroupHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public SegmentGroupHeader(KaitaiStream _io, Pgm.MainSegmentHeader _parent) {
            this(_io, _parent, null);
        }

        public SegmentGroupHeader(KaitaiStream _io, Pgm.MainSegmentHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.programType = this._io.readU2be();
            this.programSize = this._io.readU2be();
            this.newFlags = this._io.readU1();
            this.flags = this._io.readU1();
            this.shUnk0 = this._io.readBytes(2);
            this.address = this._io.readU8be();
            this.shUnk1 = this._io.readU8be();
            this.objectSpace = this._io.readU8be();
        }
        private int programType;
        private int programSize;
        private int newFlags;
        private int flags;
        private byte[] shUnk0;
        private long address;
        private long shUnk1;
        private long objectSpace;
        private Pgm _root;
        private Pgm.MainSegmentHeader _parent;
        public int programType() { return programType; }
        public int programSize() { return programSize; }
        public int newFlags() { return newFlags; }
        public int flags() { return flags; }
        public byte[] shUnk0() { return shUnk0; }
        public long address() { return address; }
        public long shUnk1() { return shUnk1; }
        public long objectSpace() { return objectSpace; }
        public Pgm _root() { return _root; }
        public Pgm.MainSegmentHeader _parent() { return _parent; }
    }
    public static class StringDirectoryEntries extends KaitaiStruct {
        public static StringDirectoryEntries fromFile(String fileName) throws IOException {
            return new StringDirectoryEntries(new ByteBufferKaitaiStream(fileName));
        }

        public StringDirectoryEntries(KaitaiStream _io) {
            this(_io, null, null);
        }

        public StringDirectoryEntries(KaitaiStream _io, Pgm.ModuleStringDirectory _parent) {
            this(_io, _parent, null);
        }

        public StringDirectoryEntries(KaitaiStream _io, Pgm.ModuleStringDirectory _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.entries = new ArrayList<PrefixedString>();
            {
                int i = 0;
                while (!this._io.isEof()) {
                    this.entries.add(new PrefixedString(this._io, this, _root));
                    i++;
                }
            }
        }
        private ArrayList<PrefixedString> entries;
        private Pgm _root;
        private Pgm.ModuleStringDirectory _parent;
        public ArrayList<PrefixedString> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm.ModuleStringDirectory _parent() { return _parent; }
    }
    public static class StaticActivationHeader extends KaitaiStruct {
        public static StaticActivationHeader fromFile(String fileName) throws IOException {
            return new StaticActivationHeader(new ByteBufferKaitaiStream(fileName));
        }

        public StaticActivationHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public StaticActivationHeader(KaitaiStream _io, Pgm _parent) {
            this(_io, _parent, null);
        }

        public StaticActivationHeader(KaitaiStream _io, Pgm _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pgAddress = this._io.readU8be();
            this.reserved0 = this._io.readBytes(24);
        }
        private long pgAddress;
        private byte[] reserved0;
        private Pgm _root;
        private Pgm _parent;
        public long pgAddress() { return pgAddress; }
        public byte[] reserved0() { return reserved0; }
        public Pgm _root() { return _root; }
        public Pgm _parent() { return _parent; }
    }
    public static class ModuleTable extends KaitaiStruct {
        public static ModuleTable fromFile(String fileName) throws IOException {
            return new ModuleTable(new ByteBufferKaitaiStream(fileName));
        }

        public ModuleTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ModuleTable(KaitaiStream _io, Pgm.ProgramHeaderBase _parent) {
            this(_io, _parent, null);
        }

        public ModuleTable(KaitaiStream _io, Pgm.ProgramHeaderBase _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.tableSize = this._io.readU4be();
            this.tableEntryCnt = this._io.readU4be();
            this.tableVersion = this._io.readU1();
            this.reserved = this._io.readBytes(7);
            this._raw_tableEntries = new ArrayList<byte[]>();
            this.tableEntries = new ArrayList<ModuleTableEntry>();
            for (int i = 0; i < tableEntryCnt(); i++) {
                this._raw_tableEntries.add(this._io.readBytes((tableSize() - 16)));
                KaitaiStream _io__raw_tableEntries = new ByteBufferKaitaiStream(_raw_tableEntries.get(_raw_tableEntries.size() - 1));
                this.tableEntries.add(new ModuleTableEntry(_io__raw_tableEntries, this, _root));
            }
        }
        private long tableSize;
        private long tableEntryCnt;
        private int tableVersion;
        private byte[] reserved;
        private ArrayList<ModuleTableEntry> tableEntries;
        private Pgm _root;
        private Pgm.ProgramHeaderBase _parent;
        private ArrayList<byte[]> _raw_tableEntries;
        public long tableSize() { return tableSize; }
        public long tableEntryCnt() { return tableEntryCnt; }
        public int tableVersion() { return tableVersion; }
        public byte[] reserved() { return reserved; }
        public ArrayList<ModuleTableEntry> tableEntries() { return tableEntries; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderBase _parent() { return _parent; }
        public ArrayList<byte[]> _raw_tableEntries() { return _raw_tableEntries; }
    }
    public static class StringDirectoryEntriesFf extends KaitaiStruct {
        public static StringDirectoryEntriesFf fromFile(String fileName) throws IOException {
            return new StringDirectoryEntriesFf(new ByteBufferKaitaiStream(fileName));
        }

        public StringDirectoryEntriesFf(KaitaiStream _io) {
            this(_io, null, null);
        }

        public StringDirectoryEntriesFf(KaitaiStream _io, Pgm.ProgramStringDirectory _parent) {
            this(_io, _parent, null);
        }

        public StringDirectoryEntriesFf(KaitaiStream _io, Pgm.ProgramStringDirectory _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.entries = new ArrayList<PrefixedStringFf>();
            {
                int i = 0;
                while (!this._io.isEof()) {
                    this.entries.add(new PrefixedStringFf(this._io, this, _root));
                    i++;
                }
            }
        }
        private ArrayList<PrefixedStringFf> entries;
        private Pgm _root;
        private Pgm.ProgramStringDirectory _parent;
        public ArrayList<PrefixedStringFf> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramStringDirectory _parent() { return _parent; }
    }
    public static class ActivationHeader extends KaitaiStruct {
        public static ActivationHeader fromFile(String fileName) throws IOException {
            return new ActivationHeader(new ByteBufferKaitaiStream(fileName));
        }

        public ActivationHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ActivationHeader(KaitaiStream _io, Pgm.ProgramHeaderBase _parent) {
            this(_io, _parent, null);
        }

        public ActivationHeader(KaitaiStream _io, Pgm.ProgramHeaderBase _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.pepEntryPoint = new Addr(this._io, this, _root);
            this.pbvSize = this._io.readU4be();
            this.pbvOrigin = this._io.readU4be();
            this.pbvRelocPtr = new Addr(this._io, this, _root);
            this.staticPbvPtr = new Addr(this._io, this, _root);
            this.pbvRelocCnt = this._io.readU4be();
            this.depSrvpgmCnt = this._io.readU4be();
            this.depSrvpgmArry = this._io.readU8be();
            this.staticFdefPtr = new Addr(this._io, this, _root);
            this.staticFdefCnt = this._io.readU4be();
            this.globStatFrCount = this._io.readU4be();
            this.staticSecFrCnt = this._io.readU4be();
            this.tlStatFrCnt = this._io.readU4be();
            this.condStFrCnt = this._io.readU4be();
            this.constFrameCnt = this._io.readU4be();
            this.constFramePtr = new Addr(this._io, this, _root);
            this.exprtArryPtr = new Addr(this._io, this, _root);
            this.exprtArryCnt = this._io.readU4be();
            this.dataExportCnt = this._io.readU4be();
            this.procExportCnt = this._io.readU4be();
            this.exprtAliasCnt = this._io.readU4be();
            this.exprtAliasPtr = new Addr(this._io, this, _root);
            this.funcLoctrPtr = new Addr(this._io, this, _root);
            this.funcLoctrCnt = this._io.readU4be();
            this.addrTknFnCnt = this._io.readU4be();
            this.nonArgoptCnt = this._io.readU4be();
            this.argoptFnCnt = this._io.readU4be();
            this.legUnrsFnPtr = new Addr(this._io, this, _root);
            this.legUnrsFnCnt = this._io.readU4be();
            this.dataLoctrCnt = this._io.readU4be();
            this.dataLocatrPtr = new Addr(this._io, this, _root);
            this.fncImportPtr = new Addr(this._io, this, _root);
            this.fnfImportCnt = this._io.readU4be();
            this.dataImportCnt = this._io.readU4be();
            this.dataImportPtr = new Addr(this._io, this, _root);
            this.unrsDirFnPtr = new Addr(this._io, this, _root);
            this.unrsDirFnCnt = this._io.readU4be();
            this.dynDatExpCnt = this._io.readU4be();
            this.dynDatExpPtr = new Addr(this._io, this, _root);
            this.extDataTbPtr = new Addr(this._io, this, _root);
            this.jvPermClsPtr = new Addr(this._io, this, _root);
            this.jvPrmHashPtr = new Addr(this._io, this, _root);
            this.dataSizePtr = new Addr(this._io, this, _root);
            this.reserved = this._io.readBytes(48);
        }
        private Addr pepEntryPoint;
        private long pbvSize;
        private long pbvOrigin;
        private Addr pbvRelocPtr;
        private Addr staticPbvPtr;
        private long pbvRelocCnt;
        private long depSrvpgmCnt;
        private long depSrvpgmArry;
        private Addr staticFdefPtr;
        private long staticFdefCnt;
        private long globStatFrCount;
        private long staticSecFrCnt;
        private long tlStatFrCnt;
        private long condStFrCnt;
        private long constFrameCnt;
        private Addr constFramePtr;
        private Addr exprtArryPtr;
        private long exprtArryCnt;
        private long dataExportCnt;
        private long procExportCnt;
        private long exprtAliasCnt;
        private Addr exprtAliasPtr;
        private Addr funcLoctrPtr;
        private long funcLoctrCnt;
        private long addrTknFnCnt;
        private long nonArgoptCnt;
        private long argoptFnCnt;
        private Addr legUnrsFnPtr;
        private long legUnrsFnCnt;
        private long dataLoctrCnt;
        private Addr dataLocatrPtr;
        private Addr fncImportPtr;
        private long fnfImportCnt;
        private long dataImportCnt;
        private Addr dataImportPtr;
        private Addr unrsDirFnPtr;
        private long unrsDirFnCnt;
        private long dynDatExpCnt;
        private Addr dynDatExpPtr;
        private Addr extDataTbPtr;
        private Addr jvPermClsPtr;
        private Addr jvPrmHashPtr;
        private Addr dataSizePtr;
        private byte[] reserved;
        private Pgm _root;
        private Pgm.ProgramHeaderBase _parent;
        public Addr pepEntryPoint() { return pepEntryPoint; }
        public long pbvSize() { return pbvSize; }
        public long pbvOrigin() { return pbvOrigin; }
        public Addr pbvRelocPtr() { return pbvRelocPtr; }
        public Addr staticPbvPtr() { return staticPbvPtr; }
        public long pbvRelocCnt() { return pbvRelocCnt; }
        public long depSrvpgmCnt() { return depSrvpgmCnt; }
        public long depSrvpgmArry() { return depSrvpgmArry; }
        public Addr staticFdefPtr() { return staticFdefPtr; }
        public long staticFdefCnt() { return staticFdefCnt; }
        public long globStatFrCount() { return globStatFrCount; }
        public long staticSecFrCnt() { return staticSecFrCnt; }
        public long tlStatFrCnt() { return tlStatFrCnt; }
        public long condStFrCnt() { return condStFrCnt; }
        public long constFrameCnt() { return constFrameCnt; }
        public Addr constFramePtr() { return constFramePtr; }
        public Addr exprtArryPtr() { return exprtArryPtr; }
        public long exprtArryCnt() { return exprtArryCnt; }
        public long dataExportCnt() { return dataExportCnt; }
        public long procExportCnt() { return procExportCnt; }
        public long exprtAliasCnt() { return exprtAliasCnt; }
        public Addr exprtAliasPtr() { return exprtAliasPtr; }
        public Addr funcLoctrPtr() { return funcLoctrPtr; }
        public long funcLoctrCnt() { return funcLoctrCnt; }
        public long addrTknFnCnt() { return addrTknFnCnt; }
        public long nonArgoptCnt() { return nonArgoptCnt; }
        public long argoptFnCnt() { return argoptFnCnt; }
        public Addr legUnrsFnPtr() { return legUnrsFnPtr; }
        public long legUnrsFnCnt() { return legUnrsFnCnt; }
        public long dataLoctrCnt() { return dataLoctrCnt; }
        public Addr dataLocatrPtr() { return dataLocatrPtr; }
        public Addr fncImportPtr() { return fncImportPtr; }
        public long fnfImportCnt() { return fnfImportCnt; }
        public long dataImportCnt() { return dataImportCnt; }
        public Addr dataImportPtr() { return dataImportPtr; }
        public Addr unrsDirFnPtr() { return unrsDirFnPtr; }
        public long unrsDirFnCnt() { return unrsDirFnCnt; }
        public long dynDatExpCnt() { return dynDatExpCnt; }
        public Addr dynDatExpPtr() { return dynDatExpPtr; }
        public Addr extDataTbPtr() { return extDataTbPtr; }
        public Addr jvPermClsPtr() { return jvPermClsPtr; }
        public Addr jvPrmHashPtr() { return jvPrmHashPtr; }
        public Addr dataSizePtr() { return dataSizePtr; }
        public byte[] reserved() { return reserved; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderBase _parent() { return _parent; }
    }
    public static class PrefixedString extends KaitaiStruct {
        public static PrefixedString fromFile(String fileName) throws IOException {
            return new PrefixedString(new ByteBufferKaitaiStream(fileName));
        }

        public PrefixedString(KaitaiStream _io) {
            this(_io, null, null);
        }

        public PrefixedString(KaitaiStream _io, Pgm.StringDirectoryEntries _parent) {
            this(_io, _parent, null);
        }

        public PrefixedString(KaitaiStream _io, Pgm.StringDirectoryEntries _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.lenStringBytes = this._io.readU4be();
            this.stringBytes = this._io.readBytes(lenStringBytes());
        }
        private long lenStringBytes;
        private byte[] stringBytes;
        private Pgm _root;
        private Pgm.StringDirectoryEntries _parent;
        public long lenStringBytes() { return lenStringBytes; }
        public byte[] stringBytes() { return stringBytes; }
        public Pgm _root() { return _root; }
        public Pgm.StringDirectoryEntries _parent() { return _parent; }
    }
    public static class CiicEntry extends KaitaiStruct {
        public static CiicEntry fromFile(String fileName) throws IOException {
            return new CiicEntry(new ByteBufferKaitaiStream(fileName));
        }

        public CiicEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public CiicEntry(KaitaiStream _io, Pgm.CallInterfaceInformationComponent _parent) {
            this(_io, _parent, null);
        }

        public CiicEntry(KaitaiStream _io, Pgm.CallInterfaceInformationComponent _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.reserved1 = this._io.readU1();
            this.paramIndex = this._io.readBytes(3);
            this.flags = this._io.readU2be();
            this.reserved2 = this._io.readBytes(2);
        }
        private int reserved1;
        private byte[] paramIndex;
        private int flags;
        private byte[] reserved2;
        private Pgm _root;
        private Pgm.CallInterfaceInformationComponent _parent;
        public int reserved1() { return reserved1; }
        public byte[] paramIndex() { return paramIndex; }
        public int flags() { return flags; }
        public byte[] reserved2() { return reserved2; }
        public Pgm _root() { return _root; }
        public Pgm.CallInterfaceInformationComponent _parent() { return _parent; }
    }
    public static class SegmentTableExtensionEntry extends KaitaiStruct {
        public static SegmentTableExtensionEntry fromFile(String fileName) throws IOException {
            return new SegmentTableExtensionEntry(new ByteBufferKaitaiStream(fileName));
        }

        public SegmentTableExtensionEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public SegmentTableExtensionEntry(KaitaiStream _io, Pgm.SegmentTableExtensionTable _parent) {
            this(_io, _parent, null);
        }

        public SegmentTableExtensionEntry(KaitaiStream _io, Pgm.SegmentTableExtensionTable _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.bytesUsed = this._io.readU4be();
            this.reserved0 = this._io.readBytes(20);
        }
        private long bytesUsed;
        private byte[] reserved0;
        private Pgm _root;
        private Pgm.SegmentTableExtensionTable _parent;
        public long bytesUsed() { return bytesUsed; }
        public byte[] reserved0() { return reserved0; }
        public Pgm _root() { return _root; }
        public Pgm.SegmentTableExtensionTable _parent() { return _parent; }
    }
    public static class ProgramHeaderBase extends KaitaiStruct {
        public static ProgramHeaderBase fromFile(String fileName) throws IOException {
            return new ProgramHeaderBase(new ByteBufferKaitaiStream(fileName));
        }

        public ProgramHeaderBase(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProgramHeaderBase(KaitaiStream _io, Pgm.ProgramHeader _parent) {
            this(_io, _parent, null);
        }

        public ProgramHeaderBase(KaitaiStream _io, Pgm.ProgramHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.prograAttrs = this._io.readBytes(8);
            this.versionTblPtr = new Addr(this._io, this, _root);
            this.segmentTblPtr = new Addr(this._io, this, _root);
            this.actHdrPtr = new Addr(this._io, this, _root);
            this.sigTblPtr = new Addr(this._io, this, _root);
            this.stringDirPtr = new Addr(this._io, this, _root);
            this.actGrpInfPtr = new Addr(this._io, this, _root);
            this.actTest = new Addr(this._io, this, _root);
            this.actStr = new Addr(this._io, this, _root);
            this.actEnd = new Addr(this._io, this, _root);
            this.actAndPepEnd = new Addr(this._io, this, _root);
            this.flags = this._io.readU2be();
            this.bringSize = this._io.readU1();
            this.hyperspcAttrs = this._io.readU1();
            this.programState = this._io.readU2be();
            this.objChkrInd = this._io.readU2be();
            this.expAndSigStr = this._io.readU8be();
            this.expAdnSigEnd = this._io.readU8be();
            this.stringDirStr = this._io.readU8be();
            this.stringDirEnd = this._io.readU8be();
            this.wrtPgmHdrPtr = new Addr(this._io, this, _root);
            this.reserved0 = this._io.readBytes(8);
            this.programType = this._io.readU1();
            this.reserved1 = this._io.readBytes(3);
            this.pepModNbr = this._io.readU4be();
            this.pepProcNbr = this._io.readU4be();
            this.pepStringId = this._io.readU4be();
            this.pepMinParms = this._io.readU2be();
            this.pepMaxParms = this._io.readU2be();
            this.programChecksum = this._io.readBytes(4);
            this.formatLevel = this._io.readU4be();
            this.cnvPgmTbInfo = this._io.readU8be();
            this.reserved2 = this._io.readBytes(24);
            this.unknown1 = this._io.readU4be();
            this.pgmHdrExt = new Addr(this._io, this, _root);
            this.trcbckLocPtr = new Addr(this._io, this, _root);
            this.moduleTblPtr = new Addr(this._io, this, _root);
            this.obsInfoPtr = new Addr(this._io, this, _root);
            this.mainHdrPtr = new Addr(this._io, this, _root);
            this.exampPtr = new Addr(this._io, this, _root);
        }
        private TracebackLocatorTable tracebackLocatorTable;
        public TracebackLocatorTable tracebackLocatorTable() {
            if (this.tracebackLocatorTable != null)
                return this.tracebackLocatorTable;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((trcbckLocPtr().offset() + 4096));
            this.tracebackLocatorTable = new TracebackLocatorTable(io, this, _root);
            io.seek(_pos);
            return this.tracebackLocatorTable;
        }
        private WritableProgramHeader writablePgmHeader;
        public WritableProgramHeader writablePgmHeader() {
            if (this.writablePgmHeader != null)
                return this.writablePgmHeader;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((wrtPgmHdrPtr().offset() + 4096));
            this.writablePgmHeader = new WritableProgramHeader(io, this, _root);
            io.seek(_pos);
            return this.writablePgmHeader;
        }
        private ModuleTable moduleTable;
        public ModuleTable moduleTable() {
            if (this.moduleTable != null)
                return this.moduleTable;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((moduleTblPtr().offset() + 4096));
            this.moduleTable = new ModuleTable(io, this, _root);
            io.seek(_pos);
            return this.moduleTable;
        }
        private SegmentTable segmentTable;
        public SegmentTable segmentTable() {
            if (this.segmentTable != null)
                return this.segmentTable;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((segmentTblPtr().offset() + 4096));
            this.segmentTable = new SegmentTable(io, this, _root);
            io.seek(_pos);
            return this.segmentTable;
        }
        private ProgramObservabilityInfoHeader programObservabilityInfoHeader;
        public ProgramObservabilityInfoHeader programObservabilityInfoHeader() {
            if (this.programObservabilityInfoHeader != null)
                return this.programObservabilityInfoHeader;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((obsInfoPtr().offset() + 4096));
            this.programObservabilityInfoHeader = new ProgramObservabilityInfoHeader(io, this, _root);
            io.seek(_pos);
            return this.programObservabilityInfoHeader;
        }
        private ActivationGroupInformation activationGroupInformation;
        public ActivationGroupInformation activationGroupInformation() {
            if (this.activationGroupInformation != null)
                return this.activationGroupInformation;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((actGrpInfPtr().offset() + 4096));
            this.activationGroupInformation = new ActivationGroupInformation(io, this, _root);
            io.seek(_pos);
            return this.activationGroupInformation;
        }
        private ProgramVersionTable pgmVersionTable;
        public ProgramVersionTable pgmVersionTable() {
            if (this.pgmVersionTable != null)
                return this.pgmVersionTable;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((versionTblPtr().offset() + 4096));
            this.pgmVersionTable = new ProgramVersionTable(io, this, _root);
            io.seek(_pos);
            return this.pgmVersionTable;
        }
        private ActivationHeader activationHeader;
        public ActivationHeader activationHeader() {
            if (this.activationHeader != null)
                return this.activationHeader;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((actHdrPtr().offset() + 4096));
            this.activationHeader = new ActivationHeader(io, this, _root);
            io.seek(_pos);
            return this.activationHeader;
        }
        private ProgramMaintenanceHeader programMaintenanceHeader;
        public ProgramMaintenanceHeader programMaintenanceHeader() {
            if (this.programMaintenanceHeader != null)
                return this.programMaintenanceHeader;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((mainHdrPtr().offset() + 4096));
            this.programMaintenanceHeader = new ProgramMaintenanceHeader(io, this, _root);
            io.seek(_pos);
            return this.programMaintenanceHeader;
        }
        private ProgramStringDirectory programStringDirectory;
        public ProgramStringDirectory programStringDirectory() {
            if (this.programStringDirectory != null)
                return this.programStringDirectory;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((stringDirPtr().offset() + 4096));
            this.programStringDirectory = new ProgramStringDirectory(io, this, _root);
            io.seek(_pos);
            return this.programStringDirectory;
        }
        private byte[] prograAttrs;
        private Addr versionTblPtr;
        private Addr segmentTblPtr;
        private Addr actHdrPtr;
        private Addr sigTblPtr;
        private Addr stringDirPtr;
        private Addr actGrpInfPtr;
        private Addr actTest;
        private Addr actStr;
        private Addr actEnd;
        private Addr actAndPepEnd;
        private int flags;
        private int bringSize;
        private int hyperspcAttrs;
        private int programState;
        private int objChkrInd;
        private long expAndSigStr;
        private long expAdnSigEnd;
        private long stringDirStr;
        private long stringDirEnd;
        private Addr wrtPgmHdrPtr;
        private byte[] reserved0;
        private int programType;
        private byte[] reserved1;
        private long pepModNbr;
        private long pepProcNbr;
        private long pepStringId;
        private int pepMinParms;
        private int pepMaxParms;
        private byte[] programChecksum;
        private long formatLevel;
        private long cnvPgmTbInfo;
        private byte[] reserved2;
        private long unknown1;
        private Addr pgmHdrExt;
        private Addr trcbckLocPtr;
        private Addr moduleTblPtr;
        private Addr obsInfoPtr;
        private Addr mainHdrPtr;
        private Addr exampPtr;
        private Pgm _root;
        private Pgm.ProgramHeader _parent;
        public byte[] prograAttrs() { return prograAttrs; }
        public Addr versionTblPtr() { return versionTblPtr; }
        public Addr segmentTblPtr() { return segmentTblPtr; }
        public Addr actHdrPtr() { return actHdrPtr; }
        public Addr sigTblPtr() { return sigTblPtr; }
        public Addr stringDirPtr() { return stringDirPtr; }
        public Addr actGrpInfPtr() { return actGrpInfPtr; }
        public Addr actTest() { return actTest; }
        public Addr actStr() { return actStr; }
        public Addr actEnd() { return actEnd; }
        public Addr actAndPepEnd() { return actAndPepEnd; }
        public int flags() { return flags; }
        public int bringSize() { return bringSize; }
        public int hyperspcAttrs() { return hyperspcAttrs; }
        public int programState() { return programState; }
        public int objChkrInd() { return objChkrInd; }
        public long expAndSigStr() { return expAndSigStr; }
        public long expAdnSigEnd() { return expAdnSigEnd; }
        public long stringDirStr() { return stringDirStr; }
        public long stringDirEnd() { return stringDirEnd; }
        public Addr wrtPgmHdrPtr() { return wrtPgmHdrPtr; }
        public byte[] reserved0() { return reserved0; }
        public int programType() { return programType; }
        public byte[] reserved1() { return reserved1; }
        public long pepModNbr() { return pepModNbr; }
        public long pepProcNbr() { return pepProcNbr; }
        public long pepStringId() { return pepStringId; }
        public int pepMinParms() { return pepMinParms; }
        public int pepMaxParms() { return pepMaxParms; }
        public byte[] programChecksum() { return programChecksum; }
        public long formatLevel() { return formatLevel; }
        public long cnvPgmTbInfo() { return cnvPgmTbInfo; }
        public byte[] reserved2() { return reserved2; }
        public long unknown1() { return unknown1; }
        public Addr pgmHdrExt() { return pgmHdrExt; }
        public Addr trcbckLocPtr() { return trcbckLocPtr; }
        public Addr moduleTblPtr() { return moduleTblPtr; }
        public Addr obsInfoPtr() { return obsInfoPtr; }
        public Addr mainHdrPtr() { return mainHdrPtr; }
        public Addr exampPtr() { return exampPtr; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeader _parent() { return _parent; }
    }
    public static class ProcedureExtTableEntry extends KaitaiStruct {
        public static ProcedureExtTableEntry fromFile(String fileName) throws IOException {
            return new ProcedureExtTableEntry(new ByteBufferKaitaiStream(fileName));
        }

        public ProcedureExtTableEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProcedureExtTableEntry(KaitaiStream _io, Pgm.ProcedureExtensionTable _parent) {
            this(_io, _parent, null);
        }

        public ProcedureExtTableEntry(KaitaiStream _io, Pgm.ProcedureExtensionTable _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.version = this._io.readU1();
            this.basicBlkAttrs = this._io.readU1();
            this.reserved0 = this._io.readBytes(2);
            this.offsetToAuto = this._io.readU4be();
            this.reserved = this._io.readBytes(4);
            this.trcbckTblSize = this._io.readU4be();
            this.trcbckTblPtr = this._io.readU8be();
            this.reserved1 = this._io.readBytes(36);
            this.interfaceIdx = this._io.readU4be();
            this.argoptSepIndex = this._io.readU4be();
            this.numOfDcfe = this._io.readU4be();
            this.numOfIdcfe = this._io.readU4be();
            this.firstDirFlow = this._io.readU4be();
            this.firstDirSite = this._io.readU4be();
            this.firstIndSite = this._io.readU4be();
            this.autoStorSize = this._io.readU4be();
            this.intPrcCallCt = this._io.readU4be();
        }
        private int version;
        private int basicBlkAttrs;
        private byte[] reserved0;
        private long offsetToAuto;
        private byte[] reserved;
        private long trcbckTblSize;
        private long trcbckTblPtr;
        private byte[] reserved1;
        private long interfaceIdx;
        private long argoptSepIndex;
        private long numOfDcfe;
        private long numOfIdcfe;
        private long firstDirFlow;
        private long firstDirSite;
        private long firstIndSite;
        private long autoStorSize;
        private long intPrcCallCt;
        private Pgm _root;
        private Pgm.ProcedureExtensionTable _parent;
        public int version() { return version; }
        public int basicBlkAttrs() { return basicBlkAttrs; }
        public byte[] reserved0() { return reserved0; }
        public long offsetToAuto() { return offsetToAuto; }
        public byte[] reserved() { return reserved; }
        public long trcbckTblSize() { return trcbckTblSize; }
        public long trcbckTblPtr() { return trcbckTblPtr; }
        public byte[] reserved1() { return reserved1; }
        public long interfaceIdx() { return interfaceIdx; }
        public long argoptSepIndex() { return argoptSepIndex; }
        public long numOfDcfe() { return numOfDcfe; }
        public long numOfIdcfe() { return numOfIdcfe; }
        public long firstDirFlow() { return firstDirFlow; }
        public long firstDirSite() { return firstDirSite; }
        public long firstIndSite() { return firstIndSite; }
        public long autoStorSize() { return autoStorSize; }
        public long intPrcCallCt() { return intPrcCallCt; }
        public Pgm _root() { return _root; }
        public Pgm.ProcedureExtensionTable _parent() { return _parent; }
    }
    public static class ActivationGroupInformation extends KaitaiStruct {
        public static ActivationGroupInformation fromFile(String fileName) throws IOException {
            return new ActivationGroupInformation(new ByteBufferKaitaiStream(fileName));
        }

        public ActivationGroupInformation(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ActivationGroupInformation(KaitaiStream _io, Pgm.ProgramHeaderBase _parent) {
            this(_io, _parent, null);
        }

        public ActivationGroupInformation(KaitaiStream _io, Pgm.ProgramHeaderBase _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.target = this._io.readU1();
            this.reserved0 = this._io.readU1();
            this.storageSelect = this._io.readU1();
            this.reserved1 = this._io.readU1();
            this.name = this._io.readBytes(30);
            this.reserved2 = this._io.readU2be();
            this.heapCrtSize = this._io.readU4be();
            this.heapExtSize = this._io.readU4be();
            this.heapCrtOpts = this._io.readU1();
            this.heapAllocVal = this._io.readU1();
            this.heapDealloVal = this._io.readU1();
            this.pagOptions = this._io.readU1();
            this.reserved3 = this._io.readBytes(80);
        }
        private int target;
        private int reserved0;
        private int storageSelect;
        private int reserved1;
        private byte[] name;
        private int reserved2;
        private long heapCrtSize;
        private long heapExtSize;
        private int heapCrtOpts;
        private int heapAllocVal;
        private int heapDealloVal;
        private int pagOptions;
        private byte[] reserved3;
        private Pgm _root;
        private Pgm.ProgramHeaderBase _parent;
        public int target() { return target; }
        public int reserved0() { return reserved0; }
        public int storageSelect() { return storageSelect; }
        public int reserved1() { return reserved1; }
        public byte[] name() { return name; }
        public int reserved2() { return reserved2; }
        public long heapCrtSize() { return heapCrtSize; }
        public long heapExtSize() { return heapExtSize; }
        public int heapCrtOpts() { return heapCrtOpts; }
        public int heapAllocVal() { return heapAllocVal; }
        public int heapDealloVal() { return heapDealloVal; }
        public int pagOptions() { return pagOptions; }
        public byte[] reserved3() { return reserved3; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderBase _parent() { return _parent; }
    }
    public static class ModuleHeader extends KaitaiStruct {
        public static ModuleHeader fromFile(String fileName) throws IOException {
            return new ModuleHeader(new ByteBufferKaitaiStream(fileName));
        }

        public ModuleHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ModuleHeader(KaitaiStream _io, Pgm.ModuleTableEntry _parent) {
            this(_io, _parent, null);
        }

        public ModuleHeader(KaitaiStream _io, Pgm.ModuleTableEntry _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.version = this._io.readU1();
            this.modType = this._io.readU1();
            this.modState = this._io.readU2be();
            this.reserved0 = this._io.readU4be();
            this.programHdrPtr = new Addr(this._io, this, _root);
            this.cpyrTblPtr = new Addr(this._io, this, _root);
            this.segmentTblPtr = new Addr(this._io, this, _root);
            this.versionTblPtr = new Addr(this._io, this, _root);
            this.bindInfoPtr = new Addr(this._io, this, _root);
            this.statInfoPtr = new Addr(this._io, this, _root);
            this.eolTblPtr = new Addr(this._io, this, _root);
            this.obsInfoPtr = new Addr(this._io, this, _root);
            this.stringDirPtr = new Addr(this._io, this, _root);
            this.entryptTblPtr = new Addr(this._io, this, _root);
            this.vlicTblPtr = new Addr(this._io, this, _root);
            this.pkgInfoPtr = new Addr(this._io, this, _root);
            this.procTblPtr = new Addr(this._io, this, _root);
            this.modConstPtr = new Addr(this._io, this, _root);
            this.ehdtPtr = new Addr(this._io, this, _root);
            this.ehmtlaPtr = new Addr(this._io, this, _root);
            this.motModBrgPtr = new Addr(this._io, this, _root);
            this.prePkgBrgPtr = new Addr(this._io, this, _root);
            this.miPtrConArea = this._io.readU8be();
            this.reserved1 = this._io.readU8be();
            this.modAttrs = this._io.readU2be();
            this.modObjAattrs = this._io.readU2be();
            this.pepDictId = this._io.readU4be();
            this.pepStringId = this._io.readU4be();
            this.pepProcNumber = this._io.readU4be();
            this.pepMinParms = this._io.readU2be();
            this.pepMaxParms = this._io.readU2be();
            this.maxMbvIdUsed = this._io.readU4be();
            this.modConstBody = this._io.readU1();
            this.xlationReason = this._io.readU1();
            this.pdcAttrs = this._io.readU1();
            this.hyperspcAttrs = this._io.readU1();
            this.formatLevel = this._io.readU4be();
            this.modHdrExtPtr = new Addr(this._io, this, _root);
            this.segtbExtSegoff = this._io.readU8be();
            this.reserved2 = this._io.readBytes(32);
            this.undocumentedModuleChecksum = this._io.readU8be();
        }
        private ModuleStringDirectory moduleStringDirectory;
        public ModuleStringDirectory moduleStringDirectory() {
            if (this.moduleStringDirectory != null)
                return this.moduleStringDirectory;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((stringDirPtr().offset() + 4096));
            this.moduleStringDirectory = new ModuleStringDirectory(io, this, _root);
            io.seek(_pos);
            return this.moduleStringDirectory;
        }
        private VersionTable moduleVersionTable;
        public VersionTable moduleVersionTable() {
            if (this.moduleVersionTable != null)
                return this.moduleVersionTable;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((versionTblPtr().offset() + 4096));
            this.moduleVersionTable = new VersionTable(io, this, _root);
            io.seek(_pos);
            return this.moduleVersionTable;
        }
        private ModuleHeaderExtension moduleHeaderExtension;
        public ModuleHeaderExtension moduleHeaderExtension() {
            if (this.moduleHeaderExtension != null)
                return this.moduleHeaderExtension;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((modHdrExtPtr().offset() + 4096));
            this.moduleHeaderExtension = new ModuleHeaderExtension(io, this, _root);
            io.seek(_pos);
            return this.moduleHeaderExtension;
        }
        private ModuleObservabilityInformation moduleObservabilityInformation;
        public ModuleObservabilityInformation moduleObservabilityInformation() {
            if (this.moduleObservabilityInformation != null)
                return this.moduleObservabilityInformation;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((obsInfoPtr().offset() + 4096));
            this.moduleObservabilityInformation = new ModuleObservabilityInformation(io, this, _root);
            io.seek(_pos);
            return this.moduleObservabilityInformation;
        }
        private ProcedureTable procedureTable;
        public ProcedureTable procedureTable() {
            if (this.procedureTable != null)
                return this.procedureTable;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((procTblPtr().offset() + 4096));
            this.procedureTable = new ProcedureTable(io, this, _root);
            io.seek(_pos);
            return this.procedureTable;
        }
        private int version;
        private int modType;
        private int modState;
        private long reserved0;
        private Addr programHdrPtr;
        private Addr cpyrTblPtr;
        private Addr segmentTblPtr;
        private Addr versionTblPtr;
        private Addr bindInfoPtr;
        private Addr statInfoPtr;
        private Addr eolTblPtr;
        private Addr obsInfoPtr;
        private Addr stringDirPtr;
        private Addr entryptTblPtr;
        private Addr vlicTblPtr;
        private Addr pkgInfoPtr;
        private Addr procTblPtr;
        private Addr modConstPtr;
        private Addr ehdtPtr;
        private Addr ehmtlaPtr;
        private Addr motModBrgPtr;
        private Addr prePkgBrgPtr;
        private long miPtrConArea;
        private long reserved1;
        private int modAttrs;
        private int modObjAattrs;
        private long pepDictId;
        private long pepStringId;
        private long pepProcNumber;
        private int pepMinParms;
        private int pepMaxParms;
        private long maxMbvIdUsed;
        private int modConstBody;
        private int xlationReason;
        private int pdcAttrs;
        private int hyperspcAttrs;
        private long formatLevel;
        private Addr modHdrExtPtr;
        private long segtbExtSegoff;
        private byte[] reserved2;
        private long undocumentedModuleChecksum;
        private Pgm _root;
        private Pgm.ModuleTableEntry _parent;
        public int version() { return version; }
        public int modType() { return modType; }
        public int modState() { return modState; }
        public long reserved0() { return reserved0; }
        public Addr programHdrPtr() { return programHdrPtr; }
        public Addr cpyrTblPtr() { return cpyrTblPtr; }
        public Addr segmentTblPtr() { return segmentTblPtr; }
        public Addr versionTblPtr() { return versionTblPtr; }
        public Addr bindInfoPtr() { return bindInfoPtr; }
        public Addr statInfoPtr() { return statInfoPtr; }
        public Addr eolTblPtr() { return eolTblPtr; }
        public Addr obsInfoPtr() { return obsInfoPtr; }
        public Addr stringDirPtr() { return stringDirPtr; }
        public Addr entryptTblPtr() { return entryptTblPtr; }
        public Addr vlicTblPtr() { return vlicTblPtr; }
        public Addr pkgInfoPtr() { return pkgInfoPtr; }
        public Addr procTblPtr() { return procTblPtr; }
        public Addr modConstPtr() { return modConstPtr; }
        public Addr ehdtPtr() { return ehdtPtr; }
        public Addr ehmtlaPtr() { return ehmtlaPtr; }
        public Addr motModBrgPtr() { return motModBrgPtr; }
        public Addr prePkgBrgPtr() { return prePkgBrgPtr; }
        public long miPtrConArea() { return miPtrConArea; }
        public long reserved1() { return reserved1; }
        public int modAttrs() { return modAttrs; }
        public int modObjAattrs() { return modObjAattrs; }
        public long pepDictId() { return pepDictId; }
        public long pepStringId() { return pepStringId; }
        public long pepProcNumber() { return pepProcNumber; }
        public int pepMinParms() { return pepMinParms; }
        public int pepMaxParms() { return pepMaxParms; }
        public long maxMbvIdUsed() { return maxMbvIdUsed; }
        public int modConstBody() { return modConstBody; }
        public int xlationReason() { return xlationReason; }
        public int pdcAttrs() { return pdcAttrs; }
        public int hyperspcAttrs() { return hyperspcAttrs; }
        public long formatLevel() { return formatLevel; }
        public Addr modHdrExtPtr() { return modHdrExtPtr; }
        public long segtbExtSegoff() { return segtbExtSegoff; }
        public byte[] reserved2() { return reserved2; }
        public long undocumentedModuleChecksum() { return undocumentedModuleChecksum; }
        public Pgm _root() { return _root; }
        public Pgm.ModuleTableEntry _parent() { return _parent; }
    }
    public static class BinderGlueCodeTable extends KaitaiStruct {
        public static BinderGlueCodeTable fromFile(String fileName) throws IOException {
            return new BinderGlueCodeTable(new ByteBufferKaitaiStream(fileName));
        }

        public BinderGlueCodeTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public BinderGlueCodeTable(KaitaiStream _io, Pgm.ProgramHeaderExtension _parent) {
            this(_io, _parent, null);
        }

        public BinderGlueCodeTable(KaitaiStream _io, Pgm.ProgramHeaderExtension _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.tableSize = this._io.readU4be();
            this.tableEntryCnt = this._io.readU4be();
            this.gcNxtTblLnk = this._io.readU8be();
            this.gcTableType = this._io.readU1();
            this.reserved0 = this._io.readBytes(15);
        }
        private long tableSize;
        private long tableEntryCnt;
        private long gcNxtTblLnk;
        private int gcTableType;
        private byte[] reserved0;
        private Pgm _root;
        private Pgm.ProgramHeaderExtension _parent;
        public long tableSize() { return tableSize; }
        public long tableEntryCnt() { return tableEntryCnt; }
        public long gcNxtTblLnk() { return gcNxtTblLnk; }
        public int gcTableType() { return gcTableType; }
        public byte[] reserved0() { return reserved0; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderExtension _parent() { return _parent; }
    }
    public static class SegmentTableExtension extends KaitaiStruct {
        public static SegmentTableExtension fromFile(String fileName) throws IOException {
            return new SegmentTableExtension(new ByteBufferKaitaiStream(fileName));
        }

        public SegmentTableExtension(KaitaiStream _io) {
            this(_io, null, null);
        }

        public SegmentTableExtension(KaitaiStream _io, Pgm.ProgramHeaderExtension _parent) {
            this(_io, _parent, null);
        }

        public SegmentTableExtension(KaitaiStream _io, Pgm.ProgramHeaderExtension _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.tableSize = this._io.readU4be();
            this.tableEntryCount = this._io.readU4be();
            this.tableVersion = this._io.readU1();
            this.reserved0 = this._io.readBytes(7);
            this.unknown0 = this._io.readBytes(8);
            this._raw_extensionTable = this._io.readBytes((tableSize() - 24));
            KaitaiStream _io__raw_extensionTable = new ByteBufferKaitaiStream(_raw_extensionTable);
            this.extensionTable = new SegmentTableExtensionTable(_io__raw_extensionTable, this, _root);
        }
        private long tableSize;
        private long tableEntryCount;
        private int tableVersion;
        private byte[] reserved0;
        private byte[] unknown0;
        private SegmentTableExtensionTable extensionTable;
        private Pgm _root;
        private Pgm.ProgramHeaderExtension _parent;
        private byte[] _raw_extensionTable;
        public long tableSize() { return tableSize; }
        public long tableEntryCount() { return tableEntryCount; }
        public int tableVersion() { return tableVersion; }
        public byte[] reserved0() { return reserved0; }
        public byte[] unknown0() { return unknown0; }
        public SegmentTableExtensionTable extensionTable() { return extensionTable; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderExtension _parent() { return _parent; }
        public byte[] _raw_extensionTable() { return _raw_extensionTable; }
    }
    public static class ProgramMaintenanceHeader extends KaitaiStruct {
        public static ProgramMaintenanceHeader fromFile(String fileName) throws IOException {
            return new ProgramMaintenanceHeader(new ByteBufferKaitaiStream(fileName));
        }

        public ProgramMaintenanceHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProgramMaintenanceHeader(KaitaiStream _io, Pgm.ProgramHeaderBase _parent) {
            this(_io, _parent, null);
        }

        public ProgramMaintenanceHeader(KaitaiStream _io, Pgm.ProgramHeaderBase _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.version = this._io.readU1();
            this.reserved0 = this._io.readBytes(7);
            this.cpyrListSize = this._io.readU4be();
            this.cpyrListCnt = this._io.readU4be();
            this.cpyrSegoff = this._io.readU8be();
            this.reserved1 = this._io.readBytes(16);
            this.extObjSegoff = this._io.readBytes(8);
            this.stcActSegoff = this._io.readU8be();
            this.lastSegNonobs = this._io.readU4be();
            this.lastSizNonobs = this._io.readU4be();
            this.lowestPbvId = this._io.readU4be();
            this.highestPbvId = this._io.readU4be();
            this.expInfoSegoff = this._io.readU8be();
            this.reserved = this._io.readBytes(40);
            this.undocumentedProgramChecksum = this._io.readU8be();
        }
        private int version;
        private byte[] reserved0;
        private long cpyrListSize;
        private long cpyrListCnt;
        private long cpyrSegoff;
        private byte[] reserved1;
        private byte[] extObjSegoff;
        private long stcActSegoff;
        private long lastSegNonobs;
        private long lastSizNonobs;
        private long lowestPbvId;
        private long highestPbvId;
        private long expInfoSegoff;
        private byte[] reserved;
        private long undocumentedProgramChecksum;
        private Pgm _root;
        private Pgm.ProgramHeaderBase _parent;
        public int version() { return version; }
        public byte[] reserved0() { return reserved0; }
        public long cpyrListSize() { return cpyrListSize; }
        public long cpyrListCnt() { return cpyrListCnt; }
        public long cpyrSegoff() { return cpyrSegoff; }
        public byte[] reserved1() { return reserved1; }
        public byte[] extObjSegoff() { return extObjSegoff; }
        public long stcActSegoff() { return stcActSegoff; }
        public long lastSegNonobs() { return lastSegNonobs; }
        public long lastSizNonobs() { return lastSizNonobs; }
        public long lowestPbvId() { return lowestPbvId; }
        public long highestPbvId() { return highestPbvId; }
        public long expInfoSegoff() { return expInfoSegoff; }
        public byte[] reserved() { return reserved; }
        public long undocumentedProgramChecksum() { return undocumentedProgramChecksum; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderBase _parent() { return _parent; }
    }
    public static class DirectoryMappingEntry extends KaitaiStruct {
        public static DirectoryMappingEntry fromFile(String fileName) throws IOException {
            return new DirectoryMappingEntry(new ByteBufferKaitaiStream(fileName));
        }

        public DirectoryMappingEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public DirectoryMappingEntry(KaitaiStream _io, Pgm.DictionaryMappingTable _parent) {
            this(_io, _parent, null);
        }

        public DirectoryMappingEntry(KaitaiStream _io, Pgm.DictionaryMappingTable _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.dictionaryId = this._io.readU4be();
            this.offset = this._io.readU4be();
            this.flags = this._io.readU1();
            this.storageFrame = this._io.readU2be();
            this.lexscopeOrRes = this._io.readU1();
            this.mbvOrLength = this._io.readU4be();
            this.pbvOrOwner = this._io.readU4be();
        }
        private long dictionaryId;
        private long offset;
        private int flags;
        private int storageFrame;
        private int lexscopeOrRes;
        private long mbvOrLength;
        private long pbvOrOwner;
        private Pgm _root;
        private Pgm.DictionaryMappingTable _parent;
        public long dictionaryId() { return dictionaryId; }
        public long offset() { return offset; }
        public int flags() { return flags; }
        public int storageFrame() { return storageFrame; }
        public int lexscopeOrRes() { return lexscopeOrRes; }
        public long mbvOrLength() { return mbvOrLength; }
        public long pbvOrOwner() { return pbvOrOwner; }
        public Pgm _root() { return _root; }
        public Pgm.DictionaryMappingTable _parent() { return _parent; }
    }
    public static class MainSegmentHeader extends KaitaiStruct {
        public static MainSegmentHeader fromFile(String fileName) throws IOException {
            return new MainSegmentHeader(new ByteBufferKaitaiStream(fileName));
        }

        public MainSegmentHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public MainSegmentHeader(KaitaiStream _io, Pgm _parent) {
            this(_io, _parent, null);
        }

        public MainSegmentHeader(KaitaiStream _io, Pgm _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.yysghdr = new SegmentGroupHeader(this._io, this, _root);
            this.yyepahdr = new EpaHeader(this._io, this, _root);
            this.body = this._io.readBytes(((yysghdr().programSize() * 512) - 210));
        }
        private ProgramHeader pgmHeader;
        public ProgramHeader pgmHeader() {
            if (this.pgmHeader != null)
                return this.pgmHeader;
            long _pos = this._io.pos();
            this._io.seek(8192);
            this.pgmHeader = new ProgramHeader(this._io, this, _root);
            this._io.seek(_pos);
            return this.pgmHeader;
        }
        private SegmentGroupHeader yysghdr;
        private EpaHeader yyepahdr;
        private byte[] body;
        private Pgm _root;
        private Pgm _parent;
        public SegmentGroupHeader yysghdr() { return yysghdr; }
        public EpaHeader yyepahdr() { return yyepahdr; }
        public byte[] body() { return body; }
        public Pgm _root() { return _root; }
        public Pgm _parent() { return _parent; }
    }
    public static class EhDeclarationEntry extends KaitaiStruct {
        public static EhDeclarationEntry fromFile(String fileName) throws IOException {
            return new EhDeclarationEntry(new ByteBufferKaitaiStream(fileName));
        }

        public EhDeclarationEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public EhDeclarationEntry(KaitaiStream _io, Pgm.ExceptionHandlerDeclarationTable _parent) {
            this(_io, _parent, null);
        }

        public EhDeclarationEntry(KaitaiStream _io, Pgm.ExceptionHandlerDeclarationTable _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.entryType = this._io.readU1();
            this.hndlrProcType = this._io.readU1();
            this.priority = this._io.readU1();
            this.reserved0 = this._io.readBytes(1);
            this.dataAreaLen = this._io.readU4be();
            this.dataArStgKey = this._io.readU1();
            this.dataArStgData = this._io.readBytes(7);
            this.ctrlAcStgKey = this._io.readU1();
            this.ctrlAcStgData = this._io.readBytes(7);
            this.hdlPrcStgKey = this._io.readU1();
            this.hdlPrcStgData = this._io.readBytes(7);
            this.exceptionClass = this._io.readBytes(8);
            this.backupHndPtyp = this._io.readU1();
            this.reserved1 = this._io.readBytes(3);
            this.backupSlot = this._io.readU4be();
            this.backupSlot2 = this._io.readU4be();
            this.backupSlot3 = this._io.readU4be();
        }
        private int entryType;
        private int hndlrProcType;
        private int priority;
        private byte[] reserved0;
        private long dataAreaLen;
        private int dataArStgKey;
        private byte[] dataArStgData;
        private int ctrlAcStgKey;
        private byte[] ctrlAcStgData;
        private int hdlPrcStgKey;
        private byte[] hdlPrcStgData;
        private byte[] exceptionClass;
        private int backupHndPtyp;
        private byte[] reserved1;
        private long backupSlot;
        private long backupSlot2;
        private long backupSlot3;
        private Pgm _root;
        private Pgm.ExceptionHandlerDeclarationTable _parent;
        public int entryType() { return entryType; }
        public int hndlrProcType() { return hndlrProcType; }
        public int priority() { return priority; }
        public byte[] reserved0() { return reserved0; }
        public long dataAreaLen() { return dataAreaLen; }
        public int dataArStgKey() { return dataArStgKey; }
        public byte[] dataArStgData() { return dataArStgData; }
        public int ctrlAcStgKey() { return ctrlAcStgKey; }
        public byte[] ctrlAcStgData() { return ctrlAcStgData; }
        public int hdlPrcStgKey() { return hdlPrcStgKey; }
        public byte[] hdlPrcStgData() { return hdlPrcStgData; }
        public byte[] exceptionClass() { return exceptionClass; }
        public int backupHndPtyp() { return backupHndPtyp; }
        public byte[] reserved1() { return reserved1; }
        public long backupSlot() { return backupSlot; }
        public long backupSlot2() { return backupSlot2; }
        public long backupSlot3() { return backupSlot3; }
        public Pgm _root() { return _root; }
        public Pgm.ExceptionHandlerDeclarationTable _parent() { return _parent; }
    }
    public static class Segment extends KaitaiStruct {
        public static Segment fromFile(String fileName) throws IOException {
            return new Segment(new ByteBufferKaitaiStream(fileName));
        }

        public Segment(KaitaiStream _io) {
            this(_io, null, null);
        }

        public Segment(KaitaiStream _io, Pgm _parent) {
            this(_io, _parent, null);
        }

        public Segment(KaitaiStream _io, Pgm _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.segmentType = this._io.readU2be();
            this.segmentSize = this._io.readU2be();
            this.newFlags = this._io.readU1();
            this.flags = this._io.readU1();
            this.shUnk0 = this._io.readBytes(2);
            this.parentAddress = this._io.readU8be();
            this.shUnk1 = this._io.readU8be();
            this.associatedSpace = this._io.readU8be();
            this.body = this._io.readBytes(((segmentSize() * 512) - 32));
        }
        private int segmentType;
        private int segmentSize;
        private int newFlags;
        private int flags;
        private byte[] shUnk0;
        private long parentAddress;
        private long shUnk1;
        private long associatedSpace;
        private byte[] body;
        private Pgm _root;
        private Pgm _parent;
        public int segmentType() { return segmentType; }
        public int segmentSize() { return segmentSize; }
        public int newFlags() { return newFlags; }
        public int flags() { return flags; }
        public byte[] shUnk0() { return shUnk0; }
        public long parentAddress() { return parentAddress; }
        public long shUnk1() { return shUnk1; }
        public long associatedSpace() { return associatedSpace; }
        public byte[] body() { return body; }
        public Pgm _root() { return _root; }
        public Pgm _parent() { return _parent; }
    }
    public static class SegmentTableEntry extends KaitaiStruct {
        public static SegmentTableEntry fromFile(String fileName) throws IOException {
            return new SegmentTableEntry(new ByteBufferKaitaiStream(fileName));
        }

        public SegmentTableEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public SegmentTableEntry(KaitaiStream _io, Pgm.SegmentTable _parent) {
            this(_io, _parent, null);
        }

        public SegmentTableEntry(KaitaiStream _io, Pgm.SegmentTable _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.segmentAddress = new Addr(this._io, this, _root);
            this.limboAddress = new Addr(this._io, this, _root);
            this.decSgPageCount = this._io.readU2be();
            this.segmentUse = this._io.readU1();
            this.compressSgIds = this._io.readBytes(10);
            this.impiPtrSegId = this._io.readBytes(3);
            this.reserved1 = this._io.readBytes(16);
        }
        private Addr segmentAddress;
        private Addr limboAddress;
        private int decSgPageCount;
        private int segmentUse;
        private byte[] compressSgIds;
        private byte[] impiPtrSegId;
        private byte[] reserved1;
        private Pgm _root;
        private Pgm.SegmentTable _parent;
        public Addr segmentAddress() { return segmentAddress; }
        public Addr limboAddress() { return limboAddress; }
        public int decSgPageCount() { return decSgPageCount; }
        public int segmentUse() { return segmentUse; }
        public byte[] compressSgIds() { return compressSgIds; }
        public byte[] impiPtrSegId() { return impiPtrSegId; }
        public byte[] reserved1() { return reserved1; }
        public Pgm _root() { return _root; }
        public Pgm.SegmentTable _parent() { return _parent; }
    }
    public static class TracebackLocatorEntry extends KaitaiStruct {
        public static TracebackLocatorEntry fromFile(String fileName) throws IOException {
            return new TracebackLocatorEntry(new ByteBufferKaitaiStream(fileName));
        }

        public TracebackLocatorEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TracebackLocatorEntry(KaitaiStream _io, Pgm.TracebackLocatorTable _parent) {
            this(_io, _parent, null);
        }

        public TracebackLocatorEntry(KaitaiStream _io, Pgm.TracebackLocatorTable _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.procLocation = this._io.readU8be();
            this.procLength = this._io.readU4be();
            this.reserved0 = this._io.readU4be();
            this.tracebackTblLoc = this._io.readU8be();
        }
        private long procLocation;
        private long procLength;
        private long reserved0;
        private long tracebackTblLoc;
        private Pgm _root;
        private Pgm.TracebackLocatorTable _parent;
        public long procLocation() { return procLocation; }
        public long procLength() { return procLength; }
        public long reserved0() { return reserved0; }
        public long tracebackTblLoc() { return tracebackTblLoc; }
        public Pgm _root() { return _root; }
        public Pgm.TracebackLocatorTable _parent() { return _parent; }
    }
    public static class ModuleTableEntry extends KaitaiStruct {
        public static ModuleTableEntry fromFile(String fileName) throws IOException {
            return new ModuleTableEntry(new ByteBufferKaitaiStream(fileName));
        }

        public ModuleTableEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ModuleTableEntry(KaitaiStream _io, Pgm.ModuleTable _parent) {
            this(_io, _parent, null);
        }

        public ModuleTableEntry(KaitaiStream _io, Pgm.ModuleTable _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.moduleHdrPtr = new Addr(this._io, this, _root);
            this.reserved0 = this._io.readBytes(4);
            this.moduleDomain = this._io.readU2be();
            this.assocSpcCnt = this._io.readU2be();
            this.moduleSubtype = this._io.readU1();
        }
        private ModuleHeader modules;
        public ModuleHeader modules() {
            if (this.modules != null)
                return this.modules;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((moduleHdrPtr().offset() + 4096));
            this.modules = new ModuleHeader(io, this, _root);
            io.seek(_pos);
            return this.modules;
        }
        private Addr moduleHdrPtr;
        private byte[] reserved0;
        private int moduleDomain;
        private int assocSpcCnt;
        private int moduleSubtype;
        private Pgm _root;
        private Pgm.ModuleTable _parent;
        public Addr moduleHdrPtr() { return moduleHdrPtr; }
        public byte[] reserved0() { return reserved0; }
        public int moduleDomain() { return moduleDomain; }
        public int assocSpcCnt() { return assocSpcCnt; }
        public int moduleSubtype() { return moduleSubtype; }
        public Pgm _root() { return _root; }
        public Pgm.ModuleTable _parent() { return _parent; }
    }
    public static class ModuleHeaderExtension extends KaitaiStruct {
        public static ModuleHeaderExtension fromFile(String fileName) throws IOException {
            return new ModuleHeaderExtension(new ByteBufferKaitaiStream(fileName));
        }

        public ModuleHeaderExtension(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ModuleHeaderExtension(KaitaiStream _io, Pgm.ModuleHeader _parent) {
            this(_io, _parent, null);
        }

        public ModuleHeaderExtension(KaitaiStream _io, Pgm.ModuleHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.version = this._io.readU1();
            this.reserved0 = this._io.readBytes(7);
            this.callIntProc = this._io.readU8be();
            this.procExtTbl = this._io.readU8be();
            this.sepTable = this._io.readU8be();
            this.mcaInitSegoff = this._io.readU8be();
            this.dcfInitSegoff = this._io.readU8be();
            this.modHistSegoff = this._io.readU8be();
            this.dcallSegoff = this._io.readU8be();
            this.icallSegoff = this._io.readU8be();
            this.reserved1 = this._io.readBytes(8);
            this.inlCallSegoff = this._io.readU8be();
            this.dltProcSegoff = this._io.readU8be();
            this.licoptSegoff = this._io.readU8be();
            this.jvaCrtSegoff = this._io.readU8be();
            this.hdwFeatureSet = this._io.readBytes(16);
            this.effectvTgtMdl = this._io.readU4be();
            this.specifiedTgtMdl = this._io.readU4be();
            this.reserved2 = this._io.readBytes(24);
            this.intrfaceSegoff = this._io.readU8be();
            this.oxEnvFlags = this._io.readU8be();
            this.ildataTblSegoff = this._io.readU8be();
            this.reserved3 = this._io.readBytes(64);
            this.undocumentedModuleExtChecksum = this._io.readU8be();
        }
        private int version;
        private byte[] reserved0;
        private long callIntProc;
        private long procExtTbl;
        private long sepTable;
        private long mcaInitSegoff;
        private long dcfInitSegoff;
        private long modHistSegoff;
        private long dcallSegoff;
        private long icallSegoff;
        private byte[] reserved1;
        private long inlCallSegoff;
        private long dltProcSegoff;
        private long licoptSegoff;
        private long jvaCrtSegoff;
        private byte[] hdwFeatureSet;
        private long effectvTgtMdl;
        private long specifiedTgtMdl;
        private byte[] reserved2;
        private long intrfaceSegoff;
        private long oxEnvFlags;
        private long ildataTblSegoff;
        private byte[] reserved3;
        private long undocumentedModuleExtChecksum;
        private Pgm _root;
        private Pgm.ModuleHeader _parent;
        public int version() { return version; }
        public byte[] reserved0() { return reserved0; }
        public long callIntProc() { return callIntProc; }
        public long procExtTbl() { return procExtTbl; }
        public long sepTable() { return sepTable; }
        public long mcaInitSegoff() { return mcaInitSegoff; }
        public long dcfInitSegoff() { return dcfInitSegoff; }
        public long modHistSegoff() { return modHistSegoff; }
        public long dcallSegoff() { return dcallSegoff; }
        public long icallSegoff() { return icallSegoff; }
        public byte[] reserved1() { return reserved1; }
        public long inlCallSegoff() { return inlCallSegoff; }
        public long dltProcSegoff() { return dltProcSegoff; }
        public long licoptSegoff() { return licoptSegoff; }
        public long jvaCrtSegoff() { return jvaCrtSegoff; }
        public byte[] hdwFeatureSet() { return hdwFeatureSet; }
        public long effectvTgtMdl() { return effectvTgtMdl; }
        public long specifiedTgtMdl() { return specifiedTgtMdl; }
        public byte[] reserved2() { return reserved2; }
        public long intrfaceSegoff() { return intrfaceSegoff; }
        public long oxEnvFlags() { return oxEnvFlags; }
        public long ildataTblSegoff() { return ildataTblSegoff; }
        public byte[] reserved3() { return reserved3; }
        public long undocumentedModuleExtChecksum() { return undocumentedModuleExtChecksum; }
        public Pgm _root() { return _root; }
        public Pgm.ModuleHeader _parent() { return _parent; }
    }
    public static class SegmentTableExtensionTable extends KaitaiStruct {
        public static SegmentTableExtensionTable fromFile(String fileName) throws IOException {
            return new SegmentTableExtensionTable(new ByteBufferKaitaiStream(fileName));
        }

        public SegmentTableExtensionTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public SegmentTableExtensionTable(KaitaiStream _io, Pgm.SegmentTableExtension _parent) {
            this(_io, _parent, null);
        }

        public SegmentTableExtensionTable(KaitaiStream _io, Pgm.SegmentTableExtension _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.entries = new ArrayList<SegmentTableExtensionEntry>();
            for (int i = 0; i < _parent().tableEntryCount(); i++) {
                this.entries.add(new SegmentTableExtensionEntry(this._io, this, _root));
            }
        }
        private ArrayList<SegmentTableExtensionEntry> entries;
        private Pgm _root;
        private Pgm.SegmentTableExtension _parent;
        public ArrayList<SegmentTableExtensionEntry> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm.SegmentTableExtension _parent() { return _parent; }
    }
    public static class ProcedureExtensionTable extends KaitaiStruct {
        public static ProcedureExtensionTable fromFile(String fileName) throws IOException {
            return new ProcedureExtensionTable(new ByteBufferKaitaiStream(fileName));
        }

        public ProcedureExtensionTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProcedureExtensionTable(KaitaiStream _io, Pgm _parent) {
            this(_io, _parent, null);
        }

        public ProcedureExtensionTable(KaitaiStream _io, Pgm _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.tableSize = this._io.readU4be();
            this.tableEntryCnt = this._io.readU4be();
            this.reserved0 = this._io.readBytes(8);
            this._raw_entries = new ArrayList<byte[]>();
            this.entries = new ArrayList<ProcedureExtTableEntry>();
            for (int i = 0; i < tableEntryCnt(); i++) {
                this._raw_entries.add(this._io.readBytes((tableSize() - 16)));
                KaitaiStream _io__raw_entries = new ByteBufferKaitaiStream(_raw_entries.get(_raw_entries.size() - 1));
                this.entries.add(new ProcedureExtTableEntry(_io__raw_entries, this, _root));
            }
        }
        private long tableSize;
        private long tableEntryCnt;
        private byte[] reserved0;
        private ArrayList<ProcedureExtTableEntry> entries;
        private Pgm _root;
        private Pgm _parent;
        private ArrayList<byte[]> _raw_entries;
        public long tableSize() { return tableSize; }
        public long tableEntryCnt() { return tableEntryCnt; }
        public byte[] reserved0() { return reserved0; }
        public ArrayList<ProcedureExtTableEntry> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm _parent() { return _parent; }
        public ArrayList<byte[]> _raw_entries() { return _raw_entries; }
    }
    public static class ProgramStringDirectory extends KaitaiStruct {
        public static ProgramStringDirectory fromFile(String fileName) throws IOException {
            return new ProgramStringDirectory(new ByteBufferKaitaiStream(fileName));
        }

        public ProgramStringDirectory(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProgramStringDirectory(KaitaiStream _io, Pgm.ProgramHeaderBase _parent) {
            this(_io, _parent, null);
        }

        public ProgramStringDirectory(KaitaiStream _io, Pgm.ProgramHeaderBase _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.dirLength = this._io.readU4be();
            this.unknown = this._io.readBytes(12);
            this._raw_stringDirectory = this._io.readBytes((dirLength() - 16));
            KaitaiStream _io__raw_stringDirectory = new ByteBufferKaitaiStream(_raw_stringDirectory);
            this.stringDirectory = new StringDirectoryEntriesFf(_io__raw_stringDirectory, this, _root);
        }
        private long dirLength;
        private byte[] unknown;
        private StringDirectoryEntriesFf stringDirectory;
        private Pgm _root;
        private Pgm.ProgramHeaderBase _parent;
        private byte[] _raw_stringDirectory;
        public long dirLength() { return dirLength; }
        public byte[] unknown() { return unknown; }
        public StringDirectoryEntriesFf stringDirectory() { return stringDirectory; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderBase _parent() { return _parent; }
        public byte[] _raw_stringDirectory() { return _raw_stringDirectory; }
    }
    public static class ProgramVersionTable extends KaitaiStruct {
        public static ProgramVersionTable fromFile(String fileName) throws IOException {
            return new ProgramVersionTable(new ByteBufferKaitaiStream(fileName));
        }

        public ProgramVersionTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProgramVersionTable(KaitaiStream _io, Pgm.ProgramHeaderBase _parent) {
            this(_io, _parent, null);
        }

        public ProgramVersionTable(KaitaiStream _io, Pgm.ProgramHeaderBase _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.tableVersion = this._io.readU1();
            this.bnVrmOxLeve = this._io.readU1();
            this.bnInternalVrm = this._io.readU2be();
            this.bnMiVrm = this._io.readU2be();
            this.targetVrm = this._io.readU2be();
            this.createOnVrm = this._io.readU2be();
            this.bnEarliestVrm = this._io.readU2be();
            this.reserved0 = this._io.readBytes(4);
            this.languageVrm = this._io.readU2be();
            this.mmMiVrm = this._io.readU2be();
            this.oxMiVrm = this._io.readU2be();
            this.oxInternalVrm = this._io.readU2be();
            this.mmInternalVrm = this._io.readU2be();
            this.reserved1 = this._io.readBytes(4);
            this.ccsid = this._io.readU2be();
            this.unknown0 = this._io.readBytes(4);
            this.pgMiVrm = this._io.readU2be();
            this.pgEarliestVrm = this._io.readU2be();
        }
        private int tableVersion;
        private int bnVrmOxLeve;
        private int bnInternalVrm;
        private int bnMiVrm;
        private int targetVrm;
        private int createOnVrm;
        private int bnEarliestVrm;
        private byte[] reserved0;
        private int languageVrm;
        private int mmMiVrm;
        private int oxMiVrm;
        private int oxInternalVrm;
        private int mmInternalVrm;
        private byte[] reserved1;
        private int ccsid;
        private byte[] unknown0;
        private int pgMiVrm;
        private int pgEarliestVrm;
        private Pgm _root;
        private Pgm.ProgramHeaderBase _parent;
        public int tableVersion() { return tableVersion; }
        public int bnVrmOxLeve() { return bnVrmOxLeve; }
        public int bnInternalVrm() { return bnInternalVrm; }
        public int bnMiVrm() { return bnMiVrm; }
        public int targetVrm() { return targetVrm; }
        public int createOnVrm() { return createOnVrm; }
        public int bnEarliestVrm() { return bnEarliestVrm; }
        public byte[] reserved0() { return reserved0; }
        public int languageVrm() { return languageVrm; }
        public int mmMiVrm() { return mmMiVrm; }
        public int oxMiVrm() { return oxMiVrm; }
        public int oxInternalVrm() { return oxInternalVrm; }
        public int mmInternalVrm() { return mmInternalVrm; }
        public byte[] reserved1() { return reserved1; }
        public int ccsid() { return ccsid; }
        public byte[] unknown0() { return unknown0; }
        public int pgMiVrm() { return pgMiVrm; }
        public int pgEarliestVrm() { return pgEarliestVrm; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderBase _parent() { return _parent; }
    }
    public static class PrefixedStringFf extends KaitaiStruct {
        public static PrefixedStringFf fromFile(String fileName) throws IOException {
            return new PrefixedStringFf(new ByteBufferKaitaiStream(fileName));
        }

        public PrefixedStringFf(KaitaiStream _io) {
            this(_io, null, null);
        }

        public PrefixedStringFf(KaitaiStream _io, Pgm.StringDirectoryEntriesFf _parent) {
            this(_io, _parent, null);
        }

        public PrefixedStringFf(KaitaiStream _io, Pgm.StringDirectoryEntriesFf _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.lenStringBytes = this._io.readU4be();
            this.unknown0 = this._io.readBytes(2);
            this.stringBytes = this._io.readBytes(lenStringBytes());
        }
        private long lenStringBytes;
        private byte[] unknown0;
        private byte[] stringBytes;
        private Pgm _root;
        private Pgm.StringDirectoryEntriesFf _parent;
        public long lenStringBytes() { return lenStringBytes; }
        public byte[] unknown0() { return unknown0; }
        public byte[] stringBytes() { return stringBytes; }
        public Pgm _root() { return _root; }
        public Pgm.StringDirectoryEntriesFf _parent() { return _parent; }
    }
    public static class StaticPbvArray extends KaitaiStruct {
        public static StaticPbvArray fromFile(String fileName) throws IOException {
            return new StaticPbvArray(new ByteBufferKaitaiStream(fileName));
        }

        public StaticPbvArray(KaitaiStream _io) {
            this(_io, null, null);
        }

        public StaticPbvArray(KaitaiStream _io, Pgm _parent) {
            this(_io, _parent, null);
        }

        public StaticPbvArray(KaitaiStream _io, Pgm _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.entries = new ArrayList<Long>();
            for (int i = 0; i < 4; i++) {
                this.entries.add(this._io.readU8be());
            }
        }
        private ArrayList<Long> entries;
        private Pgm _root;
        private Pgm _parent;
        public ArrayList<Long> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm _parent() { return _parent; }
    }
    public static class TracebackLocatorTable extends KaitaiStruct {
        public static TracebackLocatorTable fromFile(String fileName) throws IOException {
            return new TracebackLocatorTable(new ByteBufferKaitaiStream(fileName));
        }

        public TracebackLocatorTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public TracebackLocatorTable(KaitaiStream _io, Pgm.ProgramHeaderBase _parent) {
            this(_io, _parent, null);
        }

        public TracebackLocatorTable(KaitaiStream _io, Pgm.ProgramHeaderBase _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.tableSize = this._io.readU4be();
            this.tableEntryCnt = this._io.readU4be();
            this.tableVersion = this._io.readU1();
            this.reserved0 = this._io.readBytes(7);
            this._raw_entries = new ArrayList<byte[]>();
            this.entries = new ArrayList<TracebackLocatorEntry>();
            for (int i = 0; i < tableEntryCnt(); i++) {
                this._raw_entries.add(this._io.readBytes((tableSize() - 16)));
                KaitaiStream _io__raw_entries = new ByteBufferKaitaiStream(_raw_entries.get(_raw_entries.size() - 1));
                this.entries.add(new TracebackLocatorEntry(_io__raw_entries, this, _root));
            }
        }
        private long tableSize;
        private long tableEntryCnt;
        private int tableVersion;
        private byte[] reserved0;
        private ArrayList<TracebackLocatorEntry> entries;
        private Pgm _root;
        private Pgm.ProgramHeaderBase _parent;
        private ArrayList<byte[]> _raw_entries;
        public long tableSize() { return tableSize; }
        public long tableEntryCnt() { return tableEntryCnt; }
        public int tableVersion() { return tableVersion; }
        public byte[] reserved0() { return reserved0; }
        public ArrayList<TracebackLocatorEntry> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderBase _parent() { return _parent; }
        public ArrayList<byte[]> _raw_entries() { return _raw_entries; }
    }
    public static class ProgramHistoryLog extends KaitaiStruct {
        public static ProgramHistoryLog fromFile(String fileName) throws IOException {
            return new ProgramHistoryLog(new ByteBufferKaitaiStream(fileName));
        }

        public ProgramHistoryLog(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProgramHistoryLog(KaitaiStream _io, Pgm _parent) {
            this(_io, _parent, null);
        }

        public ProgramHistoryLog(KaitaiStream _io, Pgm _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.histLogSize = this._io.readU4be();
            this.histLogEntryCount = this._io.readU4be();
            this.wrapCount = this._io.readU1();
            this.currentEntry = this._io.readU1();
            this.nestingLevel = this._io.readU1();
            this.eyeCatcherHist = this._io.readBytes(4);
            this.histReserved = this._io.readU1();
            this.histEntries = new ArrayList<HistEntry>();
            for (int i = 0; i < histLogEntryCount(); i++) {
                this.histEntries.add(new HistEntry(this._io, this, _root));
            }
        }
        private long histLogSize;
        private long histLogEntryCount;
        private int wrapCount;
        private int currentEntry;
        private int nestingLevel;
        private byte[] eyeCatcherHist;
        private int histReserved;
        private ArrayList<HistEntry> histEntries;
        private Pgm _root;
        private Pgm _parent;
        public long histLogSize() { return histLogSize; }
        public long histLogEntryCount() { return histLogEntryCount; }
        public int wrapCount() { return wrapCount; }
        public int currentEntry() { return currentEntry; }
        public int nestingLevel() { return nestingLevel; }
        public byte[] eyeCatcherHist() { return eyeCatcherHist; }
        public int histReserved() { return histReserved; }
        public ArrayList<HistEntry> histEntries() { return histEntries; }
        public Pgm _root() { return _root; }
        public Pgm _parent() { return _parent; }
    }
    public static class EpaHeader extends KaitaiStruct {
        public static EpaHeader fromFile(String fileName) throws IOException {
            return new EpaHeader(new ByteBufferKaitaiStream(fileName));
        }

        public EpaHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public EpaHeader(KaitaiStream _io, Pgm.MainSegmentHeader _parent) {
            this(_io, _parent, null);
        }

        public EpaHeader(KaitaiStream _io, Pgm.MainSegmentHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.attr1 = this._io.readU1();
            this.jopt = this._io.readU1();
            this.type = this._io.readU1();
            this.shSubtype = this._io.readU1();
            this.shPgmName = this._io.readBytes(30);
            this.spatt = this._io.readU1();
            this.spin = this._io.readU1();
            this.spsz = this._io.readU4be();
            this.shUnk2 = this._io.readU4be();
            this.pbau = this._io.readU2be();
            this.dver = this._io.readU2be();
            this.time = this._io.readBytes(8);
            this.upsg = this._io.readU8be();
            this.agsg = this._io.readU8be();
            this.ctsg = this._io.readU8be();
            this.osg = this._io.readU8be();
            this.rcv2 = this._io.readU2be();
            this.asp = this._io.readU2be();
            this.perf = this._io.readU4be();
            this.mdts = this._io.readU8be();
            this.jpsg = this._io.readU8be();
            this.cbsg = this._io.readU8be();
            this.jid = this._io.readBytes(10);
            this.owau = this._io.readU2be();
            this.iplnum = this._io.readU4be();
            this.al1s = this._io.readU8be();
            this.grau = this._io.readU2be();
            this.epaUnk0 = this._io.readBytes(6);
            this.grp = this._io.readBytes(6);
            this.maxs = this._io.readU2be();
            this.info = this._io.readU8be();
            this.att2 = this._io.readU1();
            this.colb = this._io.readU1();
            this.levl = this._io.readU4be();
            this.uscnt = this._io.readU2be();
            this.usday = this._io.readU2be();
        }
        private int attr1;
        private int jopt;
        private int type;
        private int shSubtype;
        private byte[] shPgmName;
        private int spatt;
        private int spin;
        private long spsz;
        private long shUnk2;
        private int pbau;
        private int dver;
        private byte[] time;
        private long upsg;
        private long agsg;
        private long ctsg;
        private long osg;
        private int rcv2;
        private int asp;
        private long perf;
        private long mdts;
        private long jpsg;
        private long cbsg;
        private byte[] jid;
        private int owau;
        private long iplnum;
        private long al1s;
        private int grau;
        private byte[] epaUnk0;
        private byte[] grp;
        private int maxs;
        private long info;
        private int att2;
        private int colb;
        private long levl;
        private int uscnt;
        private int usday;
        private Pgm _root;
        private Pgm.MainSegmentHeader _parent;
        public int attr1() { return attr1; }
        public int jopt() { return jopt; }
        public int type() { return type; }
        public int shSubtype() { return shSubtype; }
        public byte[] shPgmName() { return shPgmName; }
        public int spatt() { return spatt; }
        public int spin() { return spin; }
        public long spsz() { return spsz; }
        public long shUnk2() { return shUnk2; }
        public int pbau() { return pbau; }
        public int dver() { return dver; }
        public byte[] time() { return time; }
        public long upsg() { return upsg; }
        public long agsg() { return agsg; }
        public long ctsg() { return ctsg; }
        public long osg() { return osg; }
        public int rcv2() { return rcv2; }
        public int asp() { return asp; }
        public long perf() { return perf; }
        public long mdts() { return mdts; }
        public long jpsg() { return jpsg; }
        public long cbsg() { return cbsg; }
        public byte[] jid() { return jid; }
        public int owau() { return owau; }
        public long iplnum() { return iplnum; }
        public long al1s() { return al1s; }
        public int grau() { return grau; }
        public byte[] epaUnk0() { return epaUnk0; }
        public byte[] grp() { return grp; }
        public int maxs() { return maxs; }
        public long info() { return info; }
        public int att2() { return att2; }
        public int colb() { return colb; }
        public long levl() { return levl; }
        public int uscnt() { return uscnt; }
        public int usday() { return usday; }
        public Pgm _root() { return _root; }
        public Pgm.MainSegmentHeader _parent() { return _parent; }
    }
    public static class Addr extends KaitaiStruct {
        public static Addr fromFile(String fileName) throws IOException {
            return new Addr(new ByteBufferKaitaiStream(fileName));
        }

        public Addr(KaitaiStream _io) {
            this(_io, null, null);
        }

        public Addr(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public Addr(KaitaiStream _io, KaitaiStruct _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.dwhigh = this._io.readU4be();
            this.dwlow = this._io.readU4be();
        }
        private Integer offset;
        public Integer offset() {
            if (this.offset != null)
                return this.offset;
            int _tmp = (int) ((dwlow() & 16777215));
            this.offset = _tmp;
            return this.offset;
        }
        private Integer page;
        public Integer page() {
            if (this.page != null)
                return this.page;
            int _tmp = (int) (((dwhigh() << 8) + ((dwlow() & 4278190080L) >> 24)));
            this.page = _tmp;
            return this.page;
        }
        private Integer fullvalue;
        public Integer fullvalue() {
            if (this.fullvalue != null)
                return this.fullvalue;
            int _tmp = (int) (((dwhigh() << 32) + dwlow()));
            this.fullvalue = _tmp;
            return this.fullvalue;
        }
        private long dwhigh;
        private long dwlow;
        private Pgm _root;
        private KaitaiStruct _parent;
        public long dwhigh() { return dwhigh; }
        public long dwlow() { return dwlow; }
        public Pgm _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class OpmTemplateInfoHeader extends KaitaiStruct {
        public static OpmTemplateInfoHeader fromFile(String fileName) throws IOException {
            return new OpmTemplateInfoHeader(new ByteBufferKaitaiStream(fileName));
        }

        public OpmTemplateInfoHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public OpmTemplateInfoHeader(KaitaiStream _io, Pgm.ProgramObservabilityInfoHeader _parent) {
            this(_io, _parent, null);
        }

        public OpmTemplateInfoHeader(KaitaiStream _io, Pgm.ProgramObservabilityInfoHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.version = this._io.readU1();
            this.reserved0 = this._io.readBytes(7);
            this.opmCrtTplPtr = this._io.readU8be();
            this.reserved1 = this._io.readBytes(16);
            this.pgmAttrs = this._io.readU2be();
            this.opmOptions = this._io.readU1();
            this.observAttr = this._io.readU1();
            this.staticStoreSz = this._io.readU4be();
            this.autoStoreSize = this._io.readU4be();
            this.numInstrV0 = this._io.readU2be();
            this.numOdvEntV0 = this._io.readU2be();
            this.miInstrOffset = this._io.readU4be();
            this.odvOffset = this._io.readU4be();
            this.oesOffset = this._io.readU4be();
            this.hllBomDtaLen = this._io.readU4be();
            this.hllBomLength = this._io.readU4be();
            this.hllBomOffset = this._io.readU4be();
            this.hllSymDtaLen = this._io.readU4be();
            this.hllSymLength = this._io.readU4be();
            this.hllSymOffset = this._io.readU4be();
            this.omtOffset = this._io.readU4be();
            this.numInstrV1 = this._io.readU4be();
            this.numOdvEntV1 = this._io.readU4be();
            this.reserved = this._io.readBytes(96);
        }
        private int version;
        private byte[] reserved0;
        private long opmCrtTplPtr;
        private byte[] reserved1;
        private int pgmAttrs;
        private int opmOptions;
        private int observAttr;
        private long staticStoreSz;
        private long autoStoreSize;
        private int numInstrV0;
        private int numOdvEntV0;
        private long miInstrOffset;
        private long odvOffset;
        private long oesOffset;
        private long hllBomDtaLen;
        private long hllBomLength;
        private long hllBomOffset;
        private long hllSymDtaLen;
        private long hllSymLength;
        private long hllSymOffset;
        private long omtOffset;
        private long numInstrV1;
        private long numOdvEntV1;
        private byte[] reserved;
        private Pgm _root;
        private Pgm.ProgramObservabilityInfoHeader _parent;
        public int version() { return version; }
        public byte[] reserved0() { return reserved0; }
        public long opmCrtTplPtr() { return opmCrtTplPtr; }
        public byte[] reserved1() { return reserved1; }
        public int pgmAttrs() { return pgmAttrs; }
        public int opmOptions() { return opmOptions; }
        public int observAttr() { return observAttr; }
        public long staticStoreSz() { return staticStoreSz; }
        public long autoStoreSize() { return autoStoreSize; }
        public int numInstrV0() { return numInstrV0; }
        public int numOdvEntV0() { return numOdvEntV0; }
        public long miInstrOffset() { return miInstrOffset; }
        public long odvOffset() { return odvOffset; }
        public long oesOffset() { return oesOffset; }
        public long hllBomDtaLen() { return hllBomDtaLen; }
        public long hllBomLength() { return hllBomLength; }
        public long hllBomOffset() { return hllBomOffset; }
        public long hllSymDtaLen() { return hllSymDtaLen; }
        public long hllSymLength() { return hllSymLength; }
        public long hllSymOffset() { return hllSymOffset; }
        public long omtOffset() { return omtOffset; }
        public long numInstrV1() { return numInstrV1; }
        public long numOdvEntV1() { return numOdvEntV1; }
        public byte[] reserved() { return reserved; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramObservabilityInfoHeader _parent() { return _parent; }
    }
    public static class ProgramHeaderExtension extends KaitaiStruct {
        public static ProgramHeaderExtension fromFile(String fileName) throws IOException {
            return new ProgramHeaderExtension(new ByteBufferKaitaiStream(fileName));
        }

        public ProgramHeaderExtension(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProgramHeaderExtension(KaitaiStream _io, Pgm.ProgramHeader _parent) {
            this(_io, _parent, null);
        }

        public ProgramHeaderExtension(KaitaiStream _io, Pgm.ProgramHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.gluCdListPtr = new Addr(this._io, this, _root);
            this.pgmHistSegoff = this._io.readU8be();
            this.foo = this._io.readU8be();
            this.mcaTblSegoff = this._io.readU8be();
            this.javaStmfPtr = this._io.readU8be();
            this.reserved0 = this._io.readBytes(40);
            this.hdwFeatureSet = this._io.readBytes(16);
            this.reserved1 = this._io.readBytes(32);
            this.sgTbExtSegoff = new Addr(this._io, this, _root);
            this.reserved2 = this._io.readBytes(96);
        }
        private BinderGlueCodeTable binderGlueCodeTable;
        public BinderGlueCodeTable binderGlueCodeTable() {
            if (this.binderGlueCodeTable != null)
                return this.binderGlueCodeTable;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((gluCdListPtr().offset() + 4096));
            this.binderGlueCodeTable = new BinderGlueCodeTable(io, this, _root);
            io.seek(_pos);
            return this.binderGlueCodeTable;
        }
        private SegmentTableExtension segmentTableExtension;
        public SegmentTableExtension segmentTableExtension() {
            if (this.segmentTableExtension != null)
                return this.segmentTableExtension;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((sgTbExtSegoff().offset() + 4096));
            this.segmentTableExtension = new SegmentTableExtension(io, this, _root);
            io.seek(_pos);
            return this.segmentTableExtension;
        }
        private Addr gluCdListPtr;
        private long pgmHistSegoff;
        private long foo;
        private long mcaTblSegoff;
        private long javaStmfPtr;
        private byte[] reserved0;
        private byte[] hdwFeatureSet;
        private byte[] reserved1;
        private Addr sgTbExtSegoff;
        private byte[] reserved2;
        private Pgm _root;
        private Pgm.ProgramHeader _parent;
        public Addr gluCdListPtr() { return gluCdListPtr; }
        public long pgmHistSegoff() { return pgmHistSegoff; }
        public long foo() { return foo; }
        public long mcaTblSegoff() { return mcaTblSegoff; }
        public long javaStmfPtr() { return javaStmfPtr; }
        public byte[] reserved0() { return reserved0; }
        public byte[] hdwFeatureSet() { return hdwFeatureSet; }
        public byte[] reserved1() { return reserved1; }
        public Addr sgTbExtSegoff() { return sgTbExtSegoff; }
        public byte[] reserved2() { return reserved2; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeader _parent() { return _parent; }
    }
    public static class ProcedureTableEntry extends KaitaiStruct {
        public static ProcedureTableEntry fromFile(String fileName) throws IOException {
            return new ProcedureTableEntry(new ByteBufferKaitaiStream(fileName));
        }

        public ProcedureTableEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProcedureTableEntry(KaitaiStream _io, Pgm.ProcedureTable _parent) {
            this(_io, _parent, null);
        }

        public ProcedureTableEntry(KaitaiStream _io, Pgm.ProcedureTable _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.version = this._io.readU1();
            this.procType = this._io.readU1();
            this.procBdy = this._io.readU1();
            this.procFlags = this._io.readU1();
            this.procLexScope = this._io.readU2be();
            this.procParmlMask = this._io.readU2be();
            this.procSize = this._io.readU4be();
            this.entryPtOffset = this._io.readU4be();
            this.entryPoint = new Addr(this._io, this, _root);
            this.modHdrPtr = new Addr(this._io, this, _root);
            this.procStartPtr = new Addr(this._io, this, _root);
            this.irmPtr = new Addr(this._io, this, _root);
            this.somvPtr = new Addr(this._io, this, _root);
            this.stPtr = new Addr(this._io, this, _root);
            this.bptPtr = new Addr(this._io, this, _root);
            this.procIntSegoff = this._io.readU8be();
            this.reserved0 = this._io.readBytes(24);
            this.icbSize = this._io.readU4be();
            this.stringId = this._io.readU4be();
            this.procDictId = this._io.readU4be();
            this.modNumber = this._io.readU4be();
            this.procNumber = this._io.readU4be();
            this.ofsToEhState = this._io.readU8be();
            this.reserved1 = this._io.readBytes(12);
        }
        private byte[] riscCode;
        public byte[] riscCode() {
            if (this.riscCode != null)
                return this.riscCode;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((procStartPtr().offset() + 4096));
            this.riscCode = io.readBytes(procSize());
            io.seek(_pos);
            return this.riscCode;
        }
        private int version;
        private int procType;
        private int procBdy;
        private int procFlags;
        private int procLexScope;
        private int procParmlMask;
        private long procSize;
        private long entryPtOffset;
        private Addr entryPoint;
        private Addr modHdrPtr;
        private Addr procStartPtr;
        private Addr irmPtr;
        private Addr somvPtr;
        private Addr stPtr;
        private Addr bptPtr;
        private long procIntSegoff;
        private byte[] reserved0;
        private long icbSize;
        private long stringId;
        private long procDictId;
        private long modNumber;
        private long procNumber;
        private long ofsToEhState;
        private byte[] reserved1;
        private Pgm _root;
        private Pgm.ProcedureTable _parent;
        public int version() { return version; }
        public int procType() { return procType; }
        public int procBdy() { return procBdy; }
        public int procFlags() { return procFlags; }
        public int procLexScope() { return procLexScope; }
        public int procParmlMask() { return procParmlMask; }
        public long procSize() { return procSize; }
        public long entryPtOffset() { return entryPtOffset; }
        public Addr entryPoint() { return entryPoint; }
        public Addr modHdrPtr() { return modHdrPtr; }
        public Addr procStartPtr() { return procStartPtr; }
        public Addr irmPtr() { return irmPtr; }
        public Addr somvPtr() { return somvPtr; }
        public Addr stPtr() { return stPtr; }
        public Addr bptPtr() { return bptPtr; }
        public long procIntSegoff() { return procIntSegoff; }
        public byte[] reserved0() { return reserved0; }
        public long icbSize() { return icbSize; }
        public long stringId() { return stringId; }
        public long procDictId() { return procDictId; }
        public long modNumber() { return modNumber; }
        public long procNumber() { return procNumber; }
        public long ofsToEhState() { return ofsToEhState; }
        public byte[] reserved1() { return reserved1; }
        public Pgm _root() { return _root; }
        public Pgm.ProcedureTable _parent() { return _parent; }
    }
    public static class WritableProgramHeader extends KaitaiStruct {
        public static WritableProgramHeader fromFile(String fileName) throws IOException {
            return new WritableProgramHeader(new ByteBufferKaitaiStream(fileName));
        }

        public WritableProgramHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public WritableProgramHeader(KaitaiStream _io, Pgm.ProgramHeaderBase _parent) {
            this(_io, _parent, null);
        }

        public WritableProgramHeader(KaitaiStream _io, Pgm.ProgramHeaderBase _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.lockSrc = this._io.readBytes(76);
            this.lockUseCnt = this._io.readU4be();
            this.wphReserved = this._io.readBytes(48);
        }
        private byte[] lockSrc;
        private long lockUseCnt;
        private byte[] wphReserved;
        private Pgm _root;
        private Pgm.ProgramHeaderBase _parent;
        public byte[] lockSrc() { return lockSrc; }
        public long lockUseCnt() { return lockUseCnt; }
        public byte[] wphReserved() { return wphReserved; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderBase _parent() { return _parent; }
    }
    public static class HistEntry extends KaitaiStruct {
        public static HistEntry fromFile(String fileName) throws IOException {
            return new HistEntry(new ByteBufferKaitaiStream(fileName));
        }

        public HistEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public HistEntry(KaitaiStream _io, Pgm.ProgramHistoryLog _parent) {
            this(_io, _parent, null);
        }

        public HistEntry(KaitaiStream _io, Pgm.ProgramHistoryLog _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.operationCode = this._io.readU1();
            this.nestingLevel = this._io.readU1();
            this.timestamp = this._io.readBytes(6);
            this.systemVrm = this._io.readU2be();
            this.status = this._io.readU1();
            this.associatedData = this._io.readBytes(5);
        }
        private int operationCode;
        private int nestingLevel;
        private byte[] timestamp;
        private int systemVrm;
        private int status;
        private byte[] associatedData;
        private Pgm _root;
        private Pgm.ProgramHistoryLog _parent;
        public int operationCode() { return operationCode; }
        public int nestingLevel() { return nestingLevel; }
        public byte[] timestamp() { return timestamp; }
        public int systemVrm() { return systemVrm; }
        public int status() { return status; }
        public byte[] associatedData() { return associatedData; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHistoryLog _parent() { return _parent; }
    }
    public static class CallInterfaceInformationComponent extends KaitaiStruct {
        public static CallInterfaceInformationComponent fromFile(String fileName) throws IOException {
            return new CallInterfaceInformationComponent(new ByteBufferKaitaiStream(fileName));
        }

        public CallInterfaceInformationComponent(KaitaiStream _io) {
            this(_io, null, null);
        }

        public CallInterfaceInformationComponent(KaitaiStream _io, Pgm _parent) {
            this(_io, _parent, null);
        }

        public CallInterfaceInformationComponent(KaitaiStream _io, Pgm _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.length = this._io.readU4be();
            this.version = this._io.readU4be();
            this.numOfPrototypes0 = this._io.readU4be();
            this.numOfPrototypes1 = this._io.readU4be();
            this.reserved0 = this._io.readBytes(16);
            this.entries = new ArrayList<CiicEntry>();
            for (int i = 0; i < numOfPrototypes0(); i++) {
                this.entries.add(new CiicEntry(this._io, this, _root));
            }
        }
        private long length;
        private long version;
        private long numOfPrototypes0;
        private long numOfPrototypes1;
        private byte[] reserved0;
        private ArrayList<CiicEntry> entries;
        private Pgm _root;
        private Pgm _parent;
        public long length() { return length; }
        public long version() { return version; }
        public long numOfPrototypes0() { return numOfPrototypes0; }
        public long numOfPrototypes1() { return numOfPrototypes1; }
        public byte[] reserved0() { return reserved0; }
        public ArrayList<CiicEntry> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm _parent() { return _parent; }
    }
    public static class SavfHeader extends KaitaiStruct {
        public static SavfHeader fromFile(String fileName) throws IOException {
            return new SavfHeader(new ByteBufferKaitaiStream(fileName));
        }

        public SavfHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public SavfHeader(KaitaiStream _io, Pgm _parent) {
            this(_io, _parent, null);
        }

        public SavfHeader(KaitaiStream _io, Pgm _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.dummy = this._io.readBytes(4096);
        }
        private byte[] dummy;
        private Pgm _root;
        private Pgm _parent;
        public byte[] dummy() { return dummy; }
        public Pgm _root() { return _root; }
        public Pgm _parent() { return _parent; }
    }
    public static class ProcedureTable extends KaitaiStruct {
        public static ProcedureTable fromFile(String fileName) throws IOException {
            return new ProcedureTable(new ByteBufferKaitaiStream(fileName));
        }

        public ProcedureTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProcedureTable(KaitaiStream _io, Pgm.ModuleHeader _parent) {
            this(_io, _parent, null);
        }

        public ProcedureTable(KaitaiStream _io, Pgm.ModuleHeader _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.tableSize = this._io.readU4be();
            this.tableEntryCnt = this._io.readU4be();
            this.reserved0 = this._io.readBytes(8);
            this.entries = new ArrayList<ProcedureTableEntry>();
            for (int i = 0; i < tableEntryCnt(); i++) {
                this.entries.add(new ProcedureTableEntry(this._io, this, _root));
            }
        }
        private long tableSize;
        private long tableEntryCnt;
        private byte[] reserved0;
        private ArrayList<ProcedureTableEntry> entries;
        private Pgm _root;
        private Pgm.ModuleHeader _parent;
        public long tableSize() { return tableSize; }
        public long tableEntryCnt() { return tableEntryCnt; }
        public byte[] reserved0() { return reserved0; }
        public ArrayList<ProcedureTableEntry> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm.ModuleHeader _parent() { return _parent; }
    }
    public static class SegmentTable extends KaitaiStruct {
        public static SegmentTable fromFile(String fileName) throws IOException {
            return new SegmentTable(new ByteBufferKaitaiStream(fileName));
        }

        public SegmentTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public SegmentTable(KaitaiStream _io, Pgm.ProgramHeaderBase _parent) {
            this(_io, _parent, null);
        }

        public SegmentTable(KaitaiStream _io, Pgm.ProgramHeaderBase _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.tableSize = this._io.readU4be();
            this.tableEntryCount = this._io.readU4be();
            this.tableVersion = this._io.readU1();
            this.interruptedOp = this._io.readU1();
            this.attributes = this._io.readU1();
            this.reserved0 = this._io.readBytes(3);
            this.interruptedSeg = this._io.readU2be();
            this.entries = new ArrayList<SegmentTableEntry>();
            for (int i = 0; i < tableEntryCount(); i++) {
                this.entries.add(new SegmentTableEntry(this._io, this, _root));
            }
        }
        private long tableSize;
        private long tableEntryCount;
        private int tableVersion;
        private int interruptedOp;
        private int attributes;
        private byte[] reserved0;
        private int interruptedSeg;
        private ArrayList<SegmentTableEntry> entries;
        private Pgm _root;
        private Pgm.ProgramHeaderBase _parent;
        public long tableSize() { return tableSize; }
        public long tableEntryCount() { return tableEntryCount; }
        public int tableVersion() { return tableVersion; }
        public int interruptedOp() { return interruptedOp; }
        public int attributes() { return attributes; }
        public byte[] reserved0() { return reserved0; }
        public int interruptedSeg() { return interruptedSeg; }
        public ArrayList<SegmentTableEntry> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderBase _parent() { return _parent; }
    }
    public static class ProgramObservabilityInfoHeader extends KaitaiStruct {
        public static ProgramObservabilityInfoHeader fromFile(String fileName) throws IOException {
            return new ProgramObservabilityInfoHeader(new ByteBufferKaitaiStream(fileName));
        }

        public ProgramObservabilityInfoHeader(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ProgramObservabilityInfoHeader(KaitaiStream _io, Pgm.ProgramHeaderBase _parent) {
            this(_io, _parent, null);
        }

        public ProgramObservabilityInfoHeader(KaitaiStream _io, Pgm.ProgramHeaderBase _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.version = this._io.readU1();
            this.reserved0 = this._io.readBytes(3);
            this.obsMustRemain = this._io.readU4be();
            this.obsExistCrt = this._io.readU4be();
            this.obsExistNow = this._io.readU4be();
            this.pgmCrtTplPtr = this._io.readU8be();
            this.objectListPtr = this._io.readU8be();
            this.sysResLisPtr = this._io.readU8be();
            this.pgmExListPtr = this._io.readU8be();
            this.secSpcListPtr = this._io.readU8be();
            this.opmTplInfPtr = new Addr(this._io, this, _root);
            this.procOrdSegoff = this._io.readU8be();
            this.reserved1 = this._io.readBytes(8);
        }
        private OpmTemplateInfoHeader opmTemplateInfoHeader;
        public OpmTemplateInfoHeader opmTemplateInfoHeader() {
            if (this.opmTemplateInfoHeader != null)
                return this.opmTemplateInfoHeader;
            KaitaiStream io = _root()._io();
            long _pos = io.pos();
            io.seek((opmTplInfPtr().offset() + 4096));
            this.opmTemplateInfoHeader = new OpmTemplateInfoHeader(io, this, _root);
            io.seek(_pos);
            return this.opmTemplateInfoHeader;
        }
        private int version;
        private byte[] reserved0;
        private long obsMustRemain;
        private long obsExistCrt;
        private long obsExistNow;
        private long pgmCrtTplPtr;
        private long objectListPtr;
        private long sysResLisPtr;
        private long pgmExListPtr;
        private long secSpcListPtr;
        private Addr opmTplInfPtr;
        private long procOrdSegoff;
        private byte[] reserved1;
        private Pgm _root;
        private Pgm.ProgramHeaderBase _parent;
        public int version() { return version; }
        public byte[] reserved0() { return reserved0; }
        public long obsMustRemain() { return obsMustRemain; }
        public long obsExistCrt() { return obsExistCrt; }
        public long obsExistNow() { return obsExistNow; }
        public long pgmCrtTplPtr() { return pgmCrtTplPtr; }
        public long objectListPtr() { return objectListPtr; }
        public long sysResLisPtr() { return sysResLisPtr; }
        public long pgmExListPtr() { return pgmExListPtr; }
        public long secSpcListPtr() { return secSpcListPtr; }
        public Addr opmTplInfPtr() { return opmTplInfPtr; }
        public long procOrdSegoff() { return procOrdSegoff; }
        public byte[] reserved1() { return reserved1; }
        public Pgm _root() { return _root; }
        public Pgm.ProgramHeaderBase _parent() { return _parent; }
    }
    public static class DictionaryMappingTable extends KaitaiStruct {
        public static DictionaryMappingTable fromFile(String fileName) throws IOException {
            return new DictionaryMappingTable(new ByteBufferKaitaiStream(fileName));
        }

        public DictionaryMappingTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public DictionaryMappingTable(KaitaiStream _io, Pgm.ModuleObservabilityInformation _parent) {
            this(_io, _parent, null);
        }

        public DictionaryMappingTable(KaitaiStream _io, Pgm.ModuleObservabilityInformation _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.length = this._io.readU4be();
            this.version = this._io.readU4be();
            this.lastEntryIdx = this._io.readU4be();
            this._raw_entries = new ArrayList<byte[]>();
            this.entries = new ArrayList<DirectoryMappingEntry>();
            for (int i = 0; i < lastEntryIdx(); i++) {
                this._raw_entries.add(this._io.readBytes((length() - 12)));
                KaitaiStream _io__raw_entries = new ByteBufferKaitaiStream(_raw_entries.get(_raw_entries.size() - 1));
                this.entries.add(new DirectoryMappingEntry(_io__raw_entries, this, _root));
            }
        }
        private long length;
        private long version;
        private long lastEntryIdx;
        private ArrayList<DirectoryMappingEntry> entries;
        private Pgm _root;
        private Pgm.ModuleObservabilityInformation _parent;
        private ArrayList<byte[]> _raw_entries;
        public long length() { return length; }
        public long version() { return version; }
        public long lastEntryIdx() { return lastEntryIdx; }
        public ArrayList<DirectoryMappingEntry> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm.ModuleObservabilityInformation _parent() { return _parent; }
        public ArrayList<byte[]> _raw_entries() { return _raw_entries; }
    }
    public static class EhTables extends KaitaiStruct {
        public static EhTables fromFile(String fileName) throws IOException {
            return new EhTables(new ByteBufferKaitaiStream(fileName));
        }

        public EhTables(KaitaiStream _io) {
            this(_io, null, null);
        }

        public EhTables(KaitaiStream _io, Pgm _parent) {
            this(_io, _parent, null);
        }

        public EhTables(KaitaiStream _io, Pgm _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.ehMappingTable = new ExceptionHandlerMappingTable(this._io, this, _root);
            this.ehDeclarationTable = new ExceptionHandlerDeclarationTable(this._io, this, _root);
        }
        private ExceptionHandlerMappingTable ehMappingTable;
        private ExceptionHandlerDeclarationTable ehDeclarationTable;
        private Pgm _root;
        private Pgm _parent;
        public ExceptionHandlerMappingTable ehMappingTable() { return ehMappingTable; }
        public ExceptionHandlerDeclarationTable ehDeclarationTable() { return ehDeclarationTable; }
        public Pgm _root() { return _root; }
        public Pgm _parent() { return _parent; }
    }
    public static class ExceptionHandlerMappingTable extends KaitaiStruct {
        public static ExceptionHandlerMappingTable fromFile(String fileName) throws IOException {
            return new ExceptionHandlerMappingTable(new ByteBufferKaitaiStream(fileName));
        }

        public ExceptionHandlerMappingTable(KaitaiStream _io) {
            this(_io, null, null);
        }

        public ExceptionHandlerMappingTable(KaitaiStream _io, Pgm.EhTables _parent) {
            this(_io, _parent, null);
        }

        public ExceptionHandlerMappingTable(KaitaiStream _io, Pgm.EhTables _parent, Pgm _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.length = this._io.readU4be();
            this.version = this._io.readU4be();
            this.lastEntryIdx = this._io.readU4be();
            this.entries = new ArrayList<Long>();
            for (int i = 0; i < lastEntryIdx(); i++) {
                this.entries.add(this._io.readU4be());
            }
        }
        private long length;
        private long version;
        private long lastEntryIdx;
        private ArrayList<Long> entries;
        private Pgm _root;
        private Pgm.EhTables _parent;
        public long length() { return length; }
        public long version() { return version; }
        public long lastEntryIdx() { return lastEntryIdx; }
        public ArrayList<Long> entries() { return entries; }
        public Pgm _root() { return _root; }
        public Pgm.EhTables _parent() { return _parent; }
    }
    private StaticPbvArray staticPbvArray;
    public StaticPbvArray staticPbvArray() {
        if (this.staticPbvArray != null)
            return this.staticPbvArray;
        long _pos = this._io.pos();
        this._io.seek(9856);
        this.staticPbvArray = new StaticPbvArray(this._io, this, _root);
        this._io.seek(_pos);
        return this.staticPbvArray;
    }
    private EhTables exceptionHandlerTables;
    public EhTables exceptionHandlerTables() {
        if (this.exceptionHandlerTables != null)
            return this.exceptionHandlerTables;
        long _pos = this._io.pos();
        this._io.seek(10384);
        this.exceptionHandlerTables = new EhTables(this._io, this, _root);
        this._io.seek(_pos);
        return this.exceptionHandlerTables;
    }
    private ProcedureExtensionTable procedureExtensionTable;
    public ProcedureExtensionTable procedureExtensionTable() {
        if (this.procedureExtensionTable != null)
            return this.procedureExtensionTable;
        long _pos = this._io.pos();
        this._io.seek(11424);
        this.procedureExtensionTable = new ProcedureExtensionTable(this._io, this, _root);
        this._io.seek(_pos);
        return this.procedureExtensionTable;
    }
    private StaticActivationHeader staticActivationHeader;
    public StaticActivationHeader staticActivationHeader() {
        if (this.staticActivationHeader != null)
            return this.staticActivationHeader;
        long _pos = this._io.pos();
        this._io.seek(9808);
        this.staticActivationHeader = new StaticActivationHeader(this._io, this, _root);
        this._io.seek(_pos);
        return this.staticActivationHeader;
    }
    private CallInterfaceInformationComponent callInterfaceInformationComponent;
    public CallInterfaceInformationComponent callInterfaceInformationComponent() {
        if (this.callInterfaceInformationComponent != null)
            return this.callInterfaceInformationComponent;
        long _pos = this._io.pos();
        this._io.seek(12192);
        this.callInterfaceInformationComponent = new CallInterfaceInformationComponent(this._io, this, _root);
        this._io.seek(_pos);
        return this.callInterfaceInformationComponent;
    }
    private ProgramHistoryLog hist;
    public ProgramHistoryLog hist() {
        if (this.hist != null)
            return this.hist;
        long _pos = this._io.pos();
        this._io.seek(4480);
        this.hist = new ProgramHistoryLog(this._io, this, _root);
        this._io.seek(_pos);
        return this.hist;
    }
    private SavfHeader savf;
    private MainSegmentHeader mainSegment;
    private ArrayList<Segment> segments;
    private Pgm _root;
    private KaitaiStruct _parent;
    public SavfHeader savf() { return savf; }
    public MainSegmentHeader mainSegment() { return mainSegment; }
    public ArrayList<Segment> segments() { return segments; }
    public Pgm _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}
