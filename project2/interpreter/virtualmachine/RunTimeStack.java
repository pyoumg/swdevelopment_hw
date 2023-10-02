package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    private List<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial frame pointer value, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }


    /**
     * Used for dumping the current state of the runTimeStack .
     * It will print portions of the stack based on respective
     * frame markers .
     * Example [1,2,3] [4,5,6] [] [7,8]
     * Frame pointers would be 0 ,3 ,6,6
     * runtimestack 1,2,3,4,5,6,7,8
     * 6 rts.size()-1
     */
    public String dump() {

        String dumpString = "";

        //can implement using get()

        for (int i = 0; i < framePointer.size(); i++) {
            int begin = framePointer.get(i);
            int end;
            if (i != framePointer.size() - 1)
                end = framePointer.get(i + 1);
            else
                end = runTimeStack.size();
            dumpString += "[";
            for (int j = begin; j < end; j++) {
                dumpString += runTimeStack.get(j) + ", ";

            }
            if (begin != end) //[]
                dumpString = dumpString.substring(0, dumpString.length() - 2);
            dumpString += "] ";
        }

        //remove last blank
        return dumpString.trim();

    }


    /**
     * returns the top of the runtime stack , but does not remove
     *
     * @return copy of the top of the stack .
     */
    public int peek() {
        return this.runTimeStack.get(lastIndex());
    }

    public int lastIndex() {
        return this.runTimeStack.size() - 1;
    }

    /**
     * push the value i to the top of the stack .
     *
     * @param i value to be pushed .
     * @return value pushed
     */
    public int push(int i) {
        this.runTimeStack.add(i);
        return i;

    }

    /**
     * removes to the top of the runtime stack .
     *
     * @return the value popped .
     */
    public int pop() {
        return this.runTimeStack.remove(lastIndex());
    }

    /**
     * Takes the top item of the run time stack , and stores
     * it into a offset starting from the current frame .
     *
     * @param offset number of slots above current frame marker
     * @return the item just stored
     */
    public int store(int offsetFromFramePointer) {
        int value = pop(); //top item
        int index = framePointer.peek() + offsetFromFramePointer;
        runTimeStack.add(index, value);
        return value;
    }

    /**
     * Takes a value from the run time stack that is at offset
     * from the current frame marker and pushes it onto the top of
     * the stack .
     *
     * @param offset number of slots above current frame marker
     * @return item just loaded into the offset
     */
    public int load(int offsetFromFramePointer) {
        int index = framePointer.peek() + offsetFromFramePointer;
        int value = runTimeStack.get(index);
        runTimeStack.add(value);
        return value;
    }

    /**
     * create a new frame pointer at the index offset slots down
     * from the top of the runtime stack .
     *
     * @param offset slots down from the top of the runtime stack
     */
    public void newFrameAt(int offsetFromTopOfRunStack) {

        framePointer.add(offsetFromTopOfRunStack);
    }

    /**
     * pop the current frame off the runtime stack . Also removes
     * the frame pointer value from the FramePointer Stack .
     */
    public void popFrame() {
        framePointer.pop();
    }

    public int size() {
        return runTimeStack.size();
    }

    public int frameSize() {
        return size() - framePeek();
    }

    public int framePeek() {
        return framePointer.peek();
    }

    public int getRunTimeStack(int i) {
        return runTimeStack.get(i);
    }

}
