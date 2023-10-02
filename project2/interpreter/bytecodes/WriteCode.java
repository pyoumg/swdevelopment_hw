package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class WriteCode implements ByteCode {
    public WriteCode(List<String> args) {
        //nothing
    }

    @Override
    public String toString() {
        return "WRITE";
    }

    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.peek();

        //write value
        System.out.println(value);
    }
}
