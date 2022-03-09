class Solution {
​
    int[] arr;
    Random random;
    public Solution(int[] nums) {
        random = new Random();
        this.arr = nums;
    }
    
    public int[] reset() {
      return arr;  
    }
    
    public int[] shuffle() {
       int[] temp = arr.clone();
        for(int i=1; i<arr.length; i++)
        {
            int j = random.nextInt(i+1);
            swap(temp,i,j);
        }
        return temp;
    }
    
    public void swap(int[] a, int i , int j)
    {
        int temp =a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
