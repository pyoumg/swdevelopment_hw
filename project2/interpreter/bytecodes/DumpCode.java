package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class DumpCode implements ByteCode {

    private final boolean flag;

    public DumpCode(List<String> args) {
        this.flag = args.get(0).equals("ON");

    }

    //not dumped
    @Override
    public String toString() {
        return null;
    }


    @Override
    public void execute(VirtualMachine vm) {
        //set dump flag
        vm.dumpFlag(flag);
    }
}
