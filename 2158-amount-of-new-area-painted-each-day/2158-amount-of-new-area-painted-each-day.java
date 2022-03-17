class Solution {
    public int[] amountPainted(int[][] paint) {
       int[] visited = new int[100000]; 
        int[] res = new int[paint.length];
        
        for(int i=0; i<paint.length; i++)
        {
            int start = paint[i][0];
            int end = paint[i][1];
            
            while(start < end)
            {
                int jump = Math.max(start+1, visited[start]);
                
                if(visited[start] == 0)
                {
                    res[i]++;
                    visited[start] = Math.max(end, visited[start]);
                }
                start = jump;
            }
        }
        return res;
        
    }
}