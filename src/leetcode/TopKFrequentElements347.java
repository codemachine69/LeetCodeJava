package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int n : nums) hm.put(n, hm.getOrDefault(n, 0) + 1);
        ArrayList<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) freq[i] = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) freq[e.getValue()].add(e.getKey());
        int[] res = new int[k];
        int idx = 0;
        for (int i = nums.length; i >= 0; i--) {
            for (Integer n : freq[i]) {
                res[idx++] = n;
                if (idx == k) return res;
            }
        }
        return res;
    }
}
