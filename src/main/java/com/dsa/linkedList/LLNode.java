package com.dsa.linkedList;

public class LLNode {
    private int data;
    private LLNode next;

    public LLNode() {
    }

    public LLNode(int data, LLNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }
}
