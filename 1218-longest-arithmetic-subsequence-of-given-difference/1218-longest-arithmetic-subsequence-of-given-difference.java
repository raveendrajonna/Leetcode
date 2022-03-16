class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] res = new int[arr.length];
        Arrays.fill(res, 1);
        int ans = 1;
        for(int i=0; i< arr.length; i++)
        {
            int want = arr[i]-difference;
            if(hm.containsKey(want))
            {
                res[i] = res[hm.get(want)]+1;
                ans = Math.max(ans, res[i]);
            }
            hm.put(arr[i], i);
        }
        return ans;
    }
}