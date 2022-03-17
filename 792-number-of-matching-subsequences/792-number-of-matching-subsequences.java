class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, Queue<String>> hm = new HashMap<>();
        int res=0;
        for(int i=0; i < 26; i++)
        {
            hm.put( (char) ('a'+i), new LinkedList<>());
        }
        
        for(String word : words)
        {
            hm.get(word.charAt(0)).add(word);
        }
        
        for(char c : s.toCharArray())
        {
            Queue<String> q = hm.get(c);
            int size = q.size();
            while(size > 0)
            {
                size--;  
                String entry = q.remove();
                if(entry.length() == 1)
                {
                    res++;
                }
                else
                {
                    hm.get(entry.charAt(1)).add(entry.substring(1));
                }          
            }
        }
        return res;
    }
}