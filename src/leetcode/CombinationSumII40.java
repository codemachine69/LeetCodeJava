package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void solve(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (start >= candidates.length) return;

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] <= target) {
                curr.add(candidates[i]);
                solve(candidates, target - candidates[i], i + 1, curr, res);
                curr.removeLast();
            }
        }
    }
}
