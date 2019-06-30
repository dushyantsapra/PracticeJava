package com.dsa.stack;

public class Stack<T> {
    private StackNode<T> head;

    public void push(T data) {
        head = new StackNode<>(data, head);
    }

    public StackNode<T> pop() {
        StackNode<T> node = head;
        head = head.getNext();
        return node;
    }

    public StackNode<T> peek() {
        return head;
    }

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek().getData());

        System.out.println();

        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());
    }
}
