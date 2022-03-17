class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> hs = new HashSet<>();
        for(String word : startWords)
        {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            hs.add(new String(ch));
        }
        int cnt=0;
        //System.out.println(" hs :" + hs);
        for(String word : targetWords)
        {
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            word = new String(ch);
            for(int i=0; i<word.length(); i++)
            {
                String newWord = word.substring(0,i) + word.substring(i+1);
                //System.out.println(newWord);
                if(hs.contains(newWord))
                {
                   cnt++; 
                    break;
                }
            }
        }
        return cnt;
    }
}