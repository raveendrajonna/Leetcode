class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++)
        {
           dp[i][i] = 1;
        }
        
        for(int i=0; i<n-1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                dp[i][i+1] =1;
            }
            else
            {
                dp[i][i+1] = 2;
            }
        }
        
        for(int d=3; d<= n; d++)
        {
            for(int i=0; i+d<=n; i++)
            {
                int j= i+d-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++)
                {
                    int val = dp[i][k]+ dp[k+1][j];
                    if(s.charAt(i) == s.charAt(j))
                    {
                        val--;
                    }                    
                    dp[i][j] = Math.min(dp[i][j], val);
                }
            }
        }
        return dp[0][n-1];
    }
}