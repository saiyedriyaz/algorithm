package net.demo.challanges;

import scala.Int;

import java.util.Arrays;
import java.util.Collections;

public class TriangleOrNot {
    public static void main(String[] args) {
        Integer[] perimeters = new Integer[] {3,7,10,7,3,2,3,4,3,2,7,4};
        //Sort array descending
        Arrays.sort(perimeters, Collections.reverseOrder());

        //Check if adjacent triplets are degenerate
        for (int i = 0; i < perimeters.length - 2; i++) {
            if (!degenerateTriangle(perimeters[i], perimeters[i + 1], perimeters[i + 2])) {
                System.out.println(perimeters[i + 2] + " " + perimeters[i + 1] + " " + perimeters[i]);
                System.exit(0);
            }
        }

        //All triangles were degenerative
        System.out.println(-1);
    }

    static boolean degenerateTriangle(int a, int b, int c) {

        if (a + b <= c) return true;
        if (a + c <= b) return true;
        if (b + c <= a) return true;
        return false;
    }
}
