class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n<2) return 0;
        
        int[][] dp = new int[k+1][n+1];
        
        for(int i=1; i<=k; i++)
        {
            int best = -prices[0];
            for(int j=1; j<=n; j++)
            {
                dp[i][j] = Math.max(dp[i][j-1], prices[j-1]+best);
                best = Math.max(best, dp[i-1][j-1]-prices[j-1]);
            }
        }
        return dp[k][n];
    }
}