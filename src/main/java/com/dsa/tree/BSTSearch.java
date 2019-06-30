package com.dsa.tree;

public class BSTSearch {
    public static Node search(Node rootNode, int data) {
        if (rootNode == null || rootNode.getData() == data) {
            return rootNode;
        }

        if (rootNode.getData() > data) {
            return search(rootNode.getLeft(), data);
        } else {
            return search(rootNode.getRight(), data);
        }
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

         Node node = BSTSearch.search(head, 9);
         if(node == null) {
             System.out.println("Not Found");
         } else {
             System.out.println("Found");
         }
    }
}
