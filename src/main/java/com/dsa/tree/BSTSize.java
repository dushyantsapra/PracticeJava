package com.dsa.tree;

public class BSTSize {

    //Using Post-Order Traversal
    public static int size(Node node, int size) {
        if (node == null) {
            return size;
        }
        int lsize = size(node.getLeft(), size);
        int rsize = size(node.getRight(), size);

        return lsize + rsize + 1;
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

        System.out.println("Size " + size(head, 0));
    }
}
