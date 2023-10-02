package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class AddOperator extends Operator{



    @Override
    public int priority() {
        return 1;
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        int value=operandOne.getValue()+operandTwo.getValue();
        return new Operand(value);
    }

    @Override
    public String getToken() {
        return "+";
    }
}
