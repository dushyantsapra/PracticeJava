package com.dsa.linkedList;

public class LinkedList<T> {
    private LLNode<T> head;
    private int size;

    public void add(T data) {
        if (head == null) {
            head = new LLNode(data, null);
            size++;
            return;
        }
        LLNode<T> node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(new LLNode(data, null));
        size++;

        return;
    }

    public T remove() {
        if (head == null) {
            return null;
        }
        LLNode<T> node = head;
        head = head.getNext();

        size--;
        return node.getData();
    }

    public void traverse() {
        LLNode<T> node = head;

        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);

        ll.traverse();
    }
}
