package trie;

public class _208 {

    static class Trie {

        static class TrieNode {
            private char val;

            private TrieNode[] children;

            private boolean isWord;

            private TrieNode() {
                this.val = ' ';
                this.children = new TrieNode[26];
                this.isWord = false;
            }

            private TrieNode(char c) {
                this.val = c;
                this.children = new TrieNode[26];
                this.isWord = false;
            }
        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode(c);
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            if (!isValid(word)) {
                return false;
            }

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if (!isValid(prefix)) {
                return false;
            }


            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;
        }

        private boolean isValid(String str) {
            if (str == null || str.length() == 0) {
                return false;
            }
            return true;
        }
    }
}
