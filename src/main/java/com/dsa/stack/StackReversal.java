package com.dsa.stack;

import com.dsa.linkedList.LLNode;

public class StackReversal {
    public static Stack reverseStack(Stack s) {
        Stack stack = new Stack();
        while (!s.isEmpty()) {
            stack.push(s.pop().getData());
        }
        return stack;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack = reverseStack(stack);

        System.out.println(stack.peek().getData());

        System.out.println();

        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());
        System.out.println(stack.pop().getData());
    }
}
