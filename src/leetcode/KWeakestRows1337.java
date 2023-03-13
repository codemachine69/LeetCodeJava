package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class KWeakestRows1337 {
    int soldierCount(int[] arr) {
        int l = 0, r = arr.length - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == 1) {
                ans = mid;
                l = mid + 1;
            } else {
                ans = mid - 1;
                r = mid - 1;
            }
        }
        return ans;
    }

    public int[] kWeakestRows_hashmap(int[][] mat, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            hm.put(i, soldierCount(mat[i]));
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }

    public int[] kWeakestRows_pq(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] {soldierCount(mat[i]), i});
            if (pq.size() > k)
                pq.poll();
        }

        while (k > 0)
            ans[--k] = pq.poll()[1];

        return ans;
    }
}
