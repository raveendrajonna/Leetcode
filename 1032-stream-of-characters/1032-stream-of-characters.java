class StreamChecker {

    Trie root;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        root = new Trie();
        sb = new StringBuilder();
        for(String word : words)
        {
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return search(sb.toString());
    }
    
    public void insert(String word)
    {
        Trie temp = root;
        for(int i= word.length()-1; i>=0; i--)
        {
            char c = word.charAt(i);
            if(temp.childs[c-'a'] == null)
            {
                temp.childs[c-'a'] = new Trie();
            }
            temp = temp.childs[c-'a'];
        }
        temp.isEnd =true;
    }
    
    public boolean search(String word)
    {
        Trie temp = root;
        for(int i= word.length()-1; i>=0 && temp != null; i--)
        {
            char c = word.charAt(i);

            temp = temp.childs[c-'a'];
            if(temp != null && temp.isEnd)
            {
                return true;
            }
        }
        return false;
    }
    
    class Trie
    {
        boolean isEnd;
        Trie[] childs;
        
        public Trie()
        {
            isEnd = false;
            childs = new Trie[26];
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */