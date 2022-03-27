class DetectSquares {

    List<List<Integer>> points;
    HashMap<String, Integer> hm;
    public DetectSquares() {
        points = new ArrayList<>();
        hm = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> p = new ArrayList<>();
        p.add(point[0]);
        p.add(point[1]);
        points.add(p);
        String key = point[0]+"@"+ point[1];
        hm.put(key, hm.getOrDefault(key,0)+1);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int res=0;
        for(int i=0; i<points.size(); i++)
        {
            int x2 = points.get(i).get(0);
            int y2 = points.get(i).get(1);
            
            if(x1== x2 || y1 == y2 || ( Math.abs(x2-x1) != Math.abs(y1-y2)))
                continue;
            
            res = res + (hm.getOrDefault(x1+"@"+y2, 0) * hm.getOrDefault(x2+"@"+y1, 0));
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