        if(idx== word.length() && root != null && root.isEnd)
            return true;
        
        if(idx == word.length() || root == null)
            return false;
        
        if(word.charAt(idx) != '.')
        {
            return util(word, idx+1,root.childs[word.charAt(idx)-'a']);
        }
        else
        {
            for(int i=0; i<26; i++)
            {
                if(root.childs[i] != null)
                {
                    boolean val = util(word, idx+1, root.childs[i]);
                    if(val)
                        return true;
                }
            }
            return false;
        }
    }
    
    
    class Node
    {
        Node[] childs = new Node[26];
        boolean isEnd = false;
        
        public Node()
        {
            childs = new Node[26];
            isEnd = false;
        }
    }
}
​
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
