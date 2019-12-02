package net.demo.datastructures;

import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String wordContent = "";
    boolean isWord;

    @Override
    public String toString() {
        return children.toString();
    }
}

public class Trie {
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

    TrieNode searchNode(String word) {
        TrieNode result = root;
        for (int i = 0; i < word.length(); i++) {
            if (result.children.containsKey(word.charAt(i))) {
                result = result.children.get(word.charAt(i));
            }
        }
        if (result.isWord && result.wordContent.equals(word)) {
            return result;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("BAT");
        trie.insert("BALL");
        trie.insert("CAP");
        trie.insert("CAT");
        System.out.println(trie.root);

        TrieNode bat = trie.searchNode("BAT");
        System.out.println(bat.wordContent);

        bat = trie.searchNode("CAPi");
        System.out.println(bat != null ? bat.wordContent : "*not found*");
    }
}