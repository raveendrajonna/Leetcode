class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c : s.toCharArray())
        {
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        
        int res =0;
        boolean odd = false;
        for(int val : hm.values())
        {
            if(val%2 == 0)
            {
                res = res+val;
             }
            else
            {
                res = res+val-1;
                odd = true;
            }
        }
        if(odd)
            res = res+1;
        
        return res;
    }
}