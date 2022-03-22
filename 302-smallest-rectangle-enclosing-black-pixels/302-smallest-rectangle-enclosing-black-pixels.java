class Solution {
    int[][] dir = new int[][] { {-1,0} , {0, 1} , {1,0} , {0,-1} };
    int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY= Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
    public int minArea(char[][] image, int x, int y) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        util(image, x, y , visited);
        return (maxX-minX+1) * (maxY - minY+1);
    }
    
    public void util(char[][] image, int x, int y,boolean[][] visited)
    {
        if(visited[x][y])
            return ;
        
        visited[x][y] = true;
        
        minX = Math.min(x, minX);
        maxX = Math.max(x, maxX);
        minY = Math.min(y, minY);
        maxY = Math.max(y, maxY);
       // System.out.println(" x  : " + x +", y : " + y);
        for(int i=0; i<4; i++)
        {
            int nr = x + dir[i][0];
            int nc = y + dir[i][1];
            
            if(nr >= 0 && nr < image.length && nc >=0 && nc < image[0].length && !visited[nr][nc] && image[nr][nc] == '1')
            {
                util(image, nr,nc, visited);
            }
        }
        
    }
}