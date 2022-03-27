class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2 != 0)
            return new int[0];
        
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=0; i<changed.length; i++)
        {
            tm.put(changed[i], tm.getOrDefault(changed[i],0)+1);
        }
        
        int[] res = new int[n/2];
        int idx=0;
        
        for(int i : tm.keySet())
        {
            if(tm.get(i) > tm.getOrDefault(i+i,0))
            {
                return new int[0];
            }
            
            for(int k=0; k<tm.get(i) ; k++)
            {
                res[idx++] = i;
                tm.put(i+i, tm.getOrDefault(i+i, 0)-1);
            }
        }
        return res;
    }
}