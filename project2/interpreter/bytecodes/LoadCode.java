package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Objects;

public class LoadCode implements ByteCode {

    private final int offset;
    private String id;

    public LoadCode(List<String> args) {
        this.offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            this.id = args.get(1);
        }
    }

    @Override
    public String toString() {
        String retString = "LOAD " + offset;
        if (!Objects.isNull(id)) {
            retString += " " + id + "   <load " + id + ">";
        }
        return retString;
    }

    @Override
    public void execute(VirtualMachine vm) {
        //not to operate across frame boundaries
        if (vm.frameSize() > offset) {
            vm.load(offset);
        }
    }
}
