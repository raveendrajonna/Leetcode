class Solution {
    DS ds = new DS();
    HashMap<String,Integer> hmEmailToId;
    HashMap<String,String> hmEmailToName;
    HashMap<Integer,String> hmIdToName;
    HashMap<Integer, List<String>> hmIdToAccounts;
    int id=0;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
       ds = new DS();
        hmEmailToId = new HashMap<>();
        hmEmailToName= new HashMap<>();
        hmIdToName = new HashMap<>();
        hmIdToAccounts = new HashMap<>();
        
        for(List<String> account : accounts)
        {
            String name = account.get(0);
            for(int i=1; i<account.size(); i++)
            {
                String email = account.get(i);
                String firstEmail = account.get(1);
                
                if(!hmEmailToId.containsKey(email))
                {
                    hmEmailToId.put(email, id);
                    hmIdToName.put(id, name);
                    id++;
                }
                
                hmEmailToName.put(email, name);
                ds.merge(hmEmailToId.get(account.get(1)), hmEmailToId.get(account.get(i)));
            }
        }
        
        for(String email : hmEmailToId.keySet())
        {
            int idx = ds.find(hmEmailToId.get(email));
            if(!hmIdToAccounts.containsKey(idx))
            {
                hmIdToAccounts.put(idx, new ArrayList<>());
            }
            hmIdToAccounts.get(idx).add(email);
        }
        
        for(int id: hmIdToAccounts.keySet())
        {
            //Collections.sort(hmIdToAccounts.get(id));
            List<String>  account = hmIdToAccounts.get(id);
            Collections.sort(account);
            account.add(0,  hmIdToName.get(id));
        }
        
        return new ArrayList(hmIdToAccounts.values());
    }
    
    class DS
    {
        int[] parent;
        
        public DS()
        {
            parent = new int[10000];
            for(int i=0; i<10000; i++)
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
            if(x != parent[x])
                parent[x] = find(parent[x]);
            
            return parent[x];
        }
    }
}