package com.scd.code3.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author chengdu
 * @date 2019/9/16.
 */
public class MathExpression {

    private static Map<Character, Integer> operatorPriority = new HashMap<>();

    static {
        operatorPriority.put('(', 0);
        operatorPriority.put('+', 1);
        operatorPriority.put('-', 1);
        operatorPriority.put('*', 2);
        operatorPriority.put('/', 2);
        operatorPriority.put('%', 2);
        operatorPriority.put('^', 4);
    }

    public static boolean isOperator(char c) {
        if (operatorPriority.containsKey(c) || ')' == c) {
            return true;
        }
        return false;
    }

    public static boolean isLeft(char c) {
        return c == '(';
    }

    public static boolean isRight(char c) {
        return c == ')';
    }

    public static String convertToPostfix(String input){
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder("");
        char[] charArr = input.toCharArray();
        for (char c : charArr) {
            if (c == ' '){
                continue;
            }
            if (!isOperator(c)) {
                result.append(c);
            } else if (isLeft(c)) {
                stack.push(c);
            } else if (isRight(c)) {
                    Character top = stack.pop();
                    while (!isLeft(top)){
                        result.append(top);
                        top = stack.pop();
                    }
            } else if (isOperator(c)) {
                // 比较运算符的优先级
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    int curPriority = operatorPriority.get(c);
                    while (true) {
                        if (stack.isEmpty()) {
                            break;
                        }
                        char top = stack.peek();
                        int topPriority = operatorPriority.get(top);
                        if (curPriority > topPriority) {
                            break;
                        }
                        result.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static double calExp(String postfixExp) {
        Stack<Double> stack = new Stack<>();
        char[] charArr = postfixExp.toCharArray();
        for (char c : charArr) {
            if (!isOperator(c)) {
                stack.push(Double.valueOf(String.valueOf(c)));
            } else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                double result = calTwoNumber(c, num1, num2);
                stack.push(result);
            }
        }
        if (stack.size() == 1) {
            return stack.pop();
        } else {
            throw new RuntimeException("postfixexp error");
        }
    }

    private static double calTwoNumber(char c, double num1, double num2) {
        double result = 0;
        switch (c) {
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }

    public static void main(String[] args){
        String input = "(A+B) * (C-D) / E^F + G % H";
//        String input = "-2";
//        String input = "1";
        // 1*2+3        // 12*3+
        // 1*2*3+4      // 12*3*4+
        // 1+2*3/4      // 123*4/+
        // 1*2+3-4-5    // 12*3+4-5-
        // (1+2)*3      // 12+3*
        // (-2) * (-3)
        String res = convertToPostfix(input);
        System.out.println("postfix: " +res);
//        System.out.println("result: " + calExp(res));
    }
}
