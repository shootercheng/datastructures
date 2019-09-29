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
        char[] insertChars = str.getCharArr();
        return null;
    }

    @Override
    public IString delete(int begin, int end) {
        char[] deletedChars = new char[end - begin];
        int index = 0;
        for (int i = 0; i < begin; i++) {
            deletedChars[index] = strValue[i];
            index++;
        }
        for (int i = begin; i < end; i++) {
            deletedChars[index] = strValue[i];
            index++;
        }
        return new SeqString(deletedChars);
    }

    @Override
    public IString concat(IString str) {
        char[] concatChars = str.getCharArr();
        int minLength = curLen + concatChars.length;
        int index = 0;
        for(int i = curLen; i < minLength; i++) {
            strValue[i] = concatChars[index];
            index++;
        }
        return new SeqString(strValue);
    }


    @Override
    public int compareTo(IString str) {
        return 0;
    }

    @Override
    public int indexOf(String str, int length) {
        return 0;
    }

    @Override
    public char[] getCharArr() {
        return strValue;
    }
}
