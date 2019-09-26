package com.scd.code3.exercises;

import com.scd.code3.stack.LinkStack;

/**
 * @author James Chen
 * @date 26/09/19
 */
public class ExerciseTwo {

    public static void main(String[] args) {
        LinkStack<Character> linkStack = new LinkStack<>();
        String input = "abba";
        char[] chars1 = input.toCharArray();
        for (char c : chars1) {
            linkStack.push(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!linkStack.isEmpty()) {
            stringBuilder.append(linkStack.pop());
        }
        String reverse = stringBuilder.toString();
        if (reverse.equals(input)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
