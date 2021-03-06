class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] la = new int[n];
        int[] ra = new int[n];
        
        la[0] = cardPoints[0];
        ra[n-1] = cardPoints[n-1];
        for(int i=1; i<n; i++)
        {
            la[i] = cardPoints[i]+ la[i-1];
            ra[n-1-i] = cardPoints[n-1-i] + ra[n-i];
        }
        
        int res = Math.max(la[k-1], ra[n-k]);
        for(int i=0; i<k-1; i++)
        {
            int rem = k-1-i;
            res  = Math.max(la[i]+ra[n-rem] , res);
        }
        return res;
    }
}