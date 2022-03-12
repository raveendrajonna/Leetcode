class WordFilter {

    Node root;
    public WordFilter(String[] words) {
       root = new Node();
       for(int i=0; i<words.length; i++)
       {
          String word = words[i];
          int len = word.length();
           word = word+"{"+word;
          for(int j=0 ; j < len; j++)
          {
              insert(word.substring(j),i);
              System.out.println("inserted :" + word.substring(j));
          }
       }
    }
    
    public void insert(String word,int idx)
    {
        Node temp = root;
        for(int i=0; i<word.length(); i++)
        {
            if(temp.child[word.charAt(i)-'a'] == null)
            {
                temp.child[word.charAt(i)-'a'] = new Node();
            }
            temp.child[word.charAt(i)-'a'].idx = idx;
            temp = temp.child[word.charAt(i)-'a'];
        }
    }
    
    public int f(String prefix, String suffix) {
        String word = suffix+"{"+prefix;
        Node temp = root;
        for(int i=0; i<  word.length(); i++)
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
            idx=0;
            child = new Node[27];
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */