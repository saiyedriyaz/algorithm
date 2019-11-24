package net.demo.algorithms.sierra;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInserts {

    static class Node<T extends Comparable<?>> {
        T data;
        // Node above;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    private static Node root;
    private static int counter = 0;

    /*
     * Complete the 'createBST' function below.
     *
     * The function accepts INTEGER_ARRAY keys as parameter.
     */
    public static void createBST(List<Integer> keys) {
        // Write your code here
        if (keys != null && !keys.isEmpty()) {
            for (Integer key : keys) {
                add(key);
            }
        }
    }

    private static void add(Integer value) {
        root = addNode(root, value);
    }

    private static Node addNode(Node current, Integer value) {
        if (current == null) {
            System.out.println(counter);
            current = new Node(value);
            counter++;
        } else if (current.data.compareTo(value) > 0) {
            current.left = addNode(current.left, value);
            counter++;
        } else if (current.data.compareTo(value) < 0) {
            current.right = addNode(current.right, value);
            counter++;
        }
        return current;
    }

    private static Node getNode(Node current, Integer value) {
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

    private static Comparable findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    public static void main(String[] args) {
        List<Integer> bt = new ArrayList<>();
        bt.add(3);
        bt.add(2);
        bt.add(1);
        bt.add(3);
        createBST(bt);
    }
}
