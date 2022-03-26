class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UF uf = new UF(n);
        uf.union(0, firstPerson);
        
        TreeMap<Integer,HashSet<Integer>> tm = new TreeMap<>();
        for(int i=0; i<meetings.length; i++)
        {
            tm.putIfAbsent(meetings[i][2], new HashSet<>());
            tm.get(meetings[i][2]).add(i);
        }
        
        for(int time : tm.keySet())
        {
           HashSet<Integer> hs = new HashSet<>();
            for(int idx : tm.get(time))
            {
                int x = meetings[idx][0];
                int y = meetings[idx][1];
                
                hs.add(x);
                hs.add(y);
                uf.union(x,y);
            }
            
            for(int x : hs)
            {
                if(!uf.isConnected(0, x))
                {
                    uf.reset(x);
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            if(uf.isConnected(0, i))
            {
                res.add(i);
            }
        }
        return res;
    }
    
    public class UF
    {
        int[] parent ;
        
        public UF(int n)
        {
            parent = new int[n];
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
        }
        
        public int find(int x)
        {
            if(x != parent[x])
                parent[x] = find(parent[x]);
            
            return parent[x];
        }
        
        public void union(int x, int y)
        {
            int px = find(x);
            int py = find(y);
            
            if(px < py)
                parent[py] = px;
            else
                parent[px] = py;
        }
        
        public boolean isConnected(int x, int y)
        {
            int px = find(x);
            int py = find(y);
            
            return px == py;
        }
        
        public void reset(int x)
        {
            parent[x] = x;
        }
    }
}