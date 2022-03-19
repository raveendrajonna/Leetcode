class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<String>();
        for(String word : wordDict)
        {
            hs.add(word);
        }
        List<Integer> lst = new ArrayList<>();
        lst.add(-1);
        
        for(int i=0; i<s.length(); i++)
        {
            int size = lst.size();
            for(int j=size-1; j >=0; j--)
            {
              if(hs.contains(s.substring(lst.get(j)+1, i+1)))
              {
                  lst.add(i);
                  break;
              }
            }
        }
        
        List<String> res = new ArrayList<>();
        if(lst.get(lst.size()-1) != s.length()-1)
        {
            System.out.println(" res :");
            return res;
        }
        
        util(lst,0,s,"",hs, res);
        return res;
            
        
    }
    
    public void util(List<Integer> lst, int idx, String s, String cur, HashSet<String> hs,List<String> res)
    {
        if(idx == lst.size()-1)
        {
            res.add(cur.trim());
            return;
        }
        
        for(int i=idx+1; i<lst.size(); i++)
        {
           //System.out.println(" aa - " + s.substring(lst.get(idx)+1, lst.get(i)+1));
            if(hs.contains(s.substring(lst.get(idx)+1, lst.get(i)+1)))
            {
                String newCur = cur+" "+s.substring(lst.get(idx)+1, lst.get(i)+1);
               //System.out.println(" ss :"+ newCur);
                util(lst, i, s, newCur, hs, res);  
            }
        }
    }
}