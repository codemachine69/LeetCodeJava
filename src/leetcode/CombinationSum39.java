package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void solve(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (start >= candidates.length) return;

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                curr.add(candidates[i]);
                solve(candidates, target - candidates[i], i, curr, res);
                curr.removeLast();
            }
        }
    }
}
