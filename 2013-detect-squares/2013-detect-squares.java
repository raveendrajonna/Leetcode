class DetectSquares {
    List<List<Integer>> points;
    HashMap<String, Integer> hs;
    public DetectSquares() {
        hs = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
       String key = point[0]+"@"+point[1];
       hs.put(key, hs.getOrDefault(key,0)+1);
       List<Integer> lst = new ArrayList<>();
        lst.add(point[0]);
        lst.add(point[1]);
        points.add(lst);
    }
    
    public int count(int[] point) {
        
        int x1 = point[0];
        int y1 = point[1];
        int res=0;
        for(int i=0; i<points.size(); i++)
        {
            //Are thest diagnoals       
            int x2 = points.get(i).get(0);
            int y2 = points.get(i).get(1);
            if(x1 == x2 || y1 == y2 )
                continue;
            
            if( Math.abs(x2-x1) == Math.abs(y2-y1))
            {
                //x,y distances are same
                
                res =  res + (hs.getOrDefault(x1+"@"+y2,0) * hs.getOrDefault(x2+"@"+y1,0));
                
            }
            
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