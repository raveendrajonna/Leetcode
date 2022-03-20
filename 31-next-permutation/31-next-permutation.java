class Solution {
    public void nextPermutation(int[] nums) {
       // identify index i , where i is grether than i-1 from right
        //swap idx with the smallest number from right.
        //sort the numbers from idx
        //1233333
       int idx = nums.length-1;
       while(idx >0 && nums[idx-1] >= nums[idx])
       {
           idx--;
       }
       // System.out.println(" idx : "+ idx);
       if(idx > 0)
       {
           int k= nums.length-1;
           while(nums[k] <= nums[idx-1])
           {
               k--;
           }
           swap(nums,idx-1,k);
           Arrays.sort(nums,idx,nums.length);
       }
        else
        {
           reverse(nums);
        }
   
    }

    public void reverse(int[] nums)
    {
        int l =0; int r = nums.length-1;
        while(l < r)
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    
    public void swap(int[] nums,int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}