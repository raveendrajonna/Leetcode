class Solution {
    int ans = Integer.MAX_VALUE;
    int n, m;
    public int tilingRectangle(int n, int m) {
        this.n = n;
        this.m = m;
        dfs(0,0, new boolean[n][m], 0);
        return ans;
    }
 
    
    public void dfs(int r, int c, boolean[][] visited, int cnt)
    {
        if(cnt >= ans)
        {
            return;
        }
        
        if(r >= n)
        {
            ans =cnt;
            return;
        }
        
        if(c >= m)
        {
            dfs(r+1, 0, visited, cnt);
            return;
        }
        
        
        if(visited[r][c])
        {
            dfs(r, c+1, visited, cnt);
            return;
        }
        

        
        for(int k= Math.min(n-r, m-c); k>=1 && isAvailable(r, c, visited, k) ; k--)
        {
            cover(r, c, visited, k, true);
            dfs(r, c+k, visited, cnt+1);
            cover(r,c, visited, k, false);
        }
    }
    
    public void cover(int r, int c, boolean[][] visited, int k, boolean value)
    {
        for(int i=r; i<r+k; i++)
        {
            for(int j=c; j< c+k; j++)
            {
               visited[i][j] = value;
            }
        }
    }
    
    public boolean isAvailable(int r, int c, boolean[][] visited, int k)
    {
        for (int i = r; i < r+k; i++){
            for (int j = c; j < c+k; j++){
                if (visited[i][j]) return false;
            }
        }
        return true;
    }
    
}