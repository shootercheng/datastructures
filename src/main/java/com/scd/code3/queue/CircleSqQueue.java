package com.scd.code3.queue;

/**
 * @author James Chen
 * @date 21/09/19
 */
public class CircleSqQueue<E> implements IQueue<E> {

    private Object[] elements;

    private int front;

    private int rear;

    private int flag;

    private int maxSize;

    public CircleSqQueue(int maxSize){
        front = rear = 0;
        flag = 0;
        this.maxSize = maxSize;
        elements = new Object[maxSize];
    }

    @Override
    public void clear() {
        front = rear = 0;
        flag = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == rear && flag == 0;
    }

    @Override
    public int length() {
        if (front == rear) {
            if (flag == 0) {
                return 0;
            } else {
                return maxSize;
            }
        }
        return rear - front;
    }

    @Override
    public E peek() {
        return (E) elements[front];
    }

    @Override
    public void offer(E e) throws Exception {
        if (length() == maxSize) {
            throw new RuntimeException("queue is max size");
        }
        elements[rear] = e;
        rear = (rear + 1) % maxSize;
        flag = 1;
    }

    @Override
    public E poll() {
        E e = (E) elements[front];
        front = (front + 1) % maxSize;
        flag = 0;
        return e;
    }

    @Override
    public void disPlay() {
        if (front != rear) {
            for (int i = front; i < rear; i++) {
                System.out.println(elements[i]);
            }
        } else {
            if (flag == 1) {
                for (int i = front; i < maxSize; i++) {
                    System.out.println(elements[i]);
                }
                for (int i = 0; i < front; i++) {
                    System.out.println(elements[i]);
                }
            } else {
                System.out.println("queue is empty");
            }
        }
    }
}
