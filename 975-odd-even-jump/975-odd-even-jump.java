class Solution {
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int n = arr.length;
        boolean[] high = new boolean[n];
        boolean[] low = new boolean[n];
        
        high[n-1] = true;
        low[n-1] = true;
        int res =1;
        tm.put(arr[n-1], n-1);
        for(int i=n-2; i>= 0; i--)
        {
            Integer h = tm.ceilingKey(arr[i]);
            Integer l  = tm.floorKey(arr[i]);
            
            if(h != null && low[tm.get(h)])
                high[i] = true;
            
            if(l != null && high[tm.get(l)])
                low[i] = true;
            
            if(high[i])
                res++;
            
            tm.put(arr[i], i);
        }
        
        return res;
    }
}