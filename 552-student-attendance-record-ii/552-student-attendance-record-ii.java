class Solution {
    public int checkRecord(int n) {
       int[][][] mem = new int[n][2][3];
        return util(0, n, 0, 0, mem);
    }
    
    public int util(int i, int n, int a, int l, int[][][] mem)
    {
        if(i == n)
            return 1;
        
        if(mem[i][a][l] != 0) 
            return mem[i][a][l];
        
        long res = util(i+1, n, a, 0, mem);
        
        if(a == 0)
            res += util(i+1, n, a+1, 0, mem);
        
        if(l<2)
           res += util(i+1, n, a, l+1, mem);
        
        mem[i][a][l] = (int) (res%1000000007);
        return mem[i][a][l];
    }
}