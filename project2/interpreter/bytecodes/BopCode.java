package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;

public class BopCode implements ByteCode {

    private final String value;

    public BopCode(List<String> args) {
        this.value = args.get(0);
    }

    @Override
    public String toString() {
        return "Bop " + this.value;
    }

    @Override
    public void execute(VirtualMachine vm) {

        //pop from runtime stack
        int val2 = vm.pop();
        int val1 = vm.pop();
        int result = switch (this.value) {
            case "+" -> val1 + val2;
            case "-" -> val1 - val2;
            case "/" -> val1 / val2;
            case "*" -> val1 * val2;
            case "==" -> val1 == val2 ? 1 : 0;
            case "!=" -> val1 != val2 ? 1 : 0;
            case "<=" -> val1 <= val2 ? 1 : 0;
            case "<" -> val1 < val2 ? 1 : 0;
            case ">=" -> val1 >= val2 ? 1 : 0;
            case ">" -> val1 > val2 ? 1 : 0;
            case "&" -> val1 != 0 && val2 != 0 ? 1 : 0;
            case "|" -> val1 != 0 || val2 != 0 ? 1 : 0;
            default -> 0;
        };

        //push result
        vm.push(result);
    }
}
