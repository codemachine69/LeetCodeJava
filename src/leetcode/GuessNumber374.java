package leetcode;

public class GuessNumber374 {
    public int guessNumber(int n) {
        int l = 1, r = n, mid = -1;
        while(l <= r) {
            mid = l + (r - l)/2;
            if(guess(mid) == 0) return mid;
            else if(guess(mid) == 1) l = mid + 1;
            else r = mid - 1;
        }
        return mid;
    }

    int guess(int n) {}
}
