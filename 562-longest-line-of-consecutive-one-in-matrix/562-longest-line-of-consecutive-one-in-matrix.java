class Solution {
    public int longestLine(int[][] mat) {
       int m = mat.length;
        int n = mat[0].length;
        int[][][] dp = new int[m+1][n+2][4];
        int res =0;
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(mat[i-1][j-1] == 1)
                {
                    dp[i][j][0] = dp[i][j-1][0]+1;
                    dp[i][j][1] = dp[i-1][j][1]+1;
                    
                    dp[i][j][2] = dp[i-1][j-1][2]+1;
                    dp[i][j][3] = dp[i-1][j+1][3]+1;
                    
                    res = Math.max ( res , dp[i][j][0]); 
                    res = Math.max ( res , dp[i][j][1]); 
                    res = Math.max ( res , dp[i][j][2]); 
                    res = Math.max ( res , dp[i][j][3]); 
                }
            }
        }
        return res;
    }
}