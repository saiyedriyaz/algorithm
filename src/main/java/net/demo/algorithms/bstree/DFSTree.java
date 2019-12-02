package net.demo.algorithms.bstree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DFSTree {
    public static void main(String[] args) {
        Node<Integer> FOUR = new Node<>(4);
        Node<Integer> SEVEN = new Node<>(7);
        Node<Integer> NINE = new Node<>(9);

        FOUR.left = SEVEN;
        FOUR.right = NINE;

        Node<Integer> TEN = new Node<>(10);
        Node<Integer> TWO_1 = new Node<>(2);
        Node<Integer> SIX_1 = new Node<>(6);
        SEVEN.left = TEN;
        SEVEN.right = TWO_1;

        NINE.right = SIX_1;


        Node<Integer> SIX_2 = new Node<>(6);
        TWO_1.right = SIX_2;

        Node<Integer> TWO_2 = new Node<>(2);
        SIX_2.left = TWO_2;

        BTreePrinter.printNode(FOUR);

        Collection<Double> avg = calculageAverage(FOUR);
        System.out.println(avg);
    }

    public static Collection<Double> calculageAverage(Node<Integer> root) {
        Map<Integer, List<Integer>> treeMap = new HashMap<>();
        Map<Integer, Double> averageMap = new HashMap<>();
        populateValues(root, treeMap, 0);
        for (Map.Entry<Integer, List<Integer>> entry : treeMap.entrySet()) {
            Double average = entry.getValue().stream().collect(Collectors.averagingInt(num -> num));
            averageMap.put(entry.getKey(), average);
        }
        return averageMap.values();
    }

    private static void populateValues(Node<Integer> node, Map<Integer, List<Integer>> levelList, Integer level) {
        if (node == null) {
            return;
        }

        if (!levelList.containsKey(level)) {
            levelList.put(level, new ArrayList<>());
        }

        levelList.get(level).add(node.data);

        populateValues(node.left, levelList, level + 1);
        populateValues(node.right, levelList, level + 1);
    }
}
