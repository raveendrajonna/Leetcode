class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        
        if(s.charAt(0) == '0')
            return 0;
        
        dp[0] =1;
        dp[1]= 1;
        
        for(int i=2; i<=n; i++)
        {
            int n1 = Integer.parseInt(s.substring(i-2,i));
            int n2 = Integer.parseInt(s.substring(i-1, i));

            if(n1>9 && n1 < 27)
                dp[i] += dp[i-2];
            
                        
            if(n2 > 0 && n2 < 10)
                dp[i] += dp[i-1];
            
        }
        
        return dp[n];
        
    }
}