package com.scd.code1;

import java.util.Arrays;

/**
 * @author chengdu
 * @date 2019/8/14.
 */
public class ArrayData {

    public static int findMax(int[] a){
        int max = a[0];
        for (int i = 0; i < a.length; i++){
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int findMin(int[] a){
        int min = a[0];
        for (int i = 0; i < a.length; i++){
            if (a[i] < min){
                min = a[i];
            }
        }
        return min;
    }

    public static int[] reverse(int[] a){
        int length = a.length;
        for (int i = 0, j = length - 1; i < j; i++, j--){
            swap(i,j,a);
        }
        return a;
    }

    public static void bubbleSort(int[] a){
        int length = a.length;
        for (int j = length - 1; j > 0; j--) {
            // 一次冒泡
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1, a);
                }
            }
            printSortInfo(a);
        }
    }

    public static void printSortInfo(int[] a){
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < a.length; i++) {
            stringBuilder.append(a[i]).append(",");
        }
        String result = stringBuilder.toString();
        if (result.length() > 1){
            result = result.substring(0, result.length() - 1);
        }
        System.out.println(result);
    }

    public static void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
