package com.dsa.tree;

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
}
