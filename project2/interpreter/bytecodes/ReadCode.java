package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
import java.util.Scanner;

public class ReadCode implements ByteCode {

    private final Scanner scanner = new Scanner(System.in);

    public ReadCode(List<String> args) {
        //nothing
    }

    @Override
    public String toString() {
        return "READ";
    }

    @Override
    public void execute(VirtualMachine vm) {
        int input = 0;
        boolean integerFlag = false;

        while (!integerFlag) {
            System.out.print("Please enter an integer: ");

            if (scanner.hasNextInt()) { //if it is an integer
                input = scanner.nextInt();
                integerFlag = true;
            } else { //not integer
                System.out.println("Input is not an integer.");
                scanner.next();
            }
        }

        vm.push(input);

    }
}
