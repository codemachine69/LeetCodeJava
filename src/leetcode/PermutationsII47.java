package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        solve(nums, new ArrayList<>(), map, res);
        return res;

    }

    private void solve(int[] nums, List<Integer> perm, Map<Integer, Integer> map, List<List<Integer>> res) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int x : map.keySet()) {
            if (map.get(x) > 0) {
                int cnt = map.get(x);
                perm.add(x);
                map.put(x, cnt - 1);
                solve(nums, perm, map, res);
                map.put(x, cnt);
                perm.removeLast();
            }

        }
    }
}
