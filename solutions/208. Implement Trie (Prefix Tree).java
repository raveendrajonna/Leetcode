class Trie {
​
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++)
        {
            if(temp.childs[word.charAt(i)-'a'] == null)
            {
                temp.childs[word.charAt(i)-'a'] = new Node();
            }
            temp = temp.childs[word.charAt(i)-'a'];
        }
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++)
        {
            temp = temp.childs[word.charAt(i)-'a'];
            if(temp == null)
                return false;
        }
        
        if(temp!= null && temp.isEnd)
            return true;
        
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i=0; i<prefix.length(); i++)
        {
            temp = temp.childs[prefix.charAt(i)-'a'];
            if(temp == null)
                return false;
        }
        
        if(temp!= null)
            return true;
        
        return false;
    }
    
    class Node
    {
        Node[] childs;
        boolean isEnd;
        
        public Node()
        {
            childs = new Node[26];
            isEnd = false;
        }
    }
}
​
/**
