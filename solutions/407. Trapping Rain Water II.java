class Solution {
    int rows, cols;
    int[] ra= new int[]{-1, 0, 1, 0};
    int[] ca = new int[] {0, 1, 0, -1};
    
    
    public int trapRainWater(int[][] heightMap) {
        rows = heightMap.length;
        cols = heightMap[0].length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)-> (x[2]-y[2]));
        boolean[][] visited = new boolean[rows][cols];
        int res=0;
        for(int col=0; col<cols; col++)
        {
            visited[0][col] = true;
            pq.add(new int[]{0,col,heightMap[0][col]});
            visited[rows-1][col] = true;
            pq.add(new int[] {rows-1,col, heightMap[rows-1][col]});
        }
        
        for(int row=0; row<rows; row++)
        {
            visited[row][0] = true;
            pq.add(new int[] {row,0, heightMap[row][0]});
            visited[row][cols-1] = true;
            pq.add(new int[] {row,cols-1, heightMap[row][cols-1]});
        }
        
        while(pq.size() > 0)
        {
            int[] cur = pq.remove();
            for(int i=0; i<4; i++)
            {
                int nr = cur[0] + ra[i];
                int nc = cur[1] + ca[i];
                if(nr>= 0 && nr<rows && nc >= 0 && nc<cols && visited[nr][nc] == false)
                {
                    res += Math.max(0, cur[2]-heightMap[nr][nc]);
                    visited[nr][nc] = true;
                    pq.add(new int[] { nr, nc, Math.max(heightMap[nr][nc],cur[2])});
                }
            }
        }
       return res;
    }
}
