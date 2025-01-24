package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, candidates, target, res, new ArrayList<>());
        return res;
    }

    private void solve(int idx, int[] arr, int target, List<List<Integer>> res, List<Integer> curr) {
        if (idx == arr.length) {
            if (target == 0) res.add(new ArrayList<>(curr));
            return;
        }

        if (arr[idx] <= target) {
            curr.add(arr[idx]);
            solve(idx, arr, target - arr[idx], res, curr);
            curr.removeLast();
        }
        solve(idx + 1, arr, target, res, curr);
    }
}
