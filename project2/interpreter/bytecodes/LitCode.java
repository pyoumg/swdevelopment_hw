package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Objects;

public class LitCode implements ByteCode {

    private final int value;
    private String id;

    public LitCode(List<String> args) {
        value = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        }
    }


    @Override
    public String toString() {
        String retString = "LIT " + value;

        //if id is not null
        if (!Objects.isNull(id)) {
            retString += " " + id + "   int " + id;
        }
        return retString;

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.push(value);
    }


}
