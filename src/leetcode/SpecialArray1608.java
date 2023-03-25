package leetcode;

import java.util.Arrays;

public class SpecialArray1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        for(int x=1; x<=nums.length; x++) if(valid(nums, x)) return x;
        return -1;
    }

    boolean valid(int[] arr, int target) {
        int l = 0, r = arr.length-1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        if(arr.length - l == target) return true;
        return false;
    }
}
