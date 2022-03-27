class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<String>> hm = new HashMap<>();
        for(String word : words)
        {
            hm.putIfAbsent(word.charAt(0), new ArrayList<>());
            hm.get(word.charAt(0)).add(word);
        }
        
        int res=0;
        for(char c : s.toCharArray())
        {
            List<String> hs  = hm.get(c);
            if(hs == null )
                continue;
           hm.put(c, new ArrayList<>());
            
            
            
            for(String word : hs)
            {
                if(word.length() == 1)
                {
                    res++;
                }
                else
                {
                    String newWord = word.substring(1);
                    hm.putIfAbsent(newWord.charAt(0), new ArrayList<>());
                    hm.get(newWord.charAt(0)).add(newWord);
                }
            }
        }
        return res;
    }
    

}