package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray2089 {
    public List<Integer> targetIndices_countingSort(int[] nums, int target) {
        int count = 0, lessthan = 0;
        for (int n : nums) {
            if (n == target) count++;
            if (n < target) lessthan++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(lessthan++);
        }
        return result;
    }

    public List<Integer> targetIndices_bs(int[] nums, int target) {
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int left_boundary = -1;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                r = mid - 1;
                left_boundary = mid;
            } else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        int right_boundary = n;
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                l = mid + 1;
                right_boundary = mid;
            } else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        if (left_boundary > -1 && right_boundary < n) {
            for (int i = left_boundary; i <= right_boundary; i++) {
                arr.add(i);
            }
        }
        return arr;
    }
}
