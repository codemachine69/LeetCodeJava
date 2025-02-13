package leetcode;

import java.util.PriorityQueue;

public class MiniOperationsToExceedThresholdValueII3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int cnt = 0, ops = 0;
        for (int num : nums) {
            if (num < k) cnt++;
            pq.add((long) num);
        }

        while (cnt > 0 || pq.size() <= 0) {
            long a = pq.poll();
            long b = pq.poll();
            if (a < k) cnt--;
            if (b < k) cnt--;
            long res = Math.min(a, b) * 2 + Math.max(a, b);
            pq.add(res);
            ops++;
            if (res < k) cnt++;
        }
        return ops;
    }
}
