class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)-> (x[0]==y[0] ? y[1]-x[1] : x[0]-y[0]));
        for(int i=0; i<intervals.length; i++)
        {
            pq.add(new int[] {intervals[i][0], 0});
            pq.add(new int[] {intervals[i][1], 1});
        }
        
        int cnt =0, res =0;
        while(pq.size() > 0)
        {
            int[] cur = pq.remove();
            if(cur[1] == 0)
                cnt++;
            else
                cnt--;
            
            res = Math.max(res, cnt);
        }
        return res;
    }
}