package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        solve(nums, new ArrayList<>(), res, used);
        return res;
    }

    private void solve(int[] nums, List<Integer> perm, List<List<Integer>> res, boolean[] used) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm.add(nums[i]);
                solve(nums, perm, res, used);
                perm.removeLast();
                used[i] = false;
            }
        }
    }
}
