package leetcode;

public class SearchInsertPos35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, ans = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
                ans = mid - 1;
            }
        }
        return ans;
    }
}
