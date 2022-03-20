class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        int i=1;
        while(i<n)
        {
            int idx = A[i]-1;
            if(A[i]>0 && A[i]<=n && A[idx] != A[i])
            {
                
                swap(A,i,idx);
            }
            else
            {
                i++;
            }
        }
        System.out.println(" sorted : " + Arrays.toString(A));
        i =0;
        while(i<n && A[i] == i+1)
        {
            i++;
        }
        return i+1;
        
    }
    public void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}