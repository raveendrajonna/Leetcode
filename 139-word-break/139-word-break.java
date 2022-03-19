class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        List<Integer> lst = new ArrayList<>();
        lst.add(-1);
        
        HashSet<String> hs = new HashSet<>();
        for(String word : wordDict)
        {
            hs.add(word);
        }
        
        for(int i=0; i<s.length(); i++)
        {
            int size = lst.size();
            for(int j=size-1; j>=0; j--)
            {
                if(hs.contains(s.substring(lst.get(j)+1,i+1)))
                {
                    lst.add(i);
                    break;
                }
            }
        }
        
        if(lst.get(lst.size()-1) == s.length()-1)
            return true;
        
        return false;
    }
}