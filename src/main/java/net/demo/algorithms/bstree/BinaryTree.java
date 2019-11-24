package net.demo.algorithms.bstree;

public class BinaryTree {
    private Node root;

    public void add(Integer value) {
        root = addNode(root, value);
    }

    public Node get(Integer value) {
        return getNode(root, value);
    }

    public Node delete(Integer value) {
        return deleteNode(root, value);
    }

    private Node addNode(Node current, Integer value) {
        if (current == null) {
            current = new Node(value);
        } else if (current.getData().compareTo(value) > 0) {
            current.left = addNode(current.getLeft(), value);
            //current.left.above = current;
        } else if (current.getData().compareTo(value) < 0) {
            current.right = addNode(current.getRight(), value);
            //current.right.above = current;
        }
        return current;
    }

    private Node getNode(Node current, Integer value) {
        Node found = null;
        if (current != null) {

            if (current.data.compareTo(value) == 0) {
                found = current;
            } else if (current.data.compareTo(value) < 0) {
                found = getNode(current.right, value);
            } else {
                found = getNode(current.left, value);
            }
        }
        return found;
    }

    private Node deleteNode(Node current, Comparable value) {
        if (current == null) {
            return null;
        } else if (current.data.compareTo(value) < 0) {
            current.right = deleteNode(current.right, value);
        } else if (current.data.compareTo(value) > 0) {
            current.left = deleteNode(current.left, value);
        } else {
            //a node has no children – this is the simplest case; we just need to replace this node with null in its parent node
            if (current.left == null && current.right == null) {
                return null;
            }

            // a node has exactly one child – in the parent node, we replace this node with its only child.
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            // a node has two children – this is the most complex case because it requires a tree reorganization
            Comparable smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteNode(current.right, smallestValue);
            return current;
        }
        return current;
    }

    private Comparable findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
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

        //System.err.println(bt.get(-11));

        System.err.println(bt.delete(6));

        BTreePrinter.printNode(bt.root);
    }
}
