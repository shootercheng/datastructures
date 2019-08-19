package com.scd.code1.ex;

/**
 * @author chengdu
 * @date 2019/8/19.
 */
public class CodeExOne {

    public static int findMaxIndex(int[] a){
        int maxIndex = 0;
        int max = a[maxIndex];
        for (int i = 1; i < a.length; i++){
            if (a[i] > max){
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args){
        int[] a = {1,9,8,4,5,-2};
        int maxIndex = findMaxIndex(a);
        System.out.println("max index is " + maxIndex);
        System.out.println("max num is " + a[maxIndex]);
    }
}
