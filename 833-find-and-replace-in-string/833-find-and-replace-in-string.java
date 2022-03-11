class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<Integer,String> hms = new HashMap<>();
        HashMap<Integer, String> hmt = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->(y-x));
        
        for(int i=0; i<sources.length; i++)
        {
           pq.add(indices[i]);
           hms.put(indices[i], sources[i]);
           hmt.put(indices[i], targets[i]);
        }
        
        while(pq.size() > 0)
        {
            int cur = pq.remove();
            String sub = s.substring(cur);
            if(sub.startsWith(hms.get(cur)))
            {
                s = s.substring(0,cur)+hmt.get(cur)+s.substring(cur+hms.get(cur).length());
            }
        }
        return s;
    }
}