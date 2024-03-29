package leetcode;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) dp[i] = amount + 1;
        dp[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
