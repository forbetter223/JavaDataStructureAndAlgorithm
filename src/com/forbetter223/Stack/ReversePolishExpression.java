package com.forbetter223.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 计算数学表达式结果的另一种实现方式：逆波兰表达式，也叫后缀式
 * 逆波兰表达式的操作符需要置于操作数的后面。如：
 * 给定一个数学表达式:(1+2)*3-4/5，它的计算顺序是：
 * 先计算小括号里的1+2，再计算3*3，然后计算4/5，
 * 最后计算9-0
 * 它的逆波兰表达式是：1 2 + 3 * 4 5 / -
 * 计算顺序是1 2 +，
 * 3 3 *
 * 4 5 /
 * 9 0 -
 */
public class ReversePolishExpression {

    public void calculate(String expression) {
        // 中缀式转后缀式
        List<String> list = stringConvertToReversePolish(expression);
        // 创建一个栈存放逆波兰表达式的数字
        Stack<String> mathStack = new Stack<>();
        List<String> operates = new ArrayList<String>() {
            {
                this.add("+");
                this.add("-");
                this.add("*");
                this.add("/");
            }
        };
        // 逆波兰表达式入栈
        for (String item : list) {
            if (operates.contains(item)) {
                double top = Double.parseDouble(mathStack.pop());
                double bottom = Double.parseDouble(mathStack.pop());
                mathStack.push(String.valueOf(getCalculateResult(top, bottom, item)));
            } else {
                mathStack.push(item);
            }
        }
        System.out.printf("表达式计算结果: %s \n", mathStack.peek());
    }

    /**
     * 给定一个数学表达式，把它转成逆波兰表达式
     * 前人解决方案：
     * 循环表达式：
     * 1.当前字符是“(”,直接入栈。
     * 2.当前字符是“)”,循环栈内元素，把栈内元素依次添加到队列或者List中，直到遇到栈内元素为“(”,pop "(",结束循环
     * 3.当前字符是数字，直接添加到队列或者List中。
     * 4.当前字符是运算符：
     * 4.1 如果栈为空或者栈顶元素为“)”，直接入栈
     * 4.2 运算符优先级高于栈顶运算符优先级，直接入栈
     * 4.3 运算符优先级小于或者等于栈顶运算符优先级，
     * 需要循环栈，把栈内和当前运算符同级的运算符pop出来加入到队列或者List中。
     * 5.把栈内元素依次pop出加入到队列或者List中。
     *
     * @return 逆波兰表达式的一个List
     */
    private List<String> stringConvertToReversePolish(String expression) {
        // 创建一个List,它存放逆波兰表达式的结果
        List<String> polishList = new ArrayList<>();
        // 创建一个栈，它用来存放运算符，小括号。
        Stack<Character> operates = new Stack<>();
        // 用于截取字符串的辅助变量
        int start = 0;
        // 循环这个表达式，识别这个表达式里的数字,运算符和小括号
        for (int c = 0; c < expression.length(); c++) {
            // 判断当前的字符是否数字，如果是数字，继续循环，
            // 为了取多位数字和浮点数
            char exChar = expression.charAt(c);
            if (Character.isDigit(exChar) || '.' == exChar) {
                // 当表达式的最后一位是数字时，直接添加到polishList
                if (c == expression.length() - 1) {
                    polishList.add(expression.substring(c));
                }
                // 继续执行
//                continue;
            } else {
                if (start != 0 || (!expression.startsWith("(") && start == 0)) {
                    // 循环到不是数字的时候，首先截取这个数字
                    String number = expression.substring(start, c);
                    // 把数字加入到逆波兰list中
                    // 当遇到连续的小括号和运算符时需要判断number为不为空。
                    // exp:)*
                    if (!number.isEmpty()) {
                        polishList.add(number);
                    }
                }
                // 为截取字符串的开始变量+1,下次它会从运算符下一个数字开始截取
                start = c + 1;
                // 数字以外可能是运算符和小括号
                if (exChar == '(') {
                    // 如果是“(”时，直接入栈
                    operates.push(exChar);
                } else if (exChar == ')') {
                    // 如果是"("时，我们需要从栈顶开始循环，把所有运算符加到polishList中
                    // 直到栈中出现“)”号为止
                    while (!operates.empty()) {
                        if (operates.peek() != '(') {
                            polishList.add(String.valueOf(operates.pop()));
                        } else {
                            // 当遇到"("时，也需要把"("从栈中移出
                            operates.pop();
                            break;
                        }
                    }
                } else {
                    // "(“,”)"以外就是运算符了，在这里不对其他异常情况判断，比如空格，中文运算符等。
                    // 如果operates栈为空，或者栈顶元素为“（”时，运算符直接入栈
                    if (operates.empty() || operates.peek() == '(') {
                        operates.push(exChar);
                    } else if (getOperateLevel(exChar) > getOperateLevel(operates.peek())) {
                        // operates栈不为空，需要判断当前运算符和栈顶运算符的优先级
                        // 如果优先级大，直接入栈
                        // 其实这块也能判断栈顶元素是否为“(”,直接入栈。因为当operates.peek()为“(”时，
                        // getOperateLevel返回0，+-*/肯定比0大
                        operates.push(exChar);
                    } else {
                        // 如果当前运算符的优先级小于或者等于栈顶运算符的优先级
                        // 循环栈，把栈内和当前运算符同级的运算符pop出来加入List中。
                        while (!operates.empty()) {
                            if (getOperateLevel(exChar) <= getOperateLevel(operates.peek())) {
                                polishList.add(String.valueOf(operates.pop()));
                            } else {
                                break;
                            }
                        }
                        // 把循环得到的运算符压入到栈中
                        operates.push(exChar);
                    }
                }
            }
        }
        // 把operates栈中的元素依次添加到polishList中
        while (!operates.empty()) {
            polishList.add(String.valueOf(operates.pop()));
        }
        polishList.forEach(System.out::println);
        return polishList;
    }

    /**
     * 计算运算符的优先级
     *
     * @param operate 运算符
     * @return 运算符优先级
     */
    private int getOperateLevel(char operate) {
        if (operate == '+' || operate == '-') {
            return 1;
        } else if (operate == '*' || operate == '/') {
            return 2;
        }
        return 0;
    }

    /**
     * 根据运算符求出表达式结果
     *
     * @param top     栈顶元素
     * @param bottom  栈顶上一个元素
     * @param operate 运算符
     * @return 运算结果
     */
    private double getCalculateResult(double top, double bottom, String operate) {
        double result;
        switch (operate) {
            case "+":
                result = bottom + top;
                break;
            case "-":
                result = bottom - top;
                break;
            case "*":
                result = bottom * top;
                break;
            case "/":
                result = bottom / top;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}
