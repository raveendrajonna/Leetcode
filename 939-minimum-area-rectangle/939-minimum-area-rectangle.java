class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<String,int[]> hm = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for(int i=0; i<points.length; i++)
        {
            String key = points[i][0]+"_"+points[i][1];
            hm.put(key, points[i]);
        }
        
        
        
        for(int i=0; i<points.length; i++)
        {
            for(int j=i+1; j<points.length; j++)
            {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                
                if(x1 == x2 || y1 == y2)
                {
                    continue;
                }
                
                String point3 = x1+"_"+y2;
                String point4 = x2+"_"+y1;
                
                if(hm.containsKey(point3) && hm.containsKey(point4))
                {
                    
                    //rectangle found, calculate area
                    int  vlen = Math.abs(y2-y1);
                    int  hlen = Math.abs(x2-x1);
                    res = Math.min(res, vlen*hlen);
                    //System.out.println(" x1 :"+ x1 +", x2 :" + x2 +", y1 :" +y1 +", y2 :" + y2 +", res :" + res);
                }
            }
        }
        if(res == Integer.MAX_VALUE)
            return 0;
        return res;
    }
}