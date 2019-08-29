package com.scd.code3.stack;

import com.scd.exception.OutOfSizeException;

/**
 * @author chengdu
 * @date 2019/8/29.
 */
public class SqStack<E> implements IStack<E> {

    private Object[] stackElem;

    private int top;

    public SqStack(int size){
        top = 0;
        stackElem = new Object[size];
    }


    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int length() {
        return top;
    }

    @Override
    public E peek() {
        return (E) stackElem[top - 1];
    }

    @Override
    public void push(E e) {
        if (top == stackElem.length){
            throw new OutOfSizeException("stack size " + length());
        }
        stackElem[top] = e;
        top++;
    }

    @Override
    public E pop() {
        if (top == 0){
            throw new RuntimeException("stack bottom");
        }
        E topData = (E) stackElem[top - 1];
        stackElem[top - 1] = null;
        top--;
        return topData;
    }
}
