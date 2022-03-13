class Solution {
    HashMap<String,Integer> hmEmailToId;
    HashMap<String,String> hmEmailToName;
    DS ds;
    int id=0;
    HashMap<Integer, List<String>> hmIdToEmails;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        hmEmailToId = new HashMap<>();
        hmEmailToName = new HashMap<>();
        ds = new DS();
        hmIdToEmails = new HashMap<>();
        
        for(List<String> account : accounts)
        {
            String name = account.get(0);
            
            for(int i=1; i<account.size(); i++)
            {
                if(!hmEmailToName.containsKey(account.get(i)))
                  hmEmailToName.put(account.get(i) , name);
                
                if(!hmEmailToId.containsKey(account.get(i)))
                {
                    hmEmailToId.put(account.get(i), id);
                    id++;
                }
                
                ds.merge(hmEmailToId.get(account.get(1)) , hmEmailToId.get(account.get(i)));
            }
        }
        
        for(String email : hmEmailToId.keySet())
        {
            int idx = ds.find(hmEmailToId.get(email));
            if(!hmIdToEmails.containsKey(idx))
            {
                hmIdToEmails.put(idx, new ArrayList<>());
            }
            hmIdToEmails.get(idx).add(email);
        }
        
        for(List<String> lst : hmIdToEmails.values())
        {
            Collections.sort(lst);
            lst.add(0, hmEmailToName.get(lst.get(0)));
        }
        
        return new ArrayList(hmIdToEmails.values());
        
        
    }
    
    class DS
    {
        int[] parent;
        
        public DS()
        {
            parent = new int[10001];
            for(int i=0; i<10001; i++)
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