    }
    
    public boolean search(String word, int idx, Trie node, int misMatches)
    {
       if(misMatches > 1)
            return false;
        
        if(idx == word.length())
             return true;
        
        for(char c : node.childs.keySet())
        {
            if(c == word.charAt(idx))
            {
                boolean val =  search(word, idx+1, node.childs.get(c), misMatches);
                if(val) 
                    return true;
            }
            else
            {
               boolean val = search(word, idx+1, node.childs.get(c), misMatches+1);
                if(val)
                    return true;
            }
            
        }
        
        return false;
    }
    
    
    public void addToTrie(String word)
    {
​
              Trie temp = root;
              for(char c : word.toCharArray())
              {
                  if(!temp.childs.containsKey(c))
                  {
                      temp.childs.put(c,new Trie());
                  }
                  temp = temp.childs.get(c);
              }
              temp.isEnd = true;
    }
    
    class Trie
    {
        HashMap<Character,Trie> childs;
        boolean isEnd;
        
        public Trie()
        {
            childs = new HashMap<>();
            isEnd = false;
        }
    }
}
