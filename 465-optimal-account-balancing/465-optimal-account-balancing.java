class Solution {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int[] transaction : transactions)
        {
            hm.put(transaction[0], hm.getOrDefault(transaction[0],0)+ transaction[2]);
            hm.put(transaction[1], hm.getOrDefault(transaction[1],0)- transaction[2]);
        }
        
        int[] res = new int[hm.size()];
        int idx=0;
        for(int key : hm.keySet())
        {
            res[idx++] = hm.get(key);
        }
        
        return dfs(0, res);
    }
    
    public int dfs(int idx, int[] res)
    {
       // System.out.println(Arrays.toString(res));
        if(idx == res.length) return 0;
        
        if(res[idx] == 0)
            return dfs(idx+1, res);
        
        int ans = Integer.MAX_VALUE;
        
        for(int i= idx+1; i<res.length; i++)
        {
            res[i] += res[idx];
            ans = Math.min(ans , 1+dfs(idx+1, res));
            res[i] -= res[idx];
        }
        return ans;
    }
}