class Solution {
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][][] visited = new boolean[m][n][k+1];
        int[] ra = new int[] { -1, 0, 1, 0};
        int[] ca = new int[] { 0, 1, 0, -1};
        int res=0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 0, 0});
        visited[0][0][0] = true;
        
        while(q.size() > 0)
        {
            int[] cur = q.remove();
            
            if(cur[0] == m-1 && cur[1] == n-1)
                return cur[2];
                
             for(int i=0; i<4; i++)
             {
                 int nr = cur[0]+ ra[i];
                 int nc = cur[1] + ca[i];
                 
                 if(nr>= 0 && nr< m && nc>=0 && nc < n)
                 {
                     if(grid[nr][nc] == 0 && !visited[nr][nc][cur[3]])
                     {
                         visited[nr][nc][cur[3]] = true;
                         q.add(new int[] { nr, nc, cur[2]+1, cur[3] });
                     }
                     else if( (cur[3]+1) <= k && !visited[nr][nc][cur[3]+1]) {
                         visited[nr][nc][cur[3]+1] = true;
                         q.add( new int[] { nr, nc, cur[2]+1, cur[3]+1});
                     }
                 }
             }
        }
        return -1;
    }
}
