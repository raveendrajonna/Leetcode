class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int sidx =0;
        int idx =-1;
        
        int res =0;
        for(char c : s.toCharArray())
        {
            idx++;
            if(hm.containsKey(c))
            {
                sidx = Math.max(sidx, hm.get(c)+1);
            }
            res = Math.max(res, (idx-sidx)+1);
            hm.put(c, idx);
        }
        return res;
    }
}