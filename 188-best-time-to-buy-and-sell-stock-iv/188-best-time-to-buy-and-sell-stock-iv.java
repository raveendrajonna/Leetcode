class Solution {
    public int maxProfit(int k, int[] prices) {
       int n = prices.length;
        
        if(k>= n/2)
        {
            return quickSolve(prices);
        }
        int[][] dp = new int[k+1][n];
        for(int i=1; i<=k ;i++)
        {
            int max = -prices[0];
            for(int j=1; j<n; j++)
            {
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+max);
                max = Math.max(dp[i-1][j-1]-prices[j], max);
            }
            
        }
        return dp[k][n-1];
    }
    
    public int quickSolve(int[] prices)
    {
        int sum =0;
        for(int i=1; i< prices.length; i++)
        {
             if(prices[i] > prices[i-1])
                 sum = sum+prices[i] - prices[i-1];
        }
        return sum;
    }
}