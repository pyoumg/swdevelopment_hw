package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public interface ByteCode {

    public String toString(); //For Dumping

    public void execute(VirtualMachine vm);

    public static ByteCode getNewInstance(String key, List<String> args) {
        ByteCode bc = null;
        switch (key) {
            case "ARGS" -> bc = new ArgsCode(args);
            case "BOP" -> bc = new BopCode(args);
            case "GOTO" -> bc = new GotoCode(args);
            case "CALL" -> bc = new CallCode(args);
            case "DUMP" -> bc = new DumpCode(args);
            case "FALSEBRANCH" -> bc = new FalseBranchCode(args);
            case "HALT" -> bc = new HaltCode(args);
            case "LABEL" -> bc = new LabelCode(args);
            case "LIT" -> bc = new LitCode(args);
            case "LOAD" -> bc = new LoadCode(args);
            case "POP" -> bc = new PopCode(args);
            case "READ" -> bc = new ReadCode(args);
            case "RETURN" -> bc = new ReturnCode(args);
            case "STORE" -> bc = new StoreCode(args);
            case "WRITE" -> bc = new WriteCode(args);
            default -> {
            }
        }
        return bc;

    }


}

