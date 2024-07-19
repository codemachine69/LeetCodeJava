package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder127 {
    private class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList);
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;
            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replaced = word.toCharArray();
                    replaced[i] = ch;
                    String replacedWord = new String(replaced);
                    if (set.contains(replacedWord)) {
                        System.out.println(replacedWord);
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}
