class Solution {
    public int splitArray(int[] nums, int m) {
       int sum =0;
       int max=0;
       for(int i=0; i<nums.length; i++)
       {
           sum = sum+nums[i];
           max = Math.max(max, nums[i]);
       }
       int l=max;
       int r=sum;
        System.out.println(" l :"+l +", r:"+ r);
       while(l<r)
       {
           
           int mid = l+(r-l)/2;
           int cnt = findPeople(nums,mid);
           //System.out.println(" l :"+l +", r:"+ r + ", cnt :" + cnt);
           if(cnt>m)
           {
               l =mid+1;
           }
           else
           {
               r = mid;
           }
       }
        
       return r;
        
    }
    
    public int findPeople(int[] arr, int val)
    {
        int sum =0;
        int cnt=1;
        for(int i=0; i<arr.length; i++)
        {
            if(sum+arr[i] <= val)
            {
                sum = sum+arr[i];
            }
            else
            {
                sum = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}