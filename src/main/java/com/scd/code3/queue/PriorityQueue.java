package com.scd.code3.queue;

/**
 * @author James Chen
 * @date 22/09/19
 */
public class PriorityQueue<E> implements IQueue<E> {

    private Node<E> front;

    private Node<E> rear;

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
        if (front == null) {
            return 0;
        }
        Node node = front;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    @Override
    public E peek() {
        if (front == null) {
            return null;
        }
        return front.e;
    }

    @Override
    public void offer(E e) throws Exception {

    }

    @Override
    public E poll() {
        if (front == null) {
            return null;
        }
        Node<E> node = front;
        front = node.next;
        if (node == rear) {
            rear = null;
        }
        return node.e;
    }

    @Override
    public void disPlay() {

    }
}
