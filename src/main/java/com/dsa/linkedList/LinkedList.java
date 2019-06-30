package com.dsa.linkedList;

public class LinkedList {
    private LLNode head;

    public void add(int data) {
        if (head == null) {
            head = new LLNode(data, null);
            return;
        }
        LLNode node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(new LLNode(data, null));
        return;
    }

    public void traverse() {
        LLNode node = head;

        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        ll.traverse();
    }
}
