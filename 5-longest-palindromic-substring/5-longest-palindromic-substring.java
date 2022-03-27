class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String starString = generateStarString(s);
        int[] dp = new int[starString.length()];
        int c=0, r =0;
        int len=1;
        int idx=0;
        for(int i=1; i<starString.length(); i++)
        {
            int mirror = (2*c)-r;
            //System.out.println(" mirror :" + mirror +", i :"+ i +", c :" +c +", r : "+ r);
            if(i < r)
                dp[i] = Math.min(dp[mirror], r-i);
            
            while(i-dp[i] >= 0 && i+dp[i] < starString.length() 
                  && starString.charAt(i-dp[i]) == starString.charAt(i+dp[i]))
            {
                dp[i]++;
                if(len < dp[i])
                {
                    len = dp[i];
                    idx = i;
                }
            }
            
            if( (i+dp[i]) > r)
            {
                c = i;
                r = i+dp[i]-1;
            }
        }
       // System.out.println(" len :"+ len +", idx :"+ (idx-len) );
        String val = starString.substring(idx-len+1, idx+len);
        return val.replace("*", "");
    }
    
    public String generateStarString(String s)
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