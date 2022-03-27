class Solution {
    public String longestPalindrome(String s) {
        String starString = generateStar(s);
        int c=0, r=0, len=1, idx =0;
        int[] dp = new int[starString.length()];
        for(int i=1; i<starString.length(); i++)
        {
            int mir = (2*c) - r;
            
            if(i < r)
                dp[i] = Math.min(dp[mir], r-i);
            
            while( (i-dp[i]) >=0 && (i+dp[i]) < starString.length()
               && (starString.charAt(i-dp[i]) == starString.charAt(dp[i]+i)))
            {
                dp[i]++;
                
                if(len < dp[i])
                {
                    len = dp[i];
                    idx = i;
                }
            }
            
            if(i+dp[i] < r)
            {
                c = i;
                r = i+dp[i]-1;
            }          
        }
        
        String subStr = starString.substring(idx-len+1, idx+len);
        return subStr.replace("*","");
    }
    
    public String generateStar(String s)
    {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
        {
            sb.append("*");
            sb.append(s.charAt(i));
        }
        sb.append("*");
        return sb.toString();
    }
}