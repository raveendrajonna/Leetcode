class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            int want = target-nums[i];
            if(hm.containsKey(want))
            {
                return new int[] { hm.get(want), i};
            }
            hm.put(nums[i], i);
        }
        
        return new int[0];
    }
}