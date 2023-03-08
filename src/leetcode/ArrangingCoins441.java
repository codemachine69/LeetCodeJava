package leetcode;

public class ArrangingCoins441 {
    public int arrangeCoins(int n) {
        if(n == 1) return 1;
        if(n == 3) return 2;
        long l = 2, r = n/2;
        while(l <= r) {
            long mid = l + (r - l)/2;
            long coinsNeeded = mid*(mid+1)/2;
            if(coinsNeeded > n) r = mid - 1;
            else if(coinsNeeded == n) return (int)mid;
            else l = mid + 1;
        }
        return (int)r;
    }
}
