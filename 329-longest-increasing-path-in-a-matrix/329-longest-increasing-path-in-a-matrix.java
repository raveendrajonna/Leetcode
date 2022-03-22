class Solution {
    int[][] dirArr = new int[][] { {-1, 0}, {0,1}, {1,0} , {0, -1}};
    int res =0;
    
    public int longestIncreasingPath(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
       for(int i=0; i<matrix.length; i++)
       {
           for(int j=0; j< matrix[0].length; j++)
           {
               dfs(matrix, i, j, -1, visited);
           }
       }
      return res;
    }
    
    
    public int dfs(int[][] matrix, int r, int c, int prevValue, int[][] visited)
    {
       
        
        if(r>=0 && r< matrix.length && c>=0 && c<matrix[0].length &&  matrix[r][c] > prevValue)
        {
            if(visited[r][c] != 0)
                  return visited[r][c];

            for(int i=0; i<4; i++)
            {
                int nr = r+dirArr[i][0];
                int nc = c + dirArr[i][1];
                visited[r][c] = Math.max(visited[r][c], 1 + dfs(matrix, nr, nc, matrix[r][c], visited));
            }
         
            res = Math.max(res, visited[r][c]);
            return visited[r][c];
        }
        else
        {
            return 0;
        }

    }
}