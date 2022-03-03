class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length <2)
            return true;
        
       Arrays.sort(intervals, (x,y)->(x[0]-y[0]));
        int n = intervals.length;
        int[] top = intervals[0];
        for(int i=1; i<intervals.length; i++)
        {
            if(top[1] > intervals[i][0])
                return false;
            
            top[1] = Math.max(top[1], intervals[i][1]);
        }
        return true;
    }
}
