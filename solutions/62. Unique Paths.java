class Solution {
    public int uniquePaths(int m, int n) {
        //Math problem
        //Total rows = m, total cols = n total down steps (m-1), total - (n-1) - R steps
        //So lets m=3, n=2 means 2Ds, 1R ex : DDR, DRD, RDD 
        // ncr(p,q) => (p!/q!(p-q)!)
        
        int ts = m+n-2;
        int ds =m-1;
        double res = 1d;
        for(int i=1; i <= (m-1); i++)
        {
            res = res * (ts-(m-1)+i);
            res = res/i;
        }
        return (int)res;
        
    }
}
