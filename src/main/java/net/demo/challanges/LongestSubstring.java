package net.demo.challanges;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    public static void main(String[] args) {
        String test = "geeksforgeeks";
        List<String> list = new ArrayList<>();
        for (int i = 0; i < test.length() - 1; i++) {
            StringBuilder b = new StringBuilder();
            for (int j = 0; j < test.length() - 1; j++) {
                if (j < test.length() && test.charAt(j) == test.charAt(j + 1)) {
                    break;
                } else {
                    b.append(test.substring(i, j - 1));
                }
            }
            list.add(b.toString());
        }
        System.out.println(list);
    }
}
