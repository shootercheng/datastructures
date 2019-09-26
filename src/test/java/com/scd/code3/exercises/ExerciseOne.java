package com.scd.code3.exercises;

import com.scd.code3.stack.SqStack;

/**
 * @author James Chen
 * @date 26/09/19
 */
public class ExerciseOne {

    public static void main(String[] args) {
        int[] numArr = {1,2,3,4,5};
        SqStack<Integer> integerSqStack = new SqStack<>(5);
        for (int i = 0; i < numArr.length; i++) {
            integerSqStack.push(numArr[i]);
        }
        while (!integerSqStack.isEmpty()) {
            System.out.println(integerSqStack.pop());
        }
    }
}
