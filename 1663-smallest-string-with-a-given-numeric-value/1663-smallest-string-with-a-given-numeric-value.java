class Solution {
    public String getSmallestString(int n, int k) {
        int[] arr = new int[k];
        int idx = n-1;
        int temp = k-n;
        while(temp > 0)
        {
            arr[idx] = Math.min(25, temp);
            temp = temp - Math.min(25,temp);
            idx--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
        {
            sb.append((char) ('a'+arr[i]) );
        }
        return sb.toString();
    }
}