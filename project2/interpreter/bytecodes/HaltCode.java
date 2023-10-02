package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class HaltCode implements ByteCode {

    public HaltCode(List<String> args) {
        //no arguments

    }

    //not dumped
    @Override
    public String toString() {
        return null;
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.halt();
    }
}
