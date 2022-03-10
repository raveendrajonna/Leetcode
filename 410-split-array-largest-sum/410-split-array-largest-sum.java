class Solution {
    public int splitArray(int[] nums, int m) {
        int sum=0, max =0;
        for(int i=0; i<nums.length; i++)
        {
            sum = sum+nums[i];
            max = Math.max(max, nums[i]);
        }
        
        int l=max;
        int r= sum;
        
        while(l<r)
        {
            int mid = l +(r-l)/2;
            int cnt = findPeople(nums, mid);
            if(cnt > m)
            {
                l = mid+1;
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
        int cnt=1, sum =0;
        for(int i=0; i<arr.length; i++)
        {
           if(sum+arr[i] <= val)
           {
              sum += arr[i]; 
           }
            else
            {
                cnt++;
                sum =arr[i];
            }
        }
        return cnt;
    }
}