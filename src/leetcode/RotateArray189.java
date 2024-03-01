package leetcode;

public class RotateArray189 {
    public void rotate(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    private void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}
