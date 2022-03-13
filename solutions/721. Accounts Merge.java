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
            Collections.sort(hmIdToAccounts.get(id));
            List<String>  account = hmIdToAccounts.get(id);
            Collections.sort(account);
            account.add(0,  hmIdToName.get(id));
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
