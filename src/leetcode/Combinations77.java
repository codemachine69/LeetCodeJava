package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        solve(1, new ArrayList<>(), res, n, k);
        return res;
    }

    private void solve(int idx, List<Integer> curr, List<List<Integer>> res, int n, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i <= n; i++) {
            curr.add(i);
            solve(i + 1, curr, res, n, k);
            curr.removeLast();
        }
    }
}
