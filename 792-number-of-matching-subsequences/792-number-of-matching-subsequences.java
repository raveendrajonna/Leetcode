class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, Queue<String>> hm = new HashMap<>();
        for(int i=0; i<26; i++)
        {
            hm.put((char)('a'+i), new LinkedList<>());
        }
        
        for(String word : words)
        {
            hm.get(word.charAt(0)).add(word);
        }
        
        int res=0;
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            Queue<String> q = hm.get(c);
            int size = q.size();
            while(size > 0)
            {
                size--;
                String cur = q.remove();
                if(cur.length() == 1)
                {
                    res++;
                }
                else
                {
                    hm.get(cur.charAt(1)).add(cur.substring(1));
                }
            }
        }
        return res;
        
    }
}