package com.scd.code3.exercises;

import com.scd.code3.stack.LinkStack;

/**
 * @author James Chen
 * @date 27/09/19
 */
public class TenToN {

    public static String convertToN(int num, int n) {
        LinkStack<Integer> intStack = new LinkStack<>();
        int a = num;
        while (true) {
            int b = a % n;
            intStack.push(b);
            a = a / n;
            if( a < n){
                intStack.push(a);
                break;
            }
        }
        StringBuilder stringBuilder =  new StringBuilder("");
        while (!intStack.isEmpty()){
            stringBuilder.append(intStack.pop());
        }
        return stringBuilder.toString();
    }
}
