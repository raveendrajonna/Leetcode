class Solution {
    public int maxProfit(int k, int[] prices) {
       int n = prices.length;
        int[][] dp = new int[k+1][n+1];
        
        if(n < 1)
            return 0;
        
        for(int i=1; i<=k; i++)
        {
            int max = -prices[0];
            for(int j=1; j<=n; j++)
            {
                dp[i][j] = Math.max(dp[i][j-1], max+prices[j-1]);
                max = Math.max(max, dp[i-1][j-1]-prices[j-1]);
            }
        }
        return dp[k][n];
    }
}