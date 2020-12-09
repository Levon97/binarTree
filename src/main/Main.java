package main;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(10);
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(2);
        tree.add(8);
        tree.add(23);
        tree.add(1);
        tree.add(13);
        System.out.println(tree.contains(1));
        System.out.println(tree.contains(23));
        System.out.println(tree.contains(56));
        System.out.println(tree.max());
        System.out.println(tree.min());
        tree.traverseInOrder(tree.head);
        tree.traversePostOrder(tree.head);
        tree.traversePreOrder(tree.head);



    }

}
