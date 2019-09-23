package com.scd.code3.queue;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "PriorityData{" +
                "element=" + element +
                ", priority=" + priority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriorityData<?> that = (PriorityData<?>) o;
        return priority == that.priority &&
                Objects.equals(element, that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, priority);
    }
}
