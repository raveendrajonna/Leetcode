class Solution {
    TreeMap<Integer,Integer> tm;
    Random random;
    int sum;
    public Solution(int[] w) {
        random = new Random();
        tm = new TreeMap<>();
        sum=0;
        for(int i=0; i<w.length; i++)
        {
            sum = sum+w[i];
            tm.put(sum, i);
        }
    }
    
    public int pickIndex() {
        int idx = random.nextInt(sum)+1;
        return tm.ceilingEntry(idx).getValue();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */