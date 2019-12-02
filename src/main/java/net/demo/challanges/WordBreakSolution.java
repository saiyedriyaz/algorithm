package net.demo.challanges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * # # # # # # # # /TASK 1. Given a non-empty string s and a list wordList containing a list of non-empty tokens, determine if s can be represented as a
 * concatenation of tokens from the list (where each token may be used several times). You may assume the dictionary does not contain duplicate tokens.
 * # # # # # # #
 * # # # # #
 * # # # # #
 * # # # # #
 * # # # # # # # #
 * # # # # # # # # s = "whataniceday";
 * # # # # # # # # wordList = ["a", "what", "an", "nice", "day"];
 * # # # # # # # # -> true
 * # # # # # # # #
 * # # # # # # # # s = "dawhaty",
 * # # # # # # # # wordList = ["a", "what", "an", "nice", "day"].
 * # # # # # # # # -> false
 * # # # # # # # #
 * # # # # # # # # s = "abc",
 * # # # # # # # # wordList = ["a", "ab", "bc"].
 * # # # # # # # # -> true
 */
public class WordBreakSolution {

    private static Set<String> wordList = null;

    /**
     * arg[0] = comma sepearated word list for dictionary e.g. what,an,nice,day
     * arg[1] = word to be searched against dictionary e.g. whataniceday
     *
     * @param args
     */
    public static void main(String[] args) {
        String searchString = null;
        boolean found = false;
        if (args != null && args.length == 2) {
            wordList = new HashSet<>(Arrays.asList(args[0].split(",")));
            searchString = args[1];
        }
        // run with sample/default test case
        else {
            wordList = new HashSet<>(Arrays.asList("what,an,nice,day".split(",")));
            searchString = "dawhaty";
            found = wordBreak2(searchString);
            System.out.println("found all=" + found);

            wordList = new HashSet<>(Arrays.asList("a,ab,bc".split(",")));
            searchString = "abc";
            found = wordBreak2(searchString);
            System.out.println("found all=" + found);
        }

    }

    /**
     * Returns true if the word can be represented as token that each token is part of dictionary
     *
     * @param word
     * @return
     */
    private static boolean wordBreak(String word) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 1; i <= word.length(); i++) {
            if (wordList.contains(word.substring(0, i)) && wordBreak(word.substring(i))) {
                return true;
            }
        }

        return false;
    }

    private static boolean wordBreak2(String word) {
        if (word.length() == 0) {
            return true;
        }
        int foundCount = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j <= word.length(); j++) {
                String newWord = word.substring(i, j);
                if (wordList.contains(newWord)) {
                    foundCount++;
                }
            }
        }
        return wordList.size() == foundCount;
    }

    /*private static String doSomething(String word) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j <= word.length(); j++) {
                String newWord = word.substring(i, j);
                if (wordList.contains(newWord)) {
                    return word.replace(newWord, "");
                }
            }
        }
        return word;
    }*/
}
