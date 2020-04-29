package com.scd.str;

import java.util.Scanner;

/**
 * @author James
 */
public class MaxStr {

    public static String findMaxStr(String stra, String strb) {
        String result = "";
        int maxLen = 0;
        for (int i = 0; i < stra.length(); i++) {
            for (int j = i+1; j <= stra.length(); j++) {
                String subStr = stra.substring(i, j);
                System.out.println(subStr);
                if (strb.contains(subStr) && subStr.length() > maxLen) {
                    maxLen = subStr.length();
                    result = subStr;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        String stra = "aaaebbbeddd";
//        String strb = "debbbeeeeee";
        String stra = "abcdefghijklmnop";
        String strb = "abcsafjklmnopqrstuvw";
        System.out.println(findMaxStr(stra, strb));
    }
}
