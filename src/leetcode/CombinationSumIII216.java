package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        solve(new ArrayList<>(), 1, 0, res, k, n);
        return res;
    }

    private void solve(List<Integer> curr, int start, int currSum, List<List<Integer>> res, int k, int n) {
        if (curr.size() >= k) {
            if (currSum == n) res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= 9; i++) {
            curr.add(i);
            solve(curr, i + 1, currSum + i, res, k, n);
            curr.removeLast();
        }
    }
}
