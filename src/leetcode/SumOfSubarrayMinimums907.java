package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubarrayMinimums907 {
    public int sumSubarrayMins(int[] arr) {
        final int mod = (int) (1e9 + 7);
        long res = 0;
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nextLesser = new int[n];
        int[] prevLesser = new int[n];
        Arrays.fill(nextLesser, n);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                nextLesser[st.pop()] = i;
            }
            prevLesser[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - prevLesser[i];
            long right = nextLesser[i] - i;
            res += arr[i] * left * right;
            res %= mod;
        }

        return (int) res;
    }
}
