package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class FalseBranchCode implements ByteCode {
    private final String label;
    //resolved address
    private int address;

    public String getLabel() {
        return this.label;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public FalseBranchCode(List<String> args) {
        this.label = args.get(0);
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + label;
    }


    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.pop();
        //if value is 0, jump to label
        if (value == 0) {
            vm.jump(address);
        }
        //else: nothing
    }
}
