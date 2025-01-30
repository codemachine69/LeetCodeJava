package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void solve(String s, int start, List<String> curr, List<List<String>> res) {
        if (start >= s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (valid(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                solve(s, end + 1, curr, res);
                curr.removeLast();
            }
        }
    }

    private boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
