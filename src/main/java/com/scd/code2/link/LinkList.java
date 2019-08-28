package com.scd.code2.link;

import com.scd.code2.IList;
import com.scd.exception.OutOfSizeException;

/**
 * @author chengdu
 * @date 2019/8/26.
 */
public class LinkList<E>  implements IList<E> {

    private Node<E> head;

    private int curLen;

    public LinkList(){
        head = new Node<>();
        curLen = 0;
    }


    @Override
    public void add(E e) {
        Node<E> node = new Node<>(e);
        node.next = head;
        head = node;
        curLen++;
    }

    @Override
    public void insert(int i, E e) {
        if (i < 0|| i > curLen){
            throw new OutOfSizeException("index "+ i +" out of size");
        }
        Node node = new Node(e);
        // 找到当前节点和前驱节点
        Node curNode = head;
        Node preNode = null;
        for (int j = 0; j < i; j++){
            preNode = curNode;
            curNode = curNode.next;
        }
        // 前驱节点为空的情况
        if (preNode == null) {
            node.next = head;
            head = node;
        } else {
            preNode.next = node;
            node.next = curNode;
        }
        curLen++;
    }

    @Override
    public E remove(int i) {
        if (i < 0|| i >= curLen){
            throw new OutOfSizeException("index "+ i +" out of size");
        }
        // 找到当前节点和前驱节点
        Node curNode = head;
        Node preNode = null;
        for (int j = 0; j < i; j++){
            preNode = curNode;
            curNode = curNode.next;
        }
        // 前驱节点为空的情况
        E e = (E) curNode.e;;
        if (preNode == null) {
            head = head.next;
        } else {
            preNode.next = curNode.next;
        }
        curLen--;
        return e;
    }

    @Override
    public E get(int i) {
        if (i < 0|| i >= curLen){
            throw new OutOfSizeException("index "+ i +" out of size");
        }
        Node curNode = head;
        for (int j = 0; j < i; j++){
            curNode = curNode.next;
        }
        return (E) curNode.e;
    }

    @Override
    public int indexOf(E e) {
        Node<E> curNode = head;
        int i = 0;
        while (curNode.next != null){
            if (curNode.e != null && curNode.e.equals(e)){
                return i;
            }
            curNode = curNode.next;
            i++;
        }
        return -1;
    }

    @Override
    public int size() {
        return curLen;
    }

    @Override
    public void clear() {
        head = null;
        curLen = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void display() {
        Node<E> curNode = head;
        while (curNode.next != null){
            System.out.println(curNode.e);
            curNode = curNode.next;
        }
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void addCurLen(){
        curLen++;
    }

    public int getCurLen() {
        return curLen;
    }

    public void setCurLen(int curLen) {
        this.curLen = curLen;
    }
}
