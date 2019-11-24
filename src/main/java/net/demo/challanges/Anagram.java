package net.demo.challanges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        Anagram a = new Anagram();
        System.err.println(a.isAnagram("elonmusk", "uskmelon"));
        System.err.println(a.isAnagram("anagram", "nagaram"));

    }


    public boolean isAnagram(String s, String t) {
        //return solutionOne(s, t);
        return solutionTwo(s, t);
    }

    private boolean solutionTwo(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    private boolean solutionOne(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = 0;
            if (charCountMap.containsKey(c)) {
                count = charCountMap.get(c);
            }
            count++;
            charCountMap.put(c, count);
        }

        for (char c : t.toCharArray()) {
            if (charCountMap.containsKey(c)) {
                int count = charCountMap.get(c);
                count--;
                charCountMap.put(c, count);
            }
        }

        for (java.util.Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
