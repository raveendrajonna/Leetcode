class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[] dp = new int[m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->(x[0]== y[0]? x[1]-y[1] : x[0]-y[0]));
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n && mat[i][j] == 1; j++)
            {
                dp[i]++;
            }
            pq.add(new int[] { dp[i], i});
        }
        
        int[] res = new int[k];
        int i=0; 
        while(i<k)
        {
            int[] cur = pq.remove();
            res[i++] = cur[1];
        }
        return res;
    }
}