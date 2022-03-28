class Solution {
    public boolean search(int[] nums, int target) {
        return util(0, nums.length-1, target, nums);
    }
    
    public boolean util(int l, int r, int target, int[] nums)
    {
        if(l > r)
            return false;
        
        int m = l +(r-l)/2;
        
        if(nums[m] == target)
            return true;
        
        boolean res= false;
        
        if(m>0 && nums[l] <= nums[m-1] )
        {
            if(nums[l] <= target && target <= nums[m-1])
             res = util(l,m-1, target, nums);
            else
             res = util(m+1, r, target, nums);
        }
        
        if(!res && m<r && nums[m+1] <= nums[r])
        {
            if(nums[m+1] <= target && target <= nums[r])
            {
                res = util(m+1, r, target, nums);
            }
            else
            {
                res = util(l, m-1, target, nums);
            }
            
        }
        return res;
        
    }
}