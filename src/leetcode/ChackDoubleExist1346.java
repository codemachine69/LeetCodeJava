package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class ChackDoubleExist1346 {
    public boolean checkIfExist_bs(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = 2 * arr[i];
            int l, r;
            if (target < 0) {
                l = 0;
                r = i - 1;
            } else {
                l = i + 1;
                r = arr.length - 1;
            }
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] == target) return true;
                else if (arr[mid] < target) l = mid + 1;
                else r = mid - 1;
            }
        }
        return false;
    }

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : arr) {
            if (hs.contains(2 * x) || (x % 2 == 0 && hs.contains(x / 2))) return true;
            hs.add(x);
        }
        return false;
    }
}
