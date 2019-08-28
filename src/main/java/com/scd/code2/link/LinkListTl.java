package com.scd.code2.link;

import com.scd.code2.IList;
import com.scd.exception.OutOfSizeException;

/**
 * 尾插法
 * @author chengdu
 * @date 2019/8/27.
 */
public class LinkListTl<E> extends LinkList<E>  implements IList<E> {

    private Node<E> temp;

    public LinkListTl(){
        super();
        temp = super.getHead();
    }

    @Override
    public void add(E e) {
        Node<E> node = new Node<>(e);
        temp.next = node;
        temp = node;
        addCurLen();
    }

    @Override
    public void insert(int i, E e) {
        super.insert(i, e);
    }

    @Override
    public E remove(int i) {
        return super.remove(i);
    }

    @Override
    public E get(int i) {
        return super.get(i);
    }

    @Override
    public int indexOf(E e) {
        return super.indexOf(e);
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void clear() {
        super.setHead(null);
        temp = null;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void display() {
        super.display();
    }
}
