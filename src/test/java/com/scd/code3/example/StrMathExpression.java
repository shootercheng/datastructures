package com.scd.code3.example;

import java.util.*;

/**
 * @author chengdu
 * @date 2019/9/18.
 */
public class StrMathExpression {

    private static Map<String, Integer> operatorPriority = new HashMap<>();

    static {
        operatorPriority.put("(", 0);
        operatorPriority.put("+", 1);
        operatorPriority.put("-", 1);
        operatorPriority.put("*", 2);
        operatorPriority.put("/", 2);
        operatorPriority.put("%", 2);
        operatorPriority.put("^", 4);
    }

    public static boolean isOperator(String c) {
        if (operatorPriority.containsKey(c) || ")".equals(c)) {
            return true;
        }
        return false;
    }

    public static boolean isLeft(String c) {
        return "(".equals(c);
    }

    public static boolean isRight(String c) {
        return ")".equals(c);
    }

    public static List<String> convertToPostfix(List<String> inputList){
        Stack<String> stack = new Stack<>();
        List<String> postFixList = new ArrayList<>(inputList.size());
        for (String c : inputList) {
            if (" ".equals(c)){
                continue;
            }
            if (!isOperator(c)) {
                postFixList.add(c);
            } else if (isLeft(c)) {
                stack.push(c);
            } else if (isRight(c)) {
                String top = stack.pop();
                while (!isLeft(top)){
                    postFixList.add(top);
                    top = stack.pop();
                }
            } else if (isOperator(c)) {
                // 比较运算符的优先级
                if (!stack.isEmpty()) {
                    int curPriority = operatorPriority.get(c);
                    while (true) {
                        if (stack.isEmpty()) {
                            break;
                        }
                        String top = stack.peek();
                        int topPriority = operatorPriority.get(top);
                        if (curPriority > topPriority) {
                            break;
                        }
                        postFixList.add(stack.pop());
                    }
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postFixList.add(stack.pop());
        }
        return postFixList;
    }

    private static double calExp(List<String> postfixExp) {
        Stack<Double> stack = new Stack<>();
        for (String c : postfixExp) {
            if (!isOperator(c)) {
                stack.push(Double.valueOf(String.valueOf(c)));
            } else {
                double num1 = stack.pop();
                double num2 = stack.pop();
                double result = calTwoNumber(c.charAt(0), num1, num2);
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
            case '%':
                result = num2 % num1;
                break;
            case '^':
                result = Math.pow(num2, num1);
                break;
            default:
                break;
        }
        return result;
    }


    public static List<String> convertInputList(String input){
        StringTokenizer stringTokenizer = new StringTokenizer(input, " +-*/%^()", true);
        List<String> inputList = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String word = stringTokenizer.nextToken();
            if (word.trim().length() == 0) {
                continue;
            }
            inputList.add(word);
        }
        List<String> convertlist = new ArrayList<>(inputList.size());
        for (int i = 0; i < inputList.size(); i++) {
            String str = inputList.get(i);
            if ("-".equals(str)) {
                if (i == 0 || "(".equals(inputList.get(i-1))) {
                    convertlist.add(str + inputList.get(i+1));
                    i++;
                }
            } else {
                convertlist.add(str);
            }
        }
        return convertlist;
    }




    public static void main(String[] args){
        // 左边无运算符，或左边为 左括号
        String input1 = "-2*3";
        String input2 = "(-2)*(-3)";
        String input3 = "(-2 * 3) - 4";
        String input4 = "-2.1 * 3+4";
        System.out.println(convertInputList(input2));
        System.out.println(Math.pow(-2, 3));
        String exp1 = "-2^3";
        String exp2 = "-2";
        String exp3 = "-2 / (-2) * (-3) + (4 + 5)";
        String exp4 = "-2 / (-2) * (-3) + (4.1 + 5.2) * 2";
        List<String> postFixList = convertToPostfix(convertInputList(exp4));
        double result = calExp(postFixList);
        System.out.println("postfix :" + postFixList);
        System.out.println("result :" + result);
    }
}
