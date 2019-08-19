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

    /**
     * 时间复杂度
     * n + n-1 + n-2 + ... + 1
     * @param a
     * @return
     */
    public static int maxSumSub(int[] a){
        int max = 0;
        int length = a.length;
        for (int j = 0; j < length; j++) {
            int sum = 0;
            for (int i = j; i < length; i++) {
                sum = sum + a[i];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int maxSumSub2(int[] a){
        int max = 0;
        int length = a.length;
        int sum = 0;
        for (int i = 0; i < length; i++){
            sum += a[i];
            if (sum > max){
                max = sum;
            } else if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] a = {-1,2,3,-4,5,-6,7,8,9,-10};
        System.out.println(maxSumSub(a));
        System.out.println(maxSumSub2(a));
    }
}
