class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (x,y)->(x[0]-y[0]));
        int end = Integer.MIN_VALUE;
        int cnt =0;
        for(int i=0; i<n; i++)
        {
           if(end > intervals[i][0])
           {
               cnt++;
               end = Math.min(end, intervals[i][1]);
           }
            else
            {
                end = intervals[i][1];
            }
        }
        return cnt;
    }
}
