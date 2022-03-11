/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        int cnt =0;
        for(int i=0; i<10 && cnt <6 && wordlist.length > 0; i++)
        {
            int idx = random.nextInt(wordlist.length);
            String word = wordlist[idx];
            cnt = master.guess(word);
            if(cnt == 6)
                return;
            
            List<String> lst = new ArrayList<>();
            for(int j=0; j<wordlist.length; j++)
            {
                if( match(word, wordlist[j]) == cnt)
                {
                    lst.add(wordlist[j]);
                }
            }
            wordlist = lst.toArray(new String[lst.size()]);
        }
    }
    
    public int match(String word1, String word2)
    {
        int match =0; 
        for(int i=0; i<6; i++)
        {
           if(word1.charAt(i) == word2.charAt(i))
           {
               match++;
           }
        }
        return match;
    }
}