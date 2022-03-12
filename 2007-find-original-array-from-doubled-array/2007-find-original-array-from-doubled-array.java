class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2 == 1)
            return new int[0];
        
        
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        for(int i=0; i<n; i++)
        {
            hm.put(changed[i], hm.getOrDefault(changed[i],0)+1);
        }
        int[] res = new int[n/2];
        int idx=0;
        
        for(int x : hm.keySet())
        {
            if(hm.getOrDefault(x,0) > hm.getOrDefault(x+x,0))
            {
                return new int[0];
            }

            for(int i=0 ;i<hm.get(x); i++)
            {

                res[idx++] = x;
                hm.put(x+x, hm.get(x+x)-1);
            }
        }
        return res;
    }
}