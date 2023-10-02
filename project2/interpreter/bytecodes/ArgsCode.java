package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class ArgsCode implements ByteCode {
    private final int value;

    public ArgsCode(List<String> args) {
        this.value = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        //push the starting index of the new frame to the
        //framePointer stack.
        int index = vm.size() - value;
        vm.newFrameAt(index);

    }

    @Override
    public String toString() {
        return "ARGS " + value;
    }

}
