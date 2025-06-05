package org.abhishek.trie;



public class TrieDS {
    static class TrieNode {
        TrieNode[] children;
        boolean isLeaf;

        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }
    }

    TrieNode root;

    public TrieDS() {
     root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;

        for(char c: word.toCharArray()) {
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isLeaf=true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(char c: word.toCharArray()) {
            if(curr.children[c-'a']==null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.isLeaf;
    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;

        for(char c: prefix.toCharArray()) {
            if(curr.children[c-'a']==null) {
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
    public static void main(String[] args)
    {
        TrieDS trie = new TrieDS();
        String[] arr = {"and", "ant", "do", "dad"};
        for (String s : arr) {
            trie.insert(s);
        }
        String[] searchKeys = { "do", "gee", "bat" };
        for (String s : searchKeys) {
            if (trie.search(s))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
        System.out.println();
        String[] prefixKeys = { "ge", "ba", "do", "de" };
        for (String s : prefixKeys) {
            if (trie.startsWith(s))
                System.out.print("true ");
            else
                System.out.print("false ");
        }
    }
}
