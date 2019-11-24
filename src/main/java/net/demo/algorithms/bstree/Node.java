package net.demo.algorithms.bstree;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Node<T extends Comparable<?>> {
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
