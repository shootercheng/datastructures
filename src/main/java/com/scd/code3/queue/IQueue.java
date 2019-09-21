package com.scd.code3.queue;

/**
 * @author James Chen
 * @date 21/09/19
 */
public interface IQueue<E> {

    void clear();

    boolean isEmpty();

    int length();

    E peek();

    void offer(E e) throws Exception;

    E poll();
}
