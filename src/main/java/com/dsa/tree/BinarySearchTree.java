package com.dsa.tree;

import com.dsa.linkedList.LinkedList;

public class BinarySearchTree {
    public static Node insert(int data, Node rootNode) {
        if (rootNode == null) {
            return new Node(data, null, null);
        }
        if (rootNode.getData() >= data) {
            rootNode.setLeft(insert(data, rootNode.getLeft()));
        } else {
            rootNode.setRight(insert(data, rootNode.getRight()));
        }
        return rootNode;
    }

    public static void printLevel(LinkedList<Node> ll, int level) {
        int size = ll.size();

        if (ll.size() == 0) {
            return;
        }

        while (size > 0) {
            Node node = ll.remove();
            System.out.println("Data : " + node.getData() + ", Level : " + level);
            if (node.getLeft() != null) {
                ll.add(node.getLeft());
            }
            if (node.getRight() != null) {
                ll.add(node.getRight());
            }
            size--;
        }
        printLevel(ll, ++level);
    }

    public static void printLevelofNode(LinkedList<Node> ll, int level, int data) {
        int size = ll.size();

        if (ll.size() == 0) {
            return;
        }

        while (size > 0) {
            Node node = ll.remove();
            if (node.getData() == data) {
                System.out.println("Data : " + node.getData() + ", Level : " + level);
                return;
            }
            if (node.getLeft() != null) {
                ll.add(node.getLeft());
            }
            if (node.getRight() != null) {
                ll.add(node.getRight());
            }
            size--;
        }
        printLevelofNode(ll, ++level, data);
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

        LinkedList<Node> ll = new LinkedList<>();
        ll.add(head);

        printLevel(ll, 0);

        System.out.println();
        ll.add(head);
        printLevelofNode(ll, 0, 11);
    }
}
