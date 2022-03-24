class Solution {
    public String minWindow(String s1, String s2) {
        int i=0; 
        int j=0;
        int idx = -1;
        int len = Integer.MAX_VALUE;
        
        while(i<s1.length())
        {
            if(s1.charAt(i) == s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
            if(j == s2.length())
            {
                int end = i;
                i--;
                j--;
                
                while(j>=0)
                {
                   if(s1.charAt(i) == s2.charAt(j))
                   {
                       i--;
                       j--;
                   }
                    else
                    {
                        i--;
                    }
                }
                
                if(len > (end-i))
                {
                    len = end-i;
                    idx = i+1;
                }
                i = i+2;
                j=0;
            }
        }
        
        if(idx == -1)
        {
            return "";
        }
        
        return s1.substring(idx, idx+len-1);
    }
}