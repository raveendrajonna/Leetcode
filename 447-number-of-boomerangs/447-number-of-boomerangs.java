class Solution {
    public int numberOfBoomerangs(int[][] points) {
       HashMap<Integer,Integer> hm = new HashMap<>();
        int res=0;
        
        for(int i=0; i<points.length; i++)
        {
            for(int j=0; j<points.length; j++)
            {
                if(i== j)
                    continue;
                
                int d = getDistinace(points[i], points[j]);
                hm.put(d, hm.getOrDefault(d,0)+1);
            }
            
            for(int val : hm.values())
            {
                //System.out.println("i :"+i +", val :"+ val);
                res = res + (val * (val-1));
            }
           // System.out.println("*****");
            hm.clear();
        }
        return res;
    }
    
    public int getDistinace(int[] p1, int[] p2)
    {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return (dx*dx)+(dy*dy);
    }
}