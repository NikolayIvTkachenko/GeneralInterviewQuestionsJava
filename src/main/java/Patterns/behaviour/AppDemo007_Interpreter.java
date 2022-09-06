package Patterns.behaviour;

import java.util.Stack;

public class AppDemo007_Interpreter {

    public static void main(String[] args) {

        String expression = " 2+3+4-5";
        Expression evaluator = new Evaluate(expression);
        System.out.println(evaluator.interpreter(evaluator));

    }
}

interface Expression {
    int interpreter(Expression context);
}

class Number implements Expression {

    int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpreter(Expression context) {
        return number;
    }
}

class Plus implements  Expression {

    Expression expressionLeft;
    Expression expressionRight;

    public Plus(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int interpreter(Expression context) {
        return expressionLeft.interpreter(context) + expressionRight.interpreter(context);
    }
}

class Minus implements  Expression {

    Expression expressionLeft;
    Expression expressionRight;

    public Minus(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int interpreter(Expression context) {
        return expressionLeft.interpreter(context) - expressionRight.interpreter(context);
    }
}

class Evaluate implements Expression {
    Expression evaluate;

    public Evaluate(String expression){
        Stack<Expression> expressionStack = new Stack<>();
        String expressionRever = new StringBuilder(expression).reverse().toString();
        for(String str : expressionRever.split("\\D")){
            expressionStack.push(new Number(Integer.parseInt(str)));
        }
        for(String s: expression.split("\\d")){
            if(s.equals("+")) {
                expressionStack.push(new Plus(expressionStack.pop(), expressionStack.pop()));
            } else if (s.equals("-")) {
                expressionStack.push(new Minus(expressionStack.pop(), expressionStack.pop()));
            }
        }
        evaluate = expressionStack.pop();
    }

    @Override
    public int interpreter(Expression context) {
        return evaluate.interpreter(context);
    }
}