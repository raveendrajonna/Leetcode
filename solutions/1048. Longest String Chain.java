class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (x,y)->(x.length() - y.length()));
        HashMap<String,Integer> hm = new HashMap<>();
        int res=0;
        for(String word : words)
        {
            int best =0;
            for(int i=0; i < word.length(); i++)
            {
                String prev = word.substring(0,i)+ word.substring(i+1);
                best = Math.max(best, hm.getOrDefault(prev,0)+1);
            }
            hm.put(word, best);
            res = Math.max(res,best);
        }
        return res;
    }
}
