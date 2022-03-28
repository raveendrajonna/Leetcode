class Solution {
    public boolean differByOne(String[] dict) {
        Trie root = new Trie();
        for(String word : dict)
        {
            if(search(root, word, 0, 0))
            {
                return true;
            }
            
            insert(root, word);
        }
        return false;
    }
    
    public void insert(Trie root, String word)
    {
       Trie temp = root;
        for(char c : word.toCharArray())
        {
            if(temp.childs[c-'a'] == null)
            {
                temp.childs[c-'a'] = new Trie();
            }
            temp = temp.childs[c-'a'];
        }
        temp.isEnd = true;
    }
    
    public boolean search(Trie root, String word, int idx, int diff)
    {
       // System.out.println(" idx :" + idx +" word :" + word +", diff :" + diff);
        if(diff > 1 || root ==null)
            return false;

        if(idx == word.length() )
            return true;
        
        char c = word.charAt(idx);
        for(int i=0; i<26; i++)
        {
            if(c-'a' == i)
            {
              boolean val =  search(root.childs[i], word, idx+1, diff);
                if(val) return val;
            }
            else
            {
               boolean val = search(root.childs[i], word, idx+1, diff+1);
                if(val == true)
                    return val;
            }
        }
        return false;
    }
    
    class Trie
    {
        Trie[] childs;
        boolean isEnd;
        
        public Trie()
        {
            isEnd = false;
            childs = new Trie[26];
        }
    }
}