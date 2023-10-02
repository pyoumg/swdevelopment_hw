package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class PopCode implements ByteCode {

    //the number of times pop is requesting to be executed
    private final int num;

    public PopCode(List<String> args) {
        this.num = Integer.parseInt(args.get(0));
    }

    @Override
    public String toString() {
        return "POP " + num;
    }

    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 0; i < num; i++) {
            //Pop is not allowed operate across frame boundaries.
            if (vm.size() > vm.framePeek()) {
                vm.pop();
            }


        }
    }
}
