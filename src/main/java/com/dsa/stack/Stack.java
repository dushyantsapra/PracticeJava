package com.dsa.stack;

import com.dsa.linkedList.LLNode;

public class Stack {
    private LLNode head;

    public void push(int data) {
        head = new LLNode(data, head);
    }

    public LLNode pop() {
        LLNode node = head;
        head = head.getNext();
        return node;
    }

    public LLNode peek() {
        return head;
    }

    public boolean isEmpty() {
        return head == null ? true : false;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
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
