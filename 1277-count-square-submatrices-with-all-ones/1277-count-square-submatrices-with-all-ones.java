class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int cnt=0;
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(matrix[i-1][j-1] == 1)
                {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    cnt = cnt+dp[i][j];
                }
                else
                {
                    dp[i][j] = 0;
                }
            }
        }
        return cnt;
    }
}