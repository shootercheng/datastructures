package com.scd.code2;

/**
 * @author chengdu
 * @date 2019/8/25.
 */
public interface IList<E> {


    void add(E e);

    void insert(int i, E e);

    E remove(int i);

    E get(int i);

    int indexOf(E e);

    int size();

    void clear();

    boolean isEmpty();

    void display();
}
