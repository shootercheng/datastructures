package com.scd.code3.queue;

import com.scd.code3.Node;

/**
 * @author James Chen
 * @date 22/09/19
 */
public class LinkQueue<E> implements IQueue<E> {

    private Node<E> front;

    private Node<E> rear;

    public LinkQueue() {
        front = rear = null;
    }

    @Override
    public void clear() {
        front = rear = null;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int length() {
        Node p = front;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    @Override
    public E peek() {
        if (front == null) {
            return null;
        } else {
            return front.e;
        }
    }

    @Override
    public void offer(E e) throws Exception {
        Node<E> node = new Node<>(e);
        if (front == null) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    @Override
    public E poll() {
        if (front == null) {
            return null;
        } else {
            Node<E> node = front;
            front = front.next;
            if (node == rear) {
                rear = null;
            }
            return node.e;
        }
    }

    @Override
    public void disPlay() {
        if (front == null) {
            System.out.println("Link queue is empty");
        }
        Node<E> node = front;
        while (node != null) {
            System.out.println(node.e);
            node = node.next;
        }
    }
}
