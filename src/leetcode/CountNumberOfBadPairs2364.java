package leetcode;

import java.util.HashMap;

public class CountNumberOfBadPairs2364 {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        long res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int cnt = hm.getOrDefault(nums[i] - i, 0);
            res += cnt;
            hm.put(nums[i] - i, cnt + 1);
        }
        return (n) * (n - 1) / 2 - res;
    }
}
