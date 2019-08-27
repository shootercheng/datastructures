package com.scd.code2.link;

import com.scd.code2.IList;

/**
 * 尾插法
 * @author chengdu
 * @date 2019/8/27.
 */
public class LinkListTl<E> implements IList<E> {

    private Node<E> head;

    private Node<E> temp;

    private int curLen;

    public LinkListTl(){
        head = new Node<>();
        temp = head;
    }

    @Override
    public void add(E e) {
        Node<E> node = new Node<>(e);
        temp.next = node;
        temp = node;
        curLen++;
    }

    @Override
    public void insert(int i, E e) {

    }

    @Override
    public E remove(int i) {
        return null;
    }

    @Override
    public E get(int i) {
        return null;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void display() {

    }
}
