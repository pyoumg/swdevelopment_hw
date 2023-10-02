package interpreter.virtualmachine;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import interpreter.bytecodes.*;

public class Program {

    private List<ByteCode> program;

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program() {
        program = new ArrayList<>();
    }

    /**
     * Gets the size of the current program.
     *
     * @return size of program
     */
    public int getSize() {
        return program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     *
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter) {
        return program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     *
     * @param c bytecode to be added
     */
    public void addByteCode(ByteCode c) {
        program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList resolving
     * address for Goto,Call and FalseBranch bytecodes. These bytecodes
     * can only jump to Label codes that have a matching label value.
     * HINT: make note of what type of data-structure ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CHANGED *****
     */
    public void resolveAddress() {
        HashMap<String, Integer> jumpMap = new HashMap<>();

        //pass 1
        //store labelcode
        int size = getSize();
        for (int i = 0; i < size; i++) {
            ByteCode bc = program.get(i);
            //if it is labelcode
            if (bc instanceof final LabelCode lc) {
                jumpMap.put(lc.getLabel(), i);
            }
        }

        //pass 2
        //find address of goto, call, falsebranch code


        for (ByteCode bc : program) {

            if (bc instanceof final GotoCode gc) {
                int address = jumpMap.get(gc.getLabel());
                gc.setAddress(address);
            } else if (bc instanceof final CallCode cc) {
                int address = jumpMap.get(cc.getLabel());
                cc.setAddress(address);
            } else if (bc instanceof final FalseBranchCode fc) {
                int address = jumpMap.get(fc.getLabel());
                fc.setAddress(address);
            }

        }


    }
}