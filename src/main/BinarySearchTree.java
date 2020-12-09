package main;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public Node head;

    public void add(Integer value) {
        head = addRecursion(head, value);
    }

    private Node addRecursion(Node current, Integer value) {
        if (current == null) {
            return new Node(value);
        }
        if (value > current.value) {
            current.right = addRecursion(current.right, value);
        }
        if (value < current.value) {
            current.left = addRecursion(current.left, value);
        }
        return current;

    }

    public boolean contains(Integer i) {
        return find(head, i) != null;
    }

    private Node find(Node head, Integer val) {
        if (head == null) {
            return null;
        }
        if (head.value.equals(val)) {
            return head;
        }
        if (head.value < val) {
            return find(head.right, val);
        }

        return find(head.left, val);

    }

    public Integer max() {
        Node current = head;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public Integer min() {
        Node current = head;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null){
                return null;
            }if(current.right == null){
                return current.left;
            }
            if(current.left == null){
                return current.right;
            }
            Integer smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    private Integer findSmallestValue(Node root){
        return root.left == null ? root.value: findSmallestValue(root.left);
    }
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }
    public void traverseLevelOrder() {
        if (head == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(head);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }



}
