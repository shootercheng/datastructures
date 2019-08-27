package com.scd.code2.link;

/**
 * @author chengdu
 * @date 2019/8/27.
 */
public class Node<E> {

    protected E e;

    protected Node next;

    public Node(){
    }

    public Node(E e){
        this.e = e;
    }

    public Node(E e, Node next){
        this.e = e;
        this.next = next;
    }
}
