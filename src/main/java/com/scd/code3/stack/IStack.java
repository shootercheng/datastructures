package com.scd.code3.stack;

/**
 * @author chengdu
 * @date 2019/8/29.
 */
public interface IStack<E> {

    void clear();

    boolean isEmpty();

    int length();

    E peek();

    void push(E e);

    E pop();
}
