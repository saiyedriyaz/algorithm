package net.demo.draft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

/**
 *
 */
public class StringTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "1-5, 8, 11-14, 18, 20, 26-29";
        List<String> flightList = expandRange(s);
        System.err.println(flightList);
        System.err.println(flightList.size());

    }

    public static List<String> expandRange(String s) {
        List<String> flightList = new ArrayList<>();
        if (s != null && !s.isEmpty()) {
            s = s.replace(" ", "");
            String p = s;
            String[] arr = p.split("\\-");
            String k = "";
            for (int i = 0; i < arr.length; i++) {
                if (i != arr.length - 1) {
                    String[] arr1 = arr[i].split(",");
                    String[] arr2 = arr[i + 1].split(",");
                    int a = Integer.parseInt(arr1[arr1.length - 1]);
                    int b = Integer.parseInt(arr2[0]);
                    for (int j = a + 1; j < b; j++) {
                        arr[i] = arr[i] + "," + j;
                    }
                }
                if (k != "") {
                    k = k + "," + arr[i];
                } else {
                    k = k + arr[i];
                }
            }

            if (k != null) {
                String[] allNums = k.split(",");
                flightList.addAll(Arrays.asList(allNums));
            }
        }
        return flightList;
    }
}
