// Minimum Number of Coins for Fruits

class minnumcoin {
    // Method to find the minimum number of coins needed to buy all fruits
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        // Initialize a dynamic programming array with maximum integer values
        var dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // The minimum number of coins needed to buy 0 fruits is 0
        dp[0] = 0;
        // Loop through each fruit
        for(int i = 0; i < n; ++i) {
            // Calculate the minimum number of coins needed to buy the current fruit
            int x = dp[i] + prices[i];
            // Update the minimum number of coins needed to buy the next fruits
            for(int j = 1; j <= i + 2 && i + j <= n; ++j) {
                dp[i+j] = Math.min(dp[i+j], x);
            }
        }
        // Return the minimum number of coins needed to buy all fruits
        return dp[n];
    }
}
