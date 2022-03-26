class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][n+1];

        for(int i=1; i<3; i++)
        {
            int max = -prices[0];
            for(int j=1; j<=n; j++)
            {
               dp[i][j] = Math.max(dp[i][j-1], prices[j-1]+max);
               max = Math.max(max, dp[i-1][j-1] - prices[j-1]);
            }
        }
        
        return dp[2][n];

    }
}