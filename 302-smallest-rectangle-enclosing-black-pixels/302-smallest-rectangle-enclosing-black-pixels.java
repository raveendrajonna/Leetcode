class Solution {
    int minX;
    int maxX;
    int minY;
    int maxY;
    // top, right, bot , left
    int[] ra = new int[]{ -1 , 0, 1 , 0};
    int[] ca = new int[]{  0,  1, 0 , -1};
    public int minArea(char[][] image, int x, int y) {
        minX = x;
        maxX = x;
        minY = y;
        maxY = y;
        boolean[][] visited = new boolean[image.length][image[0].length];
        util(image,x,y, visited);
        return (maxX-minX+1)*(maxY-minY+1);
    }
    
    public void util(char[][] image, int x, int y,boolean[][] visited)
    {
        if(x>= 0 && x<image.length && y>=0 && y<image[0].length && image[x][y] == '1' && !visited[x][y])
        {
            visited[x][y] = true;
            minX =Math.min(minX,x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
            for(int i=0; i<4; i++)
            {
                int nx = x + ra[i];
                int ny = y + ca[i];
                
                util(image,nx,ny,visited);
            }
        }
    }
}