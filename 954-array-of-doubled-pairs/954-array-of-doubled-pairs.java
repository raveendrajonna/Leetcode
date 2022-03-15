class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i=0; i<arr.length; i++)
        {
            tm.put(arr[i], tm.getOrDefault(arr[i],0)+1);
        }
        
        for(int key : tm.keySet())
        {
            int want = key>0 ? 2 *key : key/2;
            
            if(tm.get(key) == 0) continue;
            
            //System.out.println("key/%2 " + (key%2));
            if(key < 0 && (key%2) != 0)
                return false;
            
            if(tm.get(key) > tm.getOrDefault(want,0))
                return false;
            
            tm.put(want, tm.get(want)- tm.get(key));
        }
        return true;
    }
}