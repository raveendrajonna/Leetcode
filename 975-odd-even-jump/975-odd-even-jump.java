class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        boolean[] low = new boolean[n];
        boolean[] high = new boolean[n];
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        
        low[n-1] = true;
        high[n-1] = true;
        tm.put(arr[n-1], n-1);
        int res =1;
        for(int i= n-2; i>=0 ; i--)
        {
           Integer h = tm.ceilingKey(arr[i]);
           Integer l = tm.floorKey(arr[i]);
            
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