class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (x,y)->(x.length()-y.length()));
        HashMap<String, Integer> hm = new HashMap<>();
        int res =0;
        for(String word : words)
        {
            int cnt =1;
            for(int i=0; i<word.length(); i++)
            {
                String temp = word.substring(0,i) + word.substring(i+1);
                
                if(hm.containsKey(temp))
                {
                    int tcnt = hm.get(temp)+1;
                    cnt = Math.max(cnt, tcnt);
                }
            }
            hm.put(word,cnt);
            res = Math.max(res,cnt);
        }
        return res;
    }
}