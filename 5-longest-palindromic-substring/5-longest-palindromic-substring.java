class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;
        
        int c=0, r=0;
        
        String starString = generateStarSubString(s);
        int n = starString.length();
        int dp[] = new int[n];
        int res= 1,idx=0;
        for(int i=1; i<n; i++)
        {
            int l = (2*c)-r;
            if(i<r)
            {
                dp[i] = Math.min(dp[l] , r-i);
            }
            
            while((i-dp[i]) >= 0 && ((i+dp[i]) < n) 
                  && starString.charAt(i-dp[i]) == starString.charAt(i+dp[i]) )
            {
                dp[i]++;
                if(res < dp[i])
                {
                    res = dp[i];
                    idx = i;
                }
            }

            
            if(i+dp[i] > r)
            {
                c = i;
                r= i+dp[i]-1;
            }
        }
        String freqString = starString.substring(idx-res+1, idx+res);
        freqString = freqString.replace("*","");
        return freqString;
    }
    
    public String generateStarSubString(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray())
        {
            sb.append("*");
            sb.append(c);
        }
        sb.append("*");
        return sb.toString();
    }
}