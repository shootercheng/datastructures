package com.scd.code4.seqstr;

import java.util.Arrays;

/**
 * @author James Chen
 * @date 29/09/19
 */
public class SeqString implements IString {

    private char[] strValue;

    private int curLen;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public SeqString() {
        strValue = new char[0];
        curLen = 0;
    }

    public SeqString(String value) {
        strValue = value.toCharArray();
        curLen = strValue.length;
    }

    public SeqString(char[] values) {
        strValue = values;
        curLen = strValue.length;
    }

    @Override
    public void clear() {
        curLen = 0;
        strValue = new char[0];
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public char charAt(int index) {
        return strValue[index];
    }

    @Override
    public IString substring(int begin, int end) {
        char[] subRes = new char[end - begin];
        int index = 0;
        for (int i = begin; i < end; i++) {
            subRes[index] = strValue[i];
            index++;
        }
        return new SeqString(subRes);
    }

    @Override
    public IString insert(int offset, IString str) {
        if (offset < 0 || offset >= curLen) {
            throw new RuntimeException("offset location error");
        }
        char[] insertChars = str.getCharArr();
        int insertLength = str.length();
        int newlength = curLen + insertLength;
        char[] newChars = new char[newlength];
        int index = 0;
        for (int i = 0; i < offset; i++) {
            newChars[index++] = strValue[i];
        }
        for (int i = 0; i < insertLength; i++) {
            newChars[index++] = insertChars[i];
        }
        for (int i = offset; i < curLen; i++) {
            newChars[index++] = strValue[i];
        }
        return new SeqString(newChars);
    }

    @Override
    public IString delete(int begin, int end) {
        char[] newChars = new char[curLen - (end - begin)];
        int index = 0;
        for (int i = 0; i < begin; i++) {
            newChars[index++] = strValue[i];
        }
        for (int i = end; i < curLen; i++) {
            newChars[index++] = strValue[i];
        }
        return new SeqString(newChars);
    }

    @Override
    public IString concat(IString str) {
        char[] concatChars = str.getCharArr();
        int minLength = curLen + concatChars.length;
        int index = 0;
        strValue = Arrays.copyOf(strValue, minLength);
        for(int i = curLen; i < minLength; i++) {
            strValue[i] = concatChars[index++];
        }
        return new SeqString(strValue);
    }


    @Override
    public int compareTo(IString str) {
        char[] anotherArr = str.getCharArr();
        int lim = Math.min(curLen, str.length());
        int k = 0;
        // 比较每个字符
        while (k < lim) {
            char c1 = strValue[k];
            char c2 = anotherArr[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return curLen - str.length();
    }

    @Override
    public int indexOf(String str, int begin) {
        if (str == null || str.length() == 0) {
            throw new RuntimeException("str is empty");
        }
        if (begin < 0 || begin >= curLen) {
            throw new RuntimeException("location is error");
        }
        char[] findArr = str.toCharArray();
        int index = -1;
        for (int i = begin; i < curLen - str.length(); i++) {
            if (findArr[0] == strValue[i]) {
                index = i;
                break;
            }
        }
        boolean notFind = false;
        for (int i = 1; i < findArr.length; i++) {
            if (index + i > curLen) {
                notFind = true;
                break;
            }
            if (findArr[i] != strValue[index + i]) {
                notFind = true;
                break;
            }
        }
        if (notFind) {
            return -1;
        }
        return index;
    }

    @Override
    public char[] getCharArr() {
        return strValue;
    }
}
