package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class LabelCode implements ByteCode {

    private String label;

    public LabelCode(List<String> args) {
        this.label = args.get(0);
    }

    public String getLabel() {
        return this.label;
    }


    //optional
    @Override
    public String toString() {
        return null;
    }


    @Override
    public void execute(VirtualMachine vm) {
        //nothing
    }
}
