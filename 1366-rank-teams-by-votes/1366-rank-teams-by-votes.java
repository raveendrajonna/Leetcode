class Solution {
    public String rankTeams(String[] votes) {
        int[][] dp = new int[26][26];
        
        for(String word : votes)
        {
            for(int i=0; i<word.length(); i++)
            {
                dp[word.charAt(i)-'A'][i]++;
            }
        }
        
        char[] ans = votes[0].toCharArray();
        Character[] tmp = new Character[ans.length];
        for (int i = 0; i < ans.length; i++) tmp[i] = ans[i];
        Arrays.sort(tmp, (t1, t2)->{
            for(int i=0; i<26; i++)
               if(dp[t1-'A'][i] != dp[t2-'A'][i])
                   return dp[t2-'A'][i] - dp[t1-'A'][i];
             return t1-t2;
        });
        
        for (int i = 0; i < ans.length; i++) ans[i] = tmp[i];
        
        return new String(ans);
    }
}