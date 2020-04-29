package com.scd.code5;

/**
 * @author chengdu
 * @date 2019/10/20.
 */
public class BiTreeNode<T> {
    protected T data;

    protected BiTreeNode<T> lchild;

    protected BiTreeNode<T> rchild;

    public BiTreeNode() {
    }

    public BiTreeNode(T data) {
        this.data = data;
    }

    public BiTreeNode(T data, BiTreeNode lchild, BiTreeNode rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }
}
