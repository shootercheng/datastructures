package com.scd.code2;

import com.scd.exception.LocationException;
import com.scd.exception.OutOfSizeException;

/**
 * @author chengdu
 * @date 2019/8/25.
 */
public class SeqList<E> implements IList<E>{

    private Object[] listElem;

    private int curLen;

    public SeqList(int maxSize) {
        listElem = new Object[maxSize];
        curLen = 0;
    }

    public void add(E e){
        if (curLen == listElem.length){
            throw new OutOfSizeException("out of array size exception");
        }
        listElem[curLen] = e;
        curLen++;
    }

    @Override
    public void insert(int i, E e) {
        if (curLen == listElem.length){
            throw new OutOfSizeException("out of array cur size");
        }
        if (i < 0 || i > curLen){
            throw new LocationException("insert location error");
        }
        for (int j = curLen; j > i; j--){
            listElem[j] = listElem[j-1];
        }
        listElem[i] = e;
        curLen++;
    }

    @Override
    public E remove(int i) {
        if (i < 0 || i > curLen){
            throw new LocationException("remove location error");
        }
        E e = (E) listElem[i];
        for (int j = i; j < curLen - 1; j++){
            listElem[j] = listElem[j+1];
        }
        listElem[curLen - 1] = null;
        curLen --;
        return e;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i > curLen){
            throw new LocationException("get location error");
        }
        return (E) listElem[i];
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < curLen; i++){
            if (listElem[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return curLen;
    }

    @Override
    public void clear() {
        for (int i = 0; i < curLen; i++){
            listElem[i] = null;
        }
        curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @Override
    public void display() {
        if (curLen == 0){
            System.out.println("is empty");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < curLen; i++){
            stringBuilder.append(listElem[i]).append(",");
        }
        String result = stringBuilder.toString();
        System.out.println(result.substring(0, result.length() - 1));
    }
}
