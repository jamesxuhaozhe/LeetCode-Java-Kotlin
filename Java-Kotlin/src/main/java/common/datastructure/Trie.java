package common.datastructure;

public class Trie {

    private static class TrieNode {
        private char val;

        private TrieNode[] children;

        private boolean isWord;

        private TrieNode(char c) {
            this.val = c;
            this.children = new TrieNode[26];
            this.isWord = false;
        }

        private TrieNode() {
            this.val = ' ';
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) {
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

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
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

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
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
}
