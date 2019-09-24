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
        if(!(e instanceof PriorityData)) {
            throw new RuntimeException("not prioritydata");
        }
        Node<E> node = new Node<>(e);
        if (front == null) {
            front = rear = node;
        } else {
            Node<E> p = front,q = front;
            PriorityData priorityData = (PriorityData) e;
            // 寻找插入节点位置
            while ( p != null && priorityData.priority <= ((PriorityData) p.e).priority) {
                q = p;
                p = p.next;
            }
            // node 优先级非常小, 插入队尾
            if (p == null) {
                rear.next = node;
                rear = node;
            } else if (p == front) {
                // node 优先级非常大， 插入队首
                node.next = front;
                front = node;
            } else {
                // node 优先级位于 p,q 之间
                q.next = node;
                node.next = p;
            }

        }
    }

    @Override
    public E poll() {
        if (front == null) {
            return null;
        } else {
            Node<E> node = front;
            front = front.next;
            return node.e;
        }
    }

    @Override
    public void disPlay() {
        Node p = front;
        while (p != null) {
            p = p.next;
            System.out.println(p.e);
        }
    }
}
