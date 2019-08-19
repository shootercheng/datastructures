package com.scd.code1.ex;

/**
 * @author chengdu
 * @date 2019/8/19.
 */
public class CodeExTwo {

    public static long power(long x, long i){
        if (i == 0){
            return 1;
        }
        return x * power(x, i - 1);
    }

    public static void main(String[] args){
        System.out.println(power(2, 2));
    }
}
