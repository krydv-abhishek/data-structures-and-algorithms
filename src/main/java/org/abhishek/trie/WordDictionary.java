package org.abhishek.trie;

public class WordDictionary {

    TrieNode root;

    static class TrieNode {
        TrieNode[] children;
        boolean isLeaf;

        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isLeaf = true;

    }

    public boolean search(String word) {
        return searchUtil(word, root);
    }

    public boolean searchUtil(String word, TrieNode curr) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean isFound = false;
                for (int j = 0; j < 26; j++) {
                    if (curr.children[j] != null) {
                        isFound = searchUtil(word.substring(i + 1), curr.children[j]);
                    }
                    if (isFound) {
                        return true;
                    }
                }
                return false;
            }
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isLeaf;
    }

    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        String[] arr = {"at","and","an","add"};
        for (String s : arr) {
            dictionary.addWord(s);
        }
        String[] searchKeys = {"a",".at"};
        for (String s : searchKeys) {
            if (dictionary.search(searchKeys[0]))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
    }
}
