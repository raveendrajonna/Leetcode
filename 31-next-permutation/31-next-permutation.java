class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = n-1;
        while(idx>0 && nums[idx-1] >= nums[idx])
        {
            idx--;
        }
        if(idx == 0)
        {
            reverse(nums);
            return;
        }
        
        int k = n-1;
        while(idx < k && nums[k] <= nums[idx-1])
        {
            k--;
        }
        swap(nums, idx-1, k);
        Arrays.sort(nums,idx,n);
        
        
    }
    
    public void reverse(int[] nums)
    {
        int l =0, r = nums.length-1;
        while(l < r)
        {
            swap(nums,l, r);
            l++;
            r--;
        }
    }
    
    public void swap(int[] nums, int i , int j)
    {
        int temp =nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}