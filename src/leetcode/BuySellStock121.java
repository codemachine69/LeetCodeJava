package leetcode;

public class BuySellStock121 {

    public int maxProfit(int[] prices) {
        int profit = 0, buy = -1;
        for (int i = 0; i < prices.length; i++) {
            if (buy == -1 || prices[i] <= buy) buy = prices[i];
            else profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }
}
