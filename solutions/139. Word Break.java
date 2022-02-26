class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        List<Integer> lst = new ArrayList<>();
        lst.add(-1);
        int i=0;
        HashSet<String> hs = new HashSet(wordDict);     
        while(i<s.length())
        {
            for(int val : lst)
            {
                String cur = s.substring(val+1, i+1);
                if(hs.contains(cur))
                {
                    lst.add(i);
                    break;
                }
            }
            i++;
        }        
        if(lst.get(lst.size()-1) == s.length()-1)
            return true;
        return false;        
    }
}
