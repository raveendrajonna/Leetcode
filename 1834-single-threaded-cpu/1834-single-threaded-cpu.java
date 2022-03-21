class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] dp = new int[tasks.length][3];
        int n = tasks.length;
        for(int i=0; i<tasks.length; i++)
        {
            dp[i][0] =tasks[i][0];
            dp[i][1] = tasks[i][1];
            dp[i][2] = i;
        }
        
        Arrays.sort(dp, (x,y)->(x[0]==y[0]?x[1]-y[1]:x[0]-y[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>( (x,y)-> (x[0]==y[0]? x[1]-y[1] : x[0]-y[0]));
        int i=0;
        int time =0;
        int[] res = new int[n];
        int idx=0;
        while(i<n)
        {
            while(i<n && time >= dp[i][0])
            {
                pq.add(new int[] {  dp[i][1] , dp[i][2] });
                i++;
            }
            if(pq.size() > 0)
            {
                int[] cur = pq.remove();
                res[idx++] = cur[1];
                time = time+cur[0];
            }
            else
            {
                if(i<n)
                {
                    time = dp[i][0];
                }
            }
        }
        
        while(pq.size() > 0)
        {
            int[] cur = pq.remove();
            res[idx++] = cur[1];
        }
        return res;
    }
}