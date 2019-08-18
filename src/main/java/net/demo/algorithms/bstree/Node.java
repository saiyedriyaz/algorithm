package net.demo.algorithms.bstree;

import lombok.Getter;

@Getter
public class Node<T extends Comparable<?>> {
    T data;
    Node left;
    Node right;

    Node(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}
