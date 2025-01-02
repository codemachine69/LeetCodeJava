package leetcode;

public class CountVowelStringsInRanges2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] arr = new int[n];
        int[] res = new int[queries.length];

        for (int i = 0; i < n; i++) {
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                arr[i] = 1;
            }
            if (i > 0) arr[i] += arr[i - 1];
        }
        int idx = 0;
        for (int[] query : queries) {
            if (query[0] > 0) res[idx] = arr[query[1]] - arr[query[0] - 1];
            else res[idx] = arr[query[1]];
            idx++;
        }
        return res;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
