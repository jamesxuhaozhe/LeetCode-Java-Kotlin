package dfs;

import java.util.*;

public class _212 {
    private Set<String> foundWords = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return Collections.emptyList();
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                dfs(row, col, visited, board, trie, "");
            }
        }

        return new ArrayList<>(foundWords);
    }

    private void dfs(int row, int col, boolean[][] visited, char[][] board, Trie trie, String str) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        str += board[row][col];
        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            foundWords.add(str);
        }

        visited[row][col] = true;

        dfs(row - 1, col, visited, board, trie, str);
        dfs(row + 1, col, visited, board, trie, str);
        dfs(row, col - 1, visited, board, trie, str);
        dfs(row, col + 1, visited, board, trie, str);

        visited[row][col] = false;
    }

    private static class Trie {
        static class TrieNode {
            private char val;
            private TrieNode[] children;
            private boolean isWord;

            TrieNode() {
                this.val = ' ';
                this.children = new TrieNode[26];
                this.isWord = false;
            }

            TrieNode(char c) {
                this.val = c;
                this.children = new TrieNode[26];
                this.isWord = false;
            }
        }

        private TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void insert(String word) {
            if (!isValidInput(word)) {
                return;
            }

            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode(c);
                }
                node = node.children[index];
            }
            node.isWord = true;
        }

        boolean startsWith(String prefix) {
            if (!isValidInput(prefix)) {
                return false;
            }

            TrieNode node = root;
            char[] chars = prefix.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }

        boolean search(String word) {
            if (!isValidInput(word)) {
                return false;
            }

            TrieNode node = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.isWord;
        }

        boolean isValidInput(String str) {
            if (str == null || str.length() == 0) {
                return false;
            }
            return true;
        }
    }
}
