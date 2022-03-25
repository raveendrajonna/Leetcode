class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->(x[0]-y[0]));
        
        int sum =0;
        for(int i=0; i<n; i++)
        {
            sum = sum+costs[i][0];
            pq.add(new int[] { costs[i][1]- costs[i][0] , i });
        }
        
        int cnt =0;
        while(cnt < n/2 )
        {
            cnt++;
            int[] cur = pq.remove();
            sum = sum+cur[0];
            //System.out.println(" b : idx :"+ cur[1] +", profit : "+ cur[0] );
        }
        
        return sum;
    }
    
    
    
   
}