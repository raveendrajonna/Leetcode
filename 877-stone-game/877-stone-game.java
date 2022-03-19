class Solution {
    public boolean stoneGame(int[] piles) {
         int n= piles.length;
         int[][][] dp = new int[n+1][n+1][2];
         for(int i=0; i<n; i++)
         {
             dp[i][i] = new int[] { piles[i], 0 };
         }
        
         for(int d=1; d<n; d++)
         {
             for(int i=0; i+d <n ; i++)
             {
                 int j = i+d;
                 dp[i][j][0] = Math.max( piles[i] + dp[i+1][j][1], piles[j]+ dp[i][j-1][1]);
                 dp[i][j][1] = Math.min(dp[i+1][j][0] , dp[i][j-1][0]);
             }
         }
        return dp[n-1][n-1][0] > dp[n-1][n-1][1];
    }
}