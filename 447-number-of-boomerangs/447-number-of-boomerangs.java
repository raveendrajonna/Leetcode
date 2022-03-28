class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int res =0;
        
        for(int i=0; i <n; i++)
        {
            int x1 = points[i][0];
            int y1 = points[i][1];
            
            HashMap<Integer, Integer> hm = new HashMap<>();

                for(int j=0; j<n; j++)
                {
                   if(i == j)
                       continue;
                   
                   int  x2 = points[j][0];
                   int  y2 = points[j][1];
                   
                    int dx = x2-x1;
                    int dy = y2-y1;
                    
                    int d = (dx*dx) + (dy*dy);
                    
                    hm.put(d, hm.getOrDefault(d,0)+1);
                }
            
               for(int d : hm.keySet())
               {
                   int cnt = hm.get(d);
                   res = res + (cnt * (cnt-1) );
               }
        }
        
        return res;
    }
}