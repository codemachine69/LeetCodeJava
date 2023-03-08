package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class InterSectionOfTwoArraysII350 {
    public int[] intersect_2pointers(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }

    public int[] intersect_hashmap(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect_hashmap(nums2, nums1);

        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int x : nums1) {
            if (hm.containsKey(x)) {
                hm.put(x, hm.get(x) + 1);
            } else {
                hm.put(x, 1);
            }
        }

        for (int x : nums2) {
            if (hm.containsKey(x) && hm.get(x) > 0) {
                arr.add(x);
                hm.put(x, hm.get(x) - 1);
            }
        }

        int[] ans = new int[arr.size()];
        int k = 0;
        for (Integer x : arr) ans[k++] = x;
        return ans;
    }
}
