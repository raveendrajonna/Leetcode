class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        Node[] nodes = new Node[n];
        for(int i=0; i<n; i++)
        {
           Node nd = new Node(indices[i], sources[i], targets[i]);
            nodes[i] = nd;
        }
        Arrays.sort(nodes, (x,y)-> (y.idx - x.idx));
        
        for(int i=0; i<n; i++)
        {
            Node nd = nodes[i];
            int len = nd.source.length();
           // if(s.substring(nd.idx, nd.idx+len+1).equals(nd.source))
            if(s.substring(nd.idx).startsWith(nd.source))
            {
                s = s.substring(0,nd.idx)+ nd.dest + s.substring(nd.idx+len);
            }
        }
        return s;
    }
    
    class Node
    {
        int idx;
        String source;
        String dest;
        
        public Node(int idx, String src, String dest)
        {
            this.idx = idx;
            this.source = src;
            this.dest = dest;
        }
        
       /* @Override
        public int compareTo(Node other)
        {
            return other.idx - this.idx;
        } */
    }
}