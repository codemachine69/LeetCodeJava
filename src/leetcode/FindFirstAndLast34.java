package leetcode;

public class FindFirstAndLast34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = bs1(nums, target);
        ans[1] = bs2(nums, target);
        return ans;
    }

    int bs1(int[] arr, int target) {
        int l = 0, r = arr.length - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                ans = mid;
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    int bs2(int[] arr, int target) {
        int l = 0, r = arr.length - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                ans = mid;
                l = mid + 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
