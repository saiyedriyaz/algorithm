package net.demo.challanges;

public class AlternatingCharacters {
    public static void main(String[] args) {
        //System.out.println(alternatingCharacters("ABABABAB")); // expected 0
        System.out.println(alternatingCharacters("AAABBBAABB")); // expected 6
    }

    static int alternatingCharacters(String s) {
        int count = 0;
        if (s != null && !s.isEmpty()) {
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                    //s = s.replace(s.charAt(i), ' ');
                    count++;
                }
            }
        }
        return count;
    }
}
