class Solution {
    public int minAreaRect(int[][] points) {
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<points.length; i++)
        {
            hs.add(points[i][0]+"@"+points[i][1]);
        }
        
        int res = Integer.MAX_VALUE;
        for(int i=0; i<points.length; i++)
        {
            for(int j= i+1; j<points.length; j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                if(x1==x2 || y1== y2)
                {
                    continue;
                }
                
                if( hs.contains(x1+"@"+y2) && hs.contains(x2+"@"+y1))
                {
                    //diagonals found;
                    int area = (Math.abs(x2-x1) * Math.abs(y2-y1));
                    res = Math.min(res, area);
                }
            }
        }
        if(res == Integer.MAX_VALUE)
            return 0;
        
        return res;
    }
}