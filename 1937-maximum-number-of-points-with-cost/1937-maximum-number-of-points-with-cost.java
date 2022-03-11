class Solution {
    public long maxPoints(int[][] points) {
       int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for(int i=0; i<m ; i++)
        {
            for(int j=0; j<n; j++)
            {
              dp[j] = dp[j] + points[i][j];  
            }
            
            for(int j=1; j<n; j++)
            {
                dp[j] = Math.max(dp[j], dp[j-1]-1);
            }
            
            for(int j=n-2; j>= 0; j--)
            {
                dp[j] = Math.max(dp[j], dp[j+1]-1);
            }
        }
        
        long res =0;
        for(int i=0; i<n; i++)
        {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}