class Solution {
    public String rankTeams(String[] votes) {
        int[][] cnt = new int[26][26];
        
        for(String word : votes)
        {
            for(int i=0; i<word.length(); i++)
            {
                cnt[word.charAt(i)-'A'][i]++;
            }
        }
        
        char[] ans =  votes[0].toCharArray();
        Character[] temp = new Character[ans.length];
        for(int i=0; i<ans.length; i++)
        {
            temp[i] = ans[i];
        }
        
        Arrays.sort(temp, (x,y)->{
           for(int i=0; i<26; i++)
           {
               if(cnt[x-'A'][i] != cnt[y-'A'][i])
               {
                   return cnt[y-'A'][i] - cnt[x-'A'][i];
               }
           }
           return x-y;
        });
        
        for(int i=0; i<ans.length; i++)
        {
            ans[i] = temp[i];
        }
        
        return new String(ans);
    }
}