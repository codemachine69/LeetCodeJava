package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays349 {
    boolean bs(int[] arr, int target) {
        int l = 0;
        r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return true;
            else if (target > arr[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

    public int[] intersection_bs(int[] nums1, int[] nums2) {
        HashSet<Integer> ans = new HashSet<>();
        Arrays.sort(nums2);
        for (int x : nums1) {
            if (bs(nums2, x)) ans.add(x);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersection_set(int[] nums1, int[] nums2) {
        HashSet<Integer> s1 = new HashSet<>(), ans = new HashSet<>();
        for(int x: nums1) s1.add(x);
        for(int x: nums2) if(s1.contains(x)) ans.add(x);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public int[] intersection_2pointer(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> hs = new HashSet<>();
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;
        while (i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else {
                hs.add(nums1[i]); i++; j++;
            }
        }
        return hs.stream().mapToInt(i -> i).toArray();
    }
}
