package leetcode;

public class CountNumberOfTeams1395 {
    public int numTeams(int[] rating) {
        int res = 0;
        int n = rating.length;

        for (int i = 0; i < n; i++) {
            int leftsmaller = 0, leftgreater = 0, rightsmaller = 0, rightgreater = 0;

            for (int left = 0; left < i; left++) {
                if (rating[left] < rating[i]) leftsmaller++;
                else if (rating[left] > rating[i]) leftgreater++;
            }
            for (int right = i + 1; right < n; right++) {
                if (rating[right] < rating[i]) rightsmaller++;
                else if (rating[right] > rating[i]) rightgreater++;
            }

            res += leftsmaller * rightgreater + leftgreater * rightsmaller;
        }

        return res;

    }
}
