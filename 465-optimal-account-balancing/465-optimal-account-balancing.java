class Solution {
    
    public int minTransfers(int[][] transactions) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i< transactions.length; i++)
        {
            hm.put(transactions[i][0] , hm.getOrDefault(transactions[i][0], 0) + transactions[i][2]);
            hm.put(transactions[i][1] , hm.getOrDefault(transactions[i][1], 0) - transactions[i][2]);
        }
        
        int[] bal = new int[hm.size()];
        int idx=0;
        for(int val : hm.values())
        {
            bal[idx++] = val;
        }
        
        return dfs(bal, 0);
    }
    
    public int dfs(int[] bal, int idx)
    {
        if(idx == bal.length)
            return 0;
        
        if(bal[idx] == 0)
            return dfs(bal, idx+1);
        
        int val = Integer.MAX_VALUE;
        for(int i= idx+1; i< bal.length; i++)
        {
            bal[i] = bal[i] + bal[idx];
            val = Math.min(val , 1+ dfs(bal, idx+1));
            bal[i] = bal[i]-bal[idx]; 
        }
        
        return val;
    }
}