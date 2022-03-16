class Solution {
    public boolean removeOnes(int[][] grid) {
        HashSet<String> hs = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();
        for(int i=0; i< grid[0].length; i++)
        {
            sb.append(grid[0][i]);
            rsb.append(1-grid[0][i]);
        }
        hs.add(sb.toString());
        hs.add(rsb.toString());
        
        for(int i=1; i<grid.length; i++)
        {
            sb = new StringBuilder();
            rsb = new StringBuilder();
            for(int j=0; j<grid[0].length; j++)
            {
                sb.append(grid[i][j]);
                rsb.append(1-grid[i][j]);
            }
            if(!hs.contains(sb.toString()) && !hs.contains(rsb.toString()))
            {
                return false;
            }
        }
        return true;
    }
}