class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans=0;
        for(int item : arr)
        {
           hm.put(item, hm.getOrDefault(item-difference,0)+1);
           ans = Math.max(ans, hm.get(item));
        }
        return ans;
    }
}