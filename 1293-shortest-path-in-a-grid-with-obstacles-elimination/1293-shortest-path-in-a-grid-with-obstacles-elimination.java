class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirArr = new int[][] { {-1,0} , {0,1} , { 1, 0} , {0, -1}};
        boolean[][][] visited = new boolean[m][n][k+1];
        
        Queue<int[]> q = new LinkedList<>();
        //0--> row, 1--> col, 2 --> step, 3-->obstacles;  
        q.add(new int[] { 0, 0, 0, 0});
        visited[0][0][0] = true;
        while(q.size() > 0)
        {
            int[] cur = q.remove();
            int r= cur[0];
            int c = cur[1];        
            if(r == m-1 && c == n-1)
                return cur[2];                              
            for(int i=0; i<4; i++)
            {
                int nr = r + dirArr[i][0];
                int nc = c + dirArr[i][1];

                if(nr>= 0 && nr < m && nc >=0 && nc <n)
                {
                    if(grid[nr][nc] == 0 && !visited[nr][nc][cur[3]])
                    {
                        q.add(new int[] { nr, nc, cur[2]+1, cur[3]});
                        visited[nr][nc][cur[3]] = true;
                    }
                    if((cur[3]+1) <= k && !visited[nr][nc][cur[3]+1])
                    {
                        q.add(new int[] { nr, nc, cur[2]+1, cur[3]+1 });
                        visited[nr][nc][cur[3]+1] = true;
                    }
                }
            }
            }
      return -1;             
    }
}