package com.forbetter223.Stack;


public class StackTest {
    public static void main(String[] args){
//        ImitationStack imitationStack = new ImitationStack(5);
//        imitationStack.pop();
//        imitationStack.push("1");
//        imitationStack.push("2");
//        imitationStack.push("3");
//        imitationStack.push("4");
//        imitationStack.push("5");
//        imitationStack.push("6");
//        imitationStack.pop();
//        imitationStack.pop();
//        imitationStack.pop();
//        imitationStack.pop();
//        imitationStack.pop();
//        MathExpressionCalculation calculation = new MathExpressionCalculation();
//        double re = calculation.calculate("1+2+1+2+1+2-3-3-3");
//        System.out.printf("计算结果：%f", re);
        ReversePolishExpression polishExpression = new ReversePolishExpression();
//        List<String> polishList = polishExpression.stringConvertToReversePolish("(10+20)*3-4/((5-3)*1)");
//        polishList.forEach(i -> System.out.println(String.valueOf(i)));
        polishExpression.calculate("(10+20)*3-4/((5-3)*1)");
        polishExpression.calculate("1.2+8.8-(3-1)*2/2+2");
        polishExpression.calculate("5+25/5*(10-5*1)-(6-1)*2");
        polishExpression.calculate("1+((2+3)*4)-5");
    }
}
