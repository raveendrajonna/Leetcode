class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int res=0;
        int sidx = 0;
        int idx =-1;
        
        for(char c : s.toCharArray())
        {
            idx++;
            System.out.println("char -" + c );
            if(!hm.containsKey(c))
            {
                res = Math.max(res, (idx- sidx)+1);
            }
            else
            {
                sidx = Math.max( hm.get(c)+1, sidx);
                res = Math.max(res, (idx-sidx)+1);
            }
            System.out.println(" idx :" + idx +", c : " + c +", res :  "+ res);
            hm.put(c, idx);
        }
        return res;
    }
}