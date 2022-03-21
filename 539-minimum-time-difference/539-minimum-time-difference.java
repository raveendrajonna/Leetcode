class Solution {
    public int findMinDifference(List<String> timePoints) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = timePoints.size();
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            String time = timePoints.get(i);
            String[] str = time.split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int total = h*60 + m;
            pq.add(total);
            max = Math.max(max,total);
            min = Math.min(min, total);
        }
        
        int res = (1440-max+min);
        int prev = pq.remove();
        while(pq.size() > 0)
        {
            int cur = pq.remove();
            res = Math.min(cur-prev, res);
            prev = cur;
        }
        return res;
    }
}