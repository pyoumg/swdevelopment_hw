package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class GotoCode implements ByteCode {
    private final String label;
    //resolved address
    private int address;

    public GotoCode(List<String> args) {
        this.label = args.get(0);
    }

    public String getLabel() {
        return this.label;
    }

    public void setAddress(int address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "GOTO " + label;
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.jump(address);
    }
}
