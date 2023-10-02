package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Objects;

public class StoreCode implements ByteCode {
    private int offset;
    private String id;
    private int value;

    public StoreCode(List<String> args) {
        this.offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            this.id = args.get(1);
        }
    }


    @Override
    public String toString() {
        String retString = "STORE " + offset;
        if (!Objects.isNull(id)) {
            retString += " " + id + "   " + id + "=" + value;
        }
        return retString;
    }


    @Override
    public void execute(VirtualMachine vm) {
        //Store cannot operate across frame boundaries.
        if (vm.frameSize() > offset) {
            value = vm.store(offset);
        }


    }
}
