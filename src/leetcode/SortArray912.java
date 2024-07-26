package leetcode;

public class SortArray912 {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, r, mid);
        }
    }

    private void merge(int[] nums, int l, int r, int mid) {
        int n1 = mid - l + 1, n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) left[i] = nums[l + i];
        for (int i = 0; i < n2; i++) right[i] = nums[mid + i + 1];
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while (i < n1) nums[k++] = left[i++];
        while (j < n2) nums[k++] = right[j++];
    }
}
