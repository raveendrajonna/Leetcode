class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        List<Node> lst = new ArrayList<>();
        for(int i=0; i<indices.length; i++)
        {
            Node node = new Node();
            node.index = indices[i];
            node.source = sources[i];
            node.target = targets[i];
            lst.add(node);
            
        }
        
        Collections.sort(lst, (x,y)-> (y.index - x.index));
        
        for(int i=0; i<lst.size(); i++)
        {
            Node node = lst.get(i);
            int idx = s.indexOf(node.source);
            
            if(s.substring(node.index).startsWith(node.source))
            {
               s = s.substring(0,node.index)+ node.target + s.substring(node.index+node.source.length()); 
            }
        }
        
        return s;
        
    }
    
    class Node
    {
        int index;
        String source;
        String target;
        
        public String toString()
        {
            return index+","+ source+","+ target;
        }
    }
}