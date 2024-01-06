package leetcode;

public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int idx = len - 1;
        int break_point = -1;

        while (idx >= 1) {
            if (nums[idx] > nums[idx - 1]) {
                break_point = idx - 1;
                break;
            }
            idx--;
        }

        if (break_point == -1) {
            reverse(nums, 0);
        } else {
            int idx2 = len - 1;
            while (nums[idx2] <= nums[break_point]) idx2--;

            int temp = nums[idx2];
            nums[idx2] = nums[break_point];
            nums[break_point] = temp;

            reverse(nums, break_point + 1);

        }
    }

    public void reverse(int[] arr, int idx) {
        int lo = idx, hi = arr.length - 1;
        while (lo < hi) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;

            lo++;
            hi--;
        }
    }

}
