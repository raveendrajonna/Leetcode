class Solution {
    public int findMinDifference(List<String> timePoints) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
       for(int i=0; i< timePoints.size(); i++)
       {
           String[] str = timePoints.get(i).split(":");
           int h = Integer.parseInt(str[0]);
           int m = Integer.parseInt(str[1]);
           int total = h*60+m;
           max = Math.max(max, total);
           min = Math.min(min, total);
           pq.add(total);
       }
        int res = Integer.MAX_VALUE;
        res = (1440-max)+min;
        int prev = pq.remove(); //removed last one 
        while(pq.size() > 0)
        {
           int cur = pq.remove();
           res = Math.min(res, cur-prev);
           prev = cur;
        }
        return res;
    }
}