package interpreter.virtualmachine;

import java.util.Stack;

import interpreter.bytecodes.ByteCode;

public class VirtualMachine {

    private RunTimeStack runTimeStack;
    private Stack<Integer> returnAddress;
    private Program program;
    private int programCounter;
    private boolean isRunning;

    private boolean isDumping;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
    }

    public void executeProgram() {
        isRunning = true;
        isDumping = false;

        while (isRunning) {
            ByteCode code = program.getCode(programCounter);

            code.execute(this);

            if (isDumping) {
                if (code.toString() != null) {
                    System.out.println(code);
                    System.out.println(runTimeStack.dump());
                }
            }
            programCounter++;
        }
    }

    public void push(int value) {
        runTimeStack.push(value);
    }


    //frame value
    public void newFrameAt(int value) {
        runTimeStack.newFrameAt(value);
    }

    public int size() {
        return runTimeStack.size();
    }

    public int pop() {
        return runTimeStack.pop();
    }


    public void dumpFlag(boolean flag) {
        isDumping = flag;
    }

    public void halt() {
        isRunning = false;
    }

    public void load(int offset) {
        runTimeStack.load(offset);
    }

    public int store(int offset) {
        return runTimeStack.store(offset);
    }

    public int frameSize() {
        return runTimeStack.frameSize();
    }

    public int peek() {
        return runTimeStack.peek();
    }

    public int framePeek() {
        return runTimeStack.framePeek();
    }


    public void jump(int address) {
        programCounter = address;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public void pushReturnAddress(int address) {
        returnAddress.push(address);
    }

    public int popReturnAddress() {
        return returnAddress.pop();
    }

    public void popFrame() {
        runTimeStack.popFrame();
    }

    public int getRunTimeStack(int i) {
        return runTimeStack.getRunTimeStack(i);
    }
}
