package com.scd.code4.seqstr;

/**
 * KMP
 * @author James Chen
 * @date 10/10/19
 */
public class KMPStr {

    public static int[] getNext(String matchStr) {
        int[] next = new int[matchStr.length()];
        int j = 1;
        int k = 0;
        next[0] = -1;
        next[1] = 0;
        int matchStrLen = matchStr.length();
        char[] matchCharArr = matchStr.toCharArray();
        while (j < matchStrLen - 1) {
            if (matchCharArr[j] == matchCharArr[k]) {
                next[j+1] = k+1;
                j++;
                k++;
            } else if (k == 0) {
                next[j+1] = 0;
                j++;
            } else {
                k = next[k];
            }
        }
        return next;
    }


    public static void main(String[] args) {
        String inputStr = "abcabc";
        int[] result = getNext(inputStr);
        System.out.println(result);
    }
}
