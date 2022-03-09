class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String,Integer>hm = new HashMap<>();
        Arrays.sort(words, (x,y)->(x.length()-y.length()));
        int res=0;
        for(String word : words)
        {
            int best =0;
            for(int i=0; i<word.length(); i++)
            {
                String prev = word.substring(0,i)+ word.substring(i+1);
                best = Math.max(best, hm.getOrDefault(prev,0)+1);
            }
            hm.put(word,best);
            res = Math.max(best, res);
        }
        return res;
    }
}