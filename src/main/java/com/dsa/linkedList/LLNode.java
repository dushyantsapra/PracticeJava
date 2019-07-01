package com.dsa.linkedList;

public class LLNode<T> {
    private T data;
    private LLNode next;

    public LLNode() {
    }

    public LLNode(T data, LLNode next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LLNode<T> getNext() {
        return next;
    }

    public void setNext(LLNode<T> next) {
        this.next = next;
    }
}
