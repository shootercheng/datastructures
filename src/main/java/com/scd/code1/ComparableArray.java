package com.scd.code1;

/**
 * @author chengdu
 * @date 2019/8/18.
 */
public class ComparableArray {

    public static Comparable findMax(Comparable[] comparables){
        int maxIndex = 0;
        for (int i = 1; i < comparables.length; i++){
            if (comparables[i].compareTo(comparables[maxIndex]) > 0){
                maxIndex = i;
            }
        }
        return comparables[maxIndex];
    }

    public static void main(String[] args){
        String[] chstrs = {"A","B","C","a","b","c1","c2"};
        System.out.println(findMax(chstrs));
    }
}
