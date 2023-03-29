package leetcode;

public class SearchRotatedArray33 {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int left = bs(nums, target, 0, pivot);
        int right = bs(nums, target, pivot + 1, nums.length - 1);
        if (left != -1) return left;
        if (right != -1) return right;
        return -1;
    }

    int findPivot(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= arr[0]) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    int bs(int[] arr, int target, int l, int r) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
