class Solution {
    TreeMap<Integer,HashSet<Integer>> tm;
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        tm = new TreeMap<>();
        UF uf = new UF(n);
        uf.union(0,firstPerson);
        
        for(int i=0; i<meetings.length; i++)
        {
            tm.putIfAbsent(meetings[i][2],new HashSet<>());
            tm.get(meetings[i][2]).add(i);
        }
        
        for( int key : tm.keySet())
        {
            HashSet<Integer> pool = new HashSet<>();
            for(int cur : tm.get(key))
            {
                int x = meetings[cur][0];
                int y = meetings[cur][1];
                uf.union(x,y);
                pool.add(x);
                pool.add(y);
            }
            
            for(int x : pool)
            {
               // System.out.println( "x :" + x +", parent  : " + uf.find(x));
                if(!uf.isConnected(0, x))
                {
                   uf.parent[x] = x;  
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=0 ; i<n; i++)
        {
            //System.out.println( "x :" + i +", parent  : " + uf.find(i));
            if(uf.find(i)== 0)
            {
                res.add(i);
            }
        }
        return res;
    }
    
    public class UF
    {
        int[] parent;
        
        public UF(int n)
        {
           parent = new int[n];
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
        }
        
        public boolean isConnected(int x, int y)
        {
            int px = find(x);
            int py = find(y);
            return px == py;
        }
        
        public void union(int x, int y)
        {
            int px = find(x);
            int py = find(y);
            if(px == py)
                return;
            
            if(px < py)
            {
                parent[py] = px;
            }
            else
            {
                parent[px] = py;
            }                 
        }
        
        public int find(int x)
        {
            if(x != parent[x])
                return find(parent[x]);
            
            return x;
        }        
    }
}