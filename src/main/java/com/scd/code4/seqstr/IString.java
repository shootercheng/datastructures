package com.scd.code4.seqstr;

/**
 * @author James Chen
 * @date 29/09/19
 */
public interface IString {

    void clear();

    boolean isEmpty();

    int length();

    char charAt(int index);

    IString substring(int begin, int end);

    IString insert(int offset, IString str);

    IString delete(int begin, int end);

    IString concat(IString str);

    int compareTo(IString str);

    int indexOf(String str, int begin);

    char[] getCharArr();
}
