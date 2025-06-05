package org.abhishek.trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    static class TrieNode {

        TrieNode[] children;
        boolean isLeaf;

        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        TrieNode root = new TrieNode();
        for (String word : words) {
            addWord(word, root);
        }

        List<String> answer = new ArrayList<>();

        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                dfsUtil(board, root, visited, answer, "", i, j);
            }
        }
        return answer;

    }

    public static void dfsUtil(char[][] board, TrieNode root, boolean[][] visited, List<String> answer
            ,String currWord, int r, int c) {

        if(r<0 || c<0 || r>=board.length || c >=board[0].length || visited[r][c] || root.children[board[r][c]-'a']==null) {
            return;
        }

        root = root.children[board[r][c]-'a'];
        if(root.isLeaf) {
            root.isLeaf=false;
            answer.add(currWord+ board[r][c]);
        }

        visited[r][c]=true;

        dfsUtil(board, root, visited, answer, currWord + board[r][c], r+1, c);
        dfsUtil(board, root, visited, answer, currWord + board[r][c], r-1, c);
        dfsUtil(board, root, visited, answer, currWord + board[r][c], r, c+1);
        dfsUtil(board, root, visited, answer, currWord + board[r][c], r, c-1);

        visited[r][c]=false;
    }

    public static void addWord(String word, TrieNode root) {

        TrieNode curr = root;
        for (char c : word.toCharArray()) {

            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isLeaf = true;
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };
//        String[] words = {"oath", "pea", "eat", "rain","eii"};

        char[][] board = {
                {'o','a','b','n'},
                {'o','t','a','e'},
                {'a','h','k','r'},
                {'a','f','l','v'}
        };

        String[] words = {"oa", "oaa"};
        System.out.println(findWords(board, words));

    }
}
