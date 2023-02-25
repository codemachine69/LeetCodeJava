package leetcode;

public class ReverseInteger7 {
    public int reverse(int x) {
        int ans = 0, newans = 0;

        while (x != 0) {
            newans = ans * 10 + x % 10;
            if(newans/10 != ans) return 0;
            ans = newans;
            x /= 10;
        }
        return ans;
    }
}
