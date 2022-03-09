class Solution {
​
    TreeMap<Integer,Integer> tm;
    int sum;
    Random rand = new Random();
    public Solution(int[] w) {
        tm = new TreeMap<>();
        sum =0;
        for(int i=0; i<w.length; i++)
        {
            sum = sum + w[i];
            tm.put(sum,i);
        }
    }
    
    public int pickIndex() {
       int num = rand.nextInt(sum)+1;
       return tm.ceilingEntry(num).getValue();
    }
}
​
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
