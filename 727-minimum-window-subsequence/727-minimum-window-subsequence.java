class Solution {
    public String minWindow(String s1, String s2) {
        
        int i=0; 
        int j=0;
        
        int start=0;
        int end=0;
        int idx =-1;
        int len = Integer.MAX_VALUE;
        
        while(i <s1.length() && j < s2.length())
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
                end = i;
                i = i-1;
                j = j-1;
                //System.out.println(" i :"+ i +" j :" + j);
                while(i >= 0 &&  j >= 0)
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
                    //System.out.println(" *****. i :" + i +", j : "+ j );
                }
                if(len > (end-i))
                {
                    idx = i+1;
                    len = (end-i);
                }
                j=0;
                i = i+2;
            }
            
        }
        System.out.println("idx :" + idx);
        if(idx != -1)
        {
            return s1.substring(idx,idx+len-1);
        }
        return "";
    }
}