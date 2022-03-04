class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int cnt=0;
        int res =0;
        List<int[]> lst = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            lst.add(new int[]{intervals[i][0],0});
            lst.add(new int[]{intervals[i][1],1});
        }
        
        Collections.sort(lst,(x,y)->( (x[0]==y[0])?y[1]-x[1]:x[0]-y[0]));
        
        for(int i=0; i<lst.size();i++)
        {
            if(lst.get(i)[1] == 0)
            {
                cnt++;
            }
            else
            {
                cnt--;
            }
            res = Math.max(res,cnt);
        }
        return res;
    }
    
}
