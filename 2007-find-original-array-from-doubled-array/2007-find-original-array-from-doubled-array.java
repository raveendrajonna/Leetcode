class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        int[] res = new int[n/2];
        if(n%2 != 0)
            return new int[0];
        
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=0; i<n; i++)
        {
            tm.put(changed[i], tm.getOrDefault(changed[i],0)+1);
        }
        
        int idx=0;
        for(int i : tm.keySet())
        {
            if(tm.get(i) > tm.getOrDefault(i+i,0))
            {
                return new int[0];
            }
            
            for(int k=0; k<tm.get(i); k++)
            {
                res[idx++] = i;
                tm.put(i+i, tm.get(i+i) -1);
            }
        }
        return res;
    }
}