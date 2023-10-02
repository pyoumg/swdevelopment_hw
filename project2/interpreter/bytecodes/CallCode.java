package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class CallCode implements ByteCode {

    private final String label;
    private int address;

    private String args;


    public String getLabel() {
        return this.label;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public CallCode(List<String> args) {
        this.label = args.get(0);
    }


    @Override
    public String toString() {
        String[] labelSplit = label.split("<<");
        String id = labelSplit[0];
        //set args at execute()
        return "CALL " + label + "   " + id + "(" + args + ")";
    }


    @Override
    public void execute(VirtualMachine vm) {
        args = "";
        int start = vm.framePeek();
        int end = vm.size(); //size of runtimestack

        for (int i = start; i < end - 1; i++) {
            args += Integer.toString(vm.getRunTimeStack(i));
            args += ",";
        }
        if (start < end) {
            //last element doesn't end with ','
            args += vm.getRunTimeStack(end - 1);
        }
        vm.pushReturnAddress(vm.getProgramCounter());
        vm.jump(address);

    }
}
