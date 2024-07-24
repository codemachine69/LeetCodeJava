package leetcode;

public class SumOfSquareNumbers633 {
    public boolean judgeSquareSum(int c) {
        long lo = 0, hi = (long) Math.sqrt(c);

        while (lo <= hi) {
            long sum = lo * lo + hi * hi;
            if (sum > c) hi--;
            else if (sum < c) lo++;
            else return true;
        }
        return false;
    }
}
