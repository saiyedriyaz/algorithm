package net.demo;
// https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/
public class GFG {
    public static int shortestPalindrome(String s) {
        // Write your code here
        if (s != null && !s.trim().isEmpty()) {
            return minInsertions(s.trim().toCharArray(), s.length());
        } else {
            return 0;
        }
    }

    static int minInsertions(char str[], int n) {
        int table[][] = new int[n][n];
        int l, h, gap;

        // Fill the table
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (str[l] == str[h]) ?
                        table[l + 1][h - 1] :
                        (Integer.min(table[l][h - 1],
                                table[l + 1][h]) + 1);

        return table[0][n - 1];
    }


    // Driver program to test above functions
    public static void main(String args[]) {
        System.err.println(shortestPalindrome("abb"));
    }
}
