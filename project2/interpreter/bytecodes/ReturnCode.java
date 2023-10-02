package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Objects;

public class ReturnCode implements ByteCode {

    private String label;
    private int returnValue;

    public ReturnCode(List<String> args) {
        if (args.size() > 0) {
            this.label = args.get(0);

        }
    }

    @Override
    public String toString() {
        String retString = "RETURN";

        //if it has label
        if (!Objects.isNull(this.label)) {
            String baseId = this.label.split("<<")[0];
            retString += " " + this.label + "   EXIT " + baseId + ":" + this.returnValue;
        }
        return retString;
    }

    @Override
    public void execute(VirtualMachine vm) {

        int returnAddress = vm.popReturnAddress();

        this.returnValue = vm.pop();

        //empty the current frame of all values when the function
        //is complete.
        int framePeek = vm.framePeek();
        while (vm.size() > framePeek) {
            vm.pop();
        }
        //pop the top value from the framePointer stack

        vm.popFrame();

        vm.jump(returnAddress);
        vm.push(this.returnValue);

    }
}
