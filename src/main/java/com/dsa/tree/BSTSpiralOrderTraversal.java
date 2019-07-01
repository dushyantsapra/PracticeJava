package com.dsa.tree;

import com.dsa.stack.Stack;

public class BSTSpiralOrderTraversal {
    public static void spiralOrderTraversal(Stack<Node> stack, boolean isLeft) {
        if (stack.isEmpty()) {
            return;
        }
        Stack<Node> tempStack = new Stack<>();
        if (isLeft) {
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.println(node.getData());
                if (node.getLeft() != null)
                    tempStack.push(node.getLeft());
                if (node.getRight() != null)
                    tempStack.push(node.getRight());
            }
            spiralOrderTraversal(tempStack, false);
        } else {
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                System.out.println(node.getData());
                if (node.getRight() != null)
                    tempStack.push(node.getRight());
                if (node.getLeft() != null)
                    tempStack.push(node.getLeft());
            }
            spiralOrderTraversal(tempStack, true);
        }
    }

    public static void main(String[] args) {
        Node head = null;
        head = BinarySearchTree.insert(8, head);
        head = BinarySearchTree.insert(6, head);
        head = BinarySearchTree.insert(12, head);
        head = BinarySearchTree.insert(4, head);
        head = BinarySearchTree.insert(7, head);
        head = BinarySearchTree.insert(10, head);
        head = BinarySearchTree.insert(18, head);
        head = BinarySearchTree.insert(2, head);
        head = BinarySearchTree.insert(5, head);
        head = BinarySearchTree.insert(9, head);
        head = BinarySearchTree.insert(11, head);
        head = BinarySearchTree.insert(1, head);
        head = BinarySearchTree.insert(3, head);

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        spiralOrderTraversal(stack, false);
    }
}
