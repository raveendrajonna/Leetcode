class Solution {
    public int numberOfBoomerangs(int[][] points) {
      int n = points.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int res=0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i == j)
                    continue;
                
                int d = getDistance(points[i], points[j]);
                hm.put(d, hm.getOrDefault(d,0)+1);
            }
            for(int val : hm.values())
            {
                res = res + (val * (val-1));
            }
            hm.clear();
        }
        return res;
    }
    
    public int getDistance(int[] p1, int[] p2)
    {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return (dx*dx)+ (dy*dy);
    }
}