class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n =nums.length;
        for(int num : nums)
        {
            hm.put(num, hm.getOrDefault(num,0)+1);
            if(n/2 < hm.get(num))
                return num;
        }
        return -1;
    }
}
