class Solution {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int num : nums)
        {
            max = Math.max(max, num);
            sum = sum+num;
        }
        
        int l = max;
        int r = sum;
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            int cnt = findNoOfParts(nums, mid);
            if(cnt < m)
            {
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }
        return l;
    }
    
    public int findNoOfParts(int[] nums, int limit)
    {
        int sum =0;
        int cnt =0;
        for(int num : nums)
        {
            if(sum+num <= limit)
            {
                sum = sum+num;
            }
            else
            {
                sum = num;
                cnt++;
            }
        }
        return cnt;
    }
}