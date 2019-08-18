package net.demo.algorithms.bstree;

public class BinaryTree {
    private Node root;

    public void add(Integer value) {
        root = addNode(root, value);
    }

    private Node addNode(Node current, Integer value) {
        if (current == null) {
            current = new Node(value);
        } else if (current.getData().compareTo(value) > 0) {
            current.left = addNode(current.getLeft(), value);
        } else if (current.getData().compareTo(value) < 0) {
            current.right = addNode(current.getRight(), value);
        }
        return current;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(-11);
        bt.add(11);

        BTreePrinter.printNode(bt.root);
    }
}
