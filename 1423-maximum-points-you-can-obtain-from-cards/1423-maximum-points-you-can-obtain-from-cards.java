class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] l = new int[n];
        int[] r= new int[n];
        l[0] = cardPoints[0];
        r[n-1] = cardPoints[n-1];
        for(int i=1; i<k; i++)
        {
            l[i] = l[i-1]+cardPoints[i];
            r[n-1-i] = r[n-i] + cardPoints[n-1-i];
        }
        
        int res = Math.max(l[k-1] , r[n-k]);
        for(int i=1; i< k ; i++)
        {
            int rcnt = k-i;
            int cur =  l[i-1] + r[n-rcnt];
            res = Math.max(res, cur);
        }
        return res;
  }
}