package leetcode;

public class TrappingRainWater42 {
    public int trap_dp(int[] height) {
        int n = height.length;
        int ans = 0;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(maxLeft[i], maxRight[i]);
            if (waterLevel >= height[i]) ans += waterLevel - height[i];
        }

        return ans;
    }

    public int trap(int[] height) {
        int n = height.length;
        int ans = 0, maxLeft = height[0], maxRight = height[n - 1];
        int left = 1, right = n - 2;

        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] < maxLeft)
                    ans += maxLeft - height[left];
                else
                    maxLeft = height[left];
                left++;
            } else {
                if (height[right] < maxRight)
                    ans += maxRight - height[right];
                else
                    maxRight = height[right];
                right--;
            }
        }
        return ans;
    }
}
