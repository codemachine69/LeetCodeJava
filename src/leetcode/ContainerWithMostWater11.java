package leetcode;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int p1 = 0, p2 = height.length - 1;
        while (p1 < p2) {
            int currHeight = Integer.min(height[p1], height[p2]);
            maxArea = Integer.max(maxArea, currHeight * (p2 - p1));
            if (height[p1] < height[p2]) p1++;
            else p2--;

            while (p1 < p2 && height[p1] < currHeight) p1++;
            while (p1 < p2 && height[p2] < currHeight) p2--;
        }

        return maxArea;
    }
}
