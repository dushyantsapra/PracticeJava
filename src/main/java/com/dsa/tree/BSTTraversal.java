package com.dsa.tree;

public class BSTTraversal {
    public static void preorderTraversal(Node rootNode) {
        if (rootNode == null)
            return;
        if (rootNode != null)
            System.out.println(rootNode.getData());
        preorderTraversal(rootNode.getLeft());
        preorderTraversal(rootNode.getRight());
    }

    public static void postorderTraversal(Node rootNode) {
        if (rootNode == null)
            return;
        postorderTraversal(rootNode.getLeft());
        postorderTraversal(rootNode.getRight());
        if (rootNode != null)
            System.out.println(rootNode.getData());
    }

    public static void inorderTraversal(Node rootNode) {
        if (rootNode == null)
            return;
        inorderTraversal(rootNode.getLeft());
        if (rootNode != null)
            System.out.println(rootNode.getData());
        inorderTraversal(rootNode.getRight());
    }

    public static void levelOrderTraversal(Node rootNode) {
        
    }

    public static void main(String[] args) {
        Node head = null;
        head = BinarySearchTree.insert(8, head);
        head = BinarySearchTree.insert(4, head);
        head = BinarySearchTree.insert(12, head);
        head = BinarySearchTree.insert(2, head);
        head = BinarySearchTree.insert(7, head);
        head = BinarySearchTree.insert(10, head);
        head = BinarySearchTree.insert(18, head);
        head = BinarySearchTree.insert(9, head);
        head = BinarySearchTree.insert(11, head);

        System.out.println("Pre-Order Traversal");
        preorderTraversal(head);

        System.out.println("Post-Order Traversal");
        postorderTraversal(head);

        System.out.println("In-Order Traversal");
        inorderTraversal(head);
    }
}
