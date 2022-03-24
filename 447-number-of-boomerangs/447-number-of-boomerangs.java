class Solution {
    public int numberOfBoomerangs(int[][] points) {
       /* HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<points.length; i++)
        {
            for(int j=0; j<points.length; j++)
            {
                if(i == j)
                    continue;

                int d = getDistance(points[i],points[j]);       
                hm.put(d, hm.getOrDefault(d,0)+1);
            }
        }
        int res =0;
        for(Map.Entry<Integer,Integer> entry : hm.entrySet())
        {
            System.out.println("val : " + entry.getValue() +", key : " + entry.getKey());
            int val = entry.getValue();
            res = res + (val * (val-1));
        }
         return res;
        */
        
         int res = 0;

    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<points.length; i++) {
        for(int j=0; j<points.length; j++) {
            if(i == j)
                continue;
            
            int d = getDistance(points[i], points[j]);                
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        
      for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int val = entry.getValue();
            res = res + (val * (val-1));
        }
        map.clear(); 
    }
    
    return res;
        
        
       
    }
    
    private int getDistance(int[] a, int[] b) {
    int dx = a[0] - b[0];
    int dy = a[1] - b[1];
    
    return dx*dx + dy*dy;
}
}