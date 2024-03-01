package leetcode;

public class MaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, cnt = 0;
        for (int num : nums) {
            if (num == 1)
                cnt++;
            else
                cnt = 0;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
