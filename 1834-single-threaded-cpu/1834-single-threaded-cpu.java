class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] t = new int[tasks.length][3];
        int n = tasks.length;
        for(int i=0; i<n; i++)
        {
            t[i] = new int[]{ tasks[i][0], tasks[i][1], i}; 
        }
        
        Arrays.sort(t, (x,y)->(x[0]-y[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->( x[0]==y[0]?x[1]-y[1]:x[0]-y[0]));
        
        int i=0, j=0;
        int[] res = new int[n];
        int time = 0;
        
        while( i < t.length)
        {
           while(i<n && time >= t[i][0])   
           {
               int[] cur = t[i++];
               pq.add(new int[] { cur[1],cur[2]});
           }
            if(pq.size() > 0)
            {
                int[] cur = pq.remove();
                res[j++] = cur[1];
                time = time+cur[0];
            }
            else
            {
                if(i<n)
                {
                    time = t[i][0];
                }
            }
        }
        
        while(pq.size() > 0)
        {
            int[] cur = pq.remove();
            res[j++] = cur[1];
            
        }
        return res;                                  
    }
}