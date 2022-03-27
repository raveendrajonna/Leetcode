class Solution {
    int rows, cols;
    int ans;
    int[][] dirArr = new int[][] { {-1,0}, {0,1} , {1,0} , {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] visited = new int[rows][cols];
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                int val = dfs(i,j, matrix, visited, -1);
                ans = Math.max(ans,val);
            }
        }
        return ans;
        
    }
    
    public int dfs(int r, int c, int[][] matrix, int[][] visited, int prevVal)
    {
        if(r>=0 && r<rows && c >= 0 && c<cols && prevVal < matrix[r][c])
        {
            if(visited[r][c] != 0)
                return visited[r][c];
            
            for(int i=0; i<4; i++)
            {
                int nr = r+dirArr[i][0];
                int nc = c + dirArr[i][1];
                
                visited[r][c] = Math.max(visited[r][c] , 1+ dfs(nr, nc, matrix, visited, matrix[r][c]));
            }
            
            return visited[r][c];
        }
        else
        {
            return 0;
        }
    }
    
}