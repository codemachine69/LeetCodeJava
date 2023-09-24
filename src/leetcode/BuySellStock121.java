package leetcode;

public class BuySellStock121 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0, profitIfSellToday = 0, leastPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastPrice) leastPrice = prices[i];
            if (prices[i] - leastPrice > maxProfit) maxProfit = prices[i] - leastPrice;
        }

        return maxProfit;
    }

    public int maxProfit_kadane(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
