package leetcode;

public class MergeStringAlternatively1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int m = word1.length(), n = word2.length();
        int i = 0;

        while (i < m || i < n) {
            if (i < m) result.append(word1.charAt(i));
            if (i < n) result.append(word2.charAt(i));
            i++;
        }

        return result.toString();
    }
}
