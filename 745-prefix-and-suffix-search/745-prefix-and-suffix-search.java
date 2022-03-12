class WordFilter {
    Node root;
    
    public WordFilter(String[] words) {
       root = new Node();
        for(int i=0; i<words.length; i++)
        {
            String word= words[i];
            int len = word.length();
            word = word+"{"+word;
            for(int j=0; j<len; j++)
            {
                insert(word.substring(j), i);
            }
        }
    }
    
    public void insert(String word, int idx)
    {
        Node temp = root;
        for(int i=0; i<word.length(); i++)
        {
            if(temp.child[word.charAt(i)-'a'] == null)
                temp.child[word.charAt(i)-'a'] = new Node();
            
            temp = temp.child[word.charAt(i)-'a'];
            temp.idx = idx;
        }
    }
    
    public int f(String prefix, String suffix) {
       Node temp = root;
        String word = suffix+"{"+prefix;
        for(int i=0; i<word.length(); i++)
        {
            if(temp.child[word.charAt(i)-'a'] == null)
            {
                return -1;
            }
            temp = temp.child[word.charAt(i)-'a'];
        }
        return temp.idx;
    }
    
    class Node
    {
        Node[] child;
        int idx;
        public Node()
        {
            child = new Node[27];
            idx =0;
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */