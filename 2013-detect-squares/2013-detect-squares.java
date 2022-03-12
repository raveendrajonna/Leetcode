class DetectSquares {
   HashMap<String, Integer> hm ;
    List<int[]> points;
    public DetectSquares() {
        hm = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        String key = point[0]+"-"+point[1];
        hm.put(key, hm.getOrDefault(key,0)+1);
        points.add(point);
    }
    
    public int count(int[] point) {
      int res =0;
      int x1 = point[0];
      int y1 = point[1];
        
        for(int[] p : points)
        {
            int x2 = p[0];
            int y2 = p[1];
            if(x1 == x2 || y1 == y2 || Math.abs(x1-x2) != Math.abs(y1-y2))
                continue;
            res = res + hm.getOrDefault(x1+"-"+y2,0)*hm.getOrDefault(x2+"-"+y1,0);
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */