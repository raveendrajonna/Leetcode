class Solution {
    HashMap<String,String> hmEmailToName;
    HashMap<String,Integer> hmEmailToId;
    int id=0;
    DS ds;
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        ds = new DS();
        hmEmailToId = new HashMap<>();
        hmEmailToName = new HashMap<>();
        for(List<String> account : accounts)
        {
            String name = account.get(0);
            for(int i=1; i<account.size(); i++)
            {
                if(!hmEmailToId.containsKey(account.get(i)))
                {
                    hmEmailToId.put(account.get(i), id);
                    id++;
                }
                hmEmailToName.put(account.get(i), name);
                ds.merge(hmEmailToId.get(account.get(1)), hmEmailToId.get(account.get(i)));
            }
        }
        
        HashMap<Integer, List<String>> res = new HashMap<>();
        for(String email : hmEmailToId.keySet())
        {
            int idx =  ds.find(hmEmailToId.get(email));
            if(!res.containsKey(idx))
                res.put(idx, new ArrayList<>() );
            
            res.get(idx).add(email);
        }
        
        List<List<String>> fr = new ArrayList<>(res.values());
        for(List<String> r : fr)
        {
            Collections.sort(r);
            r.add(0, hmEmailToName.get(r.get(0)));
        }
        
        
        
        return fr;
        
    
    }
    
    class DS
    {
        int[] parent;
        
        public DS()
        {
            parent = new int[10000];
            for(int i=0; i< 10000; i++)
            {
                parent[i] = i;
            }
        }
        
        public void merge(int x, int y)
        {
            parent[find(x)] = find(y);
        }
        
        public int find(int x)
        {
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            
            return parent[x];
        }
    }
}