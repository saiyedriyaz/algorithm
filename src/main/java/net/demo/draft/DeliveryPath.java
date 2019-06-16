package net.demo.draft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeliveryPath {

    public static void main(String[] args) {

        List<Integer> line1 = Arrays.asList(new Integer[]{1, 0, 0});
        List<Integer> line2 = Arrays.asList(new Integer[]{1, 0, 0});
        List<Integer> line3 = Arrays.asList(new Integer[]{1, 9, 1});

        List<List<Integer>> area = new ArrayList<List<Integer>>();
        area.add(line1);
        area.add(line2);
        area.add(line3);

        //System.err.println(new net.other.DeliveryPath().minimumDistance(3, 3, area));
    }

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
        // WRITE YOUR CODE HERE

        int path = 0;
        for (int i = 0; i < numRows; i++) {

            List<Integer> row = area.get(i);

            for (int j = 0; j < numColumns; j++) {

                if (row.get(j) == 0 || row.get(j) == 9) {
                    break;
                } else {
                    path++;
                }
                System.err.print(row.get(j));
            }

            System.err.println("");
        }
        return path;
    }
}
