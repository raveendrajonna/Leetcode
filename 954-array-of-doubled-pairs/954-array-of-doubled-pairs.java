class Solution {
    public boolean canReorderDoubled(int[] arr) {
      TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=0; i<arr.length; i++)
        {
            tm.put(arr[i], tm.getOrDefault(arr[i],0)+1);
        }
        
        for(int key : tm.keySet())
        {
            if(tm.get(key) == 0) continue;
            
            int want = key > 0 ? 2*key : key/2;
            
            if(key < 0 && key % 2 != 0) // its negative value, and visited all the doubles, so it would have to update to zero
                return false;
            
            if(tm.get(key) > tm.getOrDefault(want,0))
            {
                return false;
            }
            
            tm.put(want, tm.get(want)-tm.get(key));
        }
        return true;
    }
}