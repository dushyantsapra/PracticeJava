package com.dsa.tree;

public class LowestCommonAncestor {
    public static Node getAncestor(Node ancestor, Node node, int data) {
        if (data > node.getData() && node.getRight() != null) {
            ancestor = node;
            node = node.getRight();
            return getAncestor(ancestor, node, data);
        } else if (data < node.getData() && node.getLeft() != null) {
            ancestor = node;
            node = node.getLeft();
            return getAncestor(ancestor, node, data);
        }

        if (data == node.getData()) {
            return ancestor;
        }
        return null;
    }

    /*Case 1 : d1 and d2 is in left sub-tree
    Case 2 : d1 and d2 is in right sub-tree
    Case 3 : d1 and d2 is in left and right sub-tree, for this retrn curent Node, Traverse till this condition hits*/
    public static Node lowestCommonAncestor(Node node, int d1, int d2) {
        if (node.getData() > d1 && node.getData() > d2) {
            return lowestCommonAncestor(node.getLeft(), d1, d2);
        } else if (node.getData() < d1 && node.getData() < d2) {
            return lowestCommonAncestor(node.getRight(), d1, d2);
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = null;
        head = BinarySearchTree.insert(8, head);
        head = BinarySearchTree.insert(4, head);
        head = BinarySearchTree.insert(15, head);
        head = BinarySearchTree.insert(1, head);
        head = BinarySearchTree.insert(5, head);
        head = BinarySearchTree.insert(10, head);
        head = BinarySearchTree.insert(20, head);
        head = BinarySearchTree.insert(13, head);
        head = BinarySearchTree.insert(18, head);
        head = BinarySearchTree.insert(22, head);

        Node node = getAncestor(head, head, 22);

        if (node != null) {
            System.out.println("Ancestor : " + node.getData());
        }

        System.out.println("Lowest Common Ancestor : " + lowestCommonAncestor(head, 10, 13).getData());
    }
}
