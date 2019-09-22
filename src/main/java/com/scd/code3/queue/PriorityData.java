package com.scd.code3.queue;

/**
 * @author James Chen
 * @date 22/09/19
 */
public class PriorityData<E> {

    protected E element;

    protected int priority;

    public PriorityData(E element, int priority) {
        this.element = element;
        this.priority = priority;
    }
}
