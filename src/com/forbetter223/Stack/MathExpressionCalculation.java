package com.forbetter223.Stack;

import java.util.Stack;

/**
 * 栈的应用之一
 * 根据一串数学表达式计算该表达式的结果
 * 比如：1+2*3-4 它的结果是3
 * 用中缀表达式计算
 * 不考虑带（）和浮点数。
 */
public class MathExpressionCalculation {
    // 把字符串形式的表达式（如：1+2*3-4）分成两部分
    // 1.专门存放数字的栈
    Stack<Double> mathStack = new Stack<Double>();
    // 2.专门存放运算符的栈
    Stack<Character> operateStack = new Stack<Character>();

    /**
     * 计算表达式的值
     * @param expression 表达式
     * @return 表达式计算结果
     */
    public Double calculate(String expression) {
        // 每次循环字符串的起始位置
        int start = 0;
        // 循环字符串
        for (int c = 0; c < expression.length(); c++) {
            if (Character.isDigit(expression.charAt(c))) {
                // 当循环到最后一个数字时，直接把数字压栈
                if(c == expression.length() - 1){
                    String strNum = expression.substring(start);
                    start = c + 1;
                    mathStack.push(Double.parseDouble(strNum));
                }
                continue;
            } else {
                // 截取数字
                String strNum = expression.substring(start, c);
                start = c + 1;
                mathStack.push(Double.parseDouble(strNum));
                // 判断运算符的优先级
                // 如果当前运算符的优先级大于栈内运算符的运算符，直接入栈
                // 先判断运算符栈是否为空
                if (operateStack.empty() || getOperateLevel(expression.charAt(c)) > getOperateLevel(operateStack.peek())) {
                    operateStack.push(expression.charAt(c));
                } else {
                    // 如果当前运算符优先级小于或者等于栈顶运算符，先从数字栈中取出两个数
                    // 再从运算符栈中取出一个运算符，
                    // 计算它们的结果，把结果存到数字栈中
                    double topNum = mathStack.pop();
                    double bottomNum = mathStack.pop();
                    char operate = operateStack.pop();
                    // 计算表达式结果
                    double result = getCalculateResult(topNum,bottomNum,operate);
                    mathStack.push(result);
                    // 再把运算符入栈
                    operateStack.push(expression.charAt(c));
                }
            }
        }
        // 清空栈内剩余数据
        while(!mathStack.empty() && !operateStack.empty()){
            // 循环计算它们的结果，把结果存到数字栈中
            // 直到两个栈中其中一个栈为空
            double topNum = mathStack.pop();
            double bottomNum = mathStack.pop();
            char operate = operateStack.pop();
            // 计算表达式结果
            double result = getCalculateResult(topNum,bottomNum,operate);
            mathStack.push(result);
        }
        return mathStack.pop();
    }

    /**
     * 根据运算符求出表达式结果
     * @param top 栈顶元素
     * @param bottom 栈顶上一个元素
     * @param operate 运算符
     * @return 运算结果
     */
    private double getCalculateResult(double top, double bottom, char operate) {
        double result;
        switch (operate) {
            case '+':
                result = bottom + top;
                break;
            case '-':
                result = bottom - top;
                break;
            case '*':
                result = bottom * top;
                break;
            case '/':
                result = bottom / top;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    /**
     * 计算运算符的优先级
     *
     * @param operate
     * @return
     */
    private int getOperateLevel(char operate) {
        if (operate == '+' || operate == '-') {
            return 1;
        } else if (operate == '*' || operate == '/') {
            return 2;
        }
        return 0;
    }
}

/**
 * 把运算符定义成枚举
 * Operates的index越大，说明运算符的优先级越高
 */
enum Operates {
    ADD('+', 1),
    SUBTRACT('-', 2),
    MULTIPLY('*', 3),
    DIVIDE('/', 4);

    public char getOperate() {
        return operate;
    }

    public int getIndex() {
        return index;
    }

    private char operate;
    private int index;

    private Operates(char operate, int index) {
        this.operate = operate;
        this.index = index;
    }
}


