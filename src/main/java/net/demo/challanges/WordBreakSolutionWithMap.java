package net.demo.challanges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Can you break the given string into words, provided by a given hashmap of frequency of word as <word: n>
 * <p>
 * Example 1:
 * <p>
 * HashMap -> {"abc":3, "ab":2, "abca":1}
 * String: "abcabcabcabca"
 * Output: true
 * Explanation: "abc" + "abc" + "abc" + "abca"
 * Example 2:
 * <p>
 * HashMap -> {"abc":3, "ab":2}
 * String: "abcabab"
 * Output: true
 * Explanation: "abc" + "ab" + "ab"
 * Example 3:
 * <p>
 * HashMap -> {"abc":3, "ab":2, "abca":1}
 * String: "abcx"
 * Output: false
 */
public class WordBreakSolutionWithMap {

    private static Map<String, Integer> wordList = null;

    /**
     * arg[0] = comma sepearated word list for dictionary e.g. what,an,nice,day
     * arg[1] = word to be searched against dictionary e.g. whataniceday
     *
     * @param args
     */
    public static void main(String[] args) {
        String searchString = "";
        if (args != null && args.length == 2) {
            wordList = null;//new HashSet<>(Arrays.asList(args[0].split(",")));
            searchString = args[1];
        }
        // run with sample/default test case
        else {
            wordList = getTestMap();
            searchString = "abca";
        }

        boolean found = wordBreak(searchString, wordList);
        System.out.println("found all=" + found);
    }

    private static Map<String, Integer> getTestMap() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("abc", 3); //2
        testMap.put("ab", 2);  // 1
        testMap.put("abca", 1); // 0

        return testMap;
    }

    private static boolean wordBreak(String word, Map<String, Integer> wordList) {
        Trie trie = new Trie();
        wordList.keySet().forEach(trie::insert);
        //System.out.println(trie.root);
        //System.out.println("found=" + trie.searchNode("abcabc"));

        System.out.println("search=" + word);

        List<String> subSet = allSubsets(word);
        for (String subsetToken : subSet) {
            if (wordList.containsKey(subsetToken)) {
                wordList.put(subsetToken, wordList.get(subsetToken) - 1);
            }
        }

        return wordBreak2(word, wordList, trie);
    }

    private static boolean wordBreak2(String word, Map<String, Integer> wordList, Trie trie) {
        //(a) If you ran out of characters in string, return true
        if (word.length() == 0) {
            return true;
        }
        //(b) If you did not find the string (as a word) in the Trie, or if the Map has a zero count for the word, return false
        else if (!trie.searchNode(word) || (wordList.containsKey(word) && wordList.get(word) == 0)) {
            return false;
        }
        int foundCount = 0;
        int foundLength = 0;
        System.out.println("B wordList=" + wordList);

        boolean found = false;
        for (int i = 1; i <= word.length(); i++) {
            Integer count = wordList.get(word);
            if (trie.searchNode(word.substring(0, i)) && count != null && count >= 0) {
                wordList.put(word, count - 1);
                found = wordBreak2(word.substring(i), wordList, trie);
            }
        }
        return found;
    }

    static List<String> allSubsets(String str) {
        List<String> subSets = new ArrayList<>();

        int len = str.length();
        int temp = 0;
        //Total possible subsets for string of size n is n*(n+1)/2
        String arr[] = new String[len * (len + 1) / 2];

        //This loop maintains the starting character
        for (int i = 0; i < len; i++) {
            //This loop adds the next character every iteration for the subset to form and add it to the array
            for (int j = i; j < len; j++) {
                arr[temp] = str.substring(i, j + 1);
                temp++;
            }
        }

        //This loop prints all the subsets formed from the string.
        System.out.println("All subsets for given string are: ");
        for (int i = 0; i < arr.length; i++) {
            subSets.add(arr[i]);
        }
        return subSets;
    }

}

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String wordContent = "";
    boolean isWord;


    @Override
    public String toString() {
        return children.toString();
    }
}

class Trie {
    TrieNode root = new TrieNode();

    void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode();
                children.put(c, t);
            }
            t.wordContent = word.substring(0, i + 1);
            children = t.children;
            //set leaf node
            if (i == word.length() - 1) {
                t.isWord = true;
            }
        }
    }

    boolean searchNode(String word) {
        TrieNode result = root;
        for (int i = 0; i < word.length(); i++) {
            if (result.children.containsKey(word.charAt(i))) {
                result = result.children.get(word.charAt(i));
            }
        }
        return result.wordContent.equals(word) && result.isWord;
    }
}