package leetcode;

public class DesignAddandSearchWordsDataStructure211 {
    TrieNode root;

    private class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public DesignAddandSearchWordsDataStructure211() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.children[idx] == null)
                cur.children[idx] = new TrieNode();
            cur = cur.children[idx];
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        return find(word, root, 0);
    }

    private boolean find(String word, TrieNode node, int idx) {
        if (node == null) return false;
        if (idx == word.length()) return node.isWord;

        if (word.charAt(idx) == '.') {
            for (TrieNode child : node.children) {
                if (find(word, child, idx + 1)) {
                    return true;
                }
            }
        } else {
            int temp = word.charAt(idx) - 'a';
            TrieNode child = node.children[temp];
            return find(word, child, idx + 1);
        }

        return false;
    }
}
