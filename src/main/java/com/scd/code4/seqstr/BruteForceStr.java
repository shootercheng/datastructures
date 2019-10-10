package com.scd.code4.seqstr;

/**
 * brute force 模式匹配算法
 * @author James Chen
 * @date 10/10/19
 */
public class BruteForceStr {

    public static int indexOfBf(String mainStr, String matchStr, int start) {
        if (mainStr == null || mainStr.length() == 0) {
            throw new RuntimeException("main str is empty");
        }
        if (matchStr == null || matchStr.length() == 0) {
            throw new RuntimeException("match str is empty");
        }
        int mainLen = mainStr.length();
        int matchLen = matchStr.length();
        if (matchLen > mainLen) {
            throw new RuntimeException("match str len > main str len");
        }
        if (start < 0 || start > mainLen - 1) {
            throw new RuntimeException("start location error");
        }
        int i = start,j = 0;
        char[] mainCharArr = mainStr.toCharArray();
        char[] matchCharArr = matchStr.toCharArray();
        while ((i < mainLen) && (j < matchLen)) {
            if (mainCharArr[i] == matchCharArr[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == matchLen) {
            return i - matchLen;
        }
        return -1;
    }
}
