package com.scd.code3.stack;

import com.scd.code3.Node;

/**
 * @author James Chen
 * @date 26/09/19
 */
public class LinkStack<E> implements IStack<E> {

    private Node<E> top;

    public LinkStack() {

    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int length() {
        int i = 0;
        Node<E> head = top;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        } else {
            return top.e;
        }
    }

    @Override
    public void push(E e) {
        Node<E> node = new Node<>(e);
        node.next = top;
        top = node;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> head = top;
        top = top.next;
        return head.e;
    }
}
