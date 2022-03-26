class Solution {
    int ans = Integer.MAX_VALUE;
    int n,m;
    public int tilingRectangle(int n, int m) {
        this.n = n;
        this.m = m;
        dfs(0, 0, new boolean[n][m], 0);
        return ans;
    }
    
    public void dfs(int r, int c, boolean[][] visited, int cnt)
    {
        if(cnt > ans)
            return;
        
        if(r >= n)
        {
            ans = cnt;
            return;
        }
        
        if( c >= m)
        {
            dfs(r+1, 0, visited, cnt);
            return;
        }
        
        if(visited[r][c])
        {
            dfs(r,c+1, visited, cnt);
            return;
        }
        
        for(int size = Math.min(n-r, m-c); size > 0 && isAvailable(r,c, size, visited); size--)
        {
            coverOrUncover(r,c, visited, size, true);
            dfs(r,c+size, visited, cnt+1);
            coverOrUncover(r,c, visited, size , false);
            
        }
        
    }
    
    public void coverOrUncover(int r, int c, boolean[][] visited, int size, boolean val)
    {
        for(int i=r; i< r+size; i++)
        {
            for(int j=c; j< c+ size; j++)
            {
                visited[i][j] = val;
            }
        }
    }
    
    public boolean isAvailable(int r, int c, int size, boolean[][] visited)
    {
       for(int i=r; i<r+size; i++)
       {
           for(int j= c; j< c+size; j++)
           {
               if(visited[i][j]) 
                   return false;
           }
       }
        return true;
    }
}