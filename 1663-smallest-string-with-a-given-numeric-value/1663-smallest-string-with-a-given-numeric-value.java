class Solution {
    public String getSmallestString(int n, int k) {
        int[] arr = new int[n];
        HashMap<Integer, Character> hm = new HashMap<>();
        for(int i=0; i< 26; i++)
        {
           hm.put(i, (char) ('a'+i) ); 
        }
        
        int temp = n-1;
        k = k-n;
        while(k > 0 )
        {
            arr[temp] = Math.min(25, k);
            k = k-Math.min(k,25);
            temp--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
        {
           sb.append(hm.get(arr[i])); 
        }
        return sb.toString();
    }
}