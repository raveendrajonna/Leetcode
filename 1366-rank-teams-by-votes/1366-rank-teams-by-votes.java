class Solution {
    public String rankTeams(String[] votes) {
        int[][] dp = new int[26][26];
        
        int n = votes.length;
        for(String word : votes)
        {
            for(int i=0; i<word.length(); i++)
            {
                dp[word.charAt(i)-'A'][i]++;
            }
        }
        
        char[] ans = votes[0].toCharArray();
        Character[] temp = new Character[ans.length];
        for(int i=0; i<ans.length; i++)
        {
            temp[i] = ans[i];
        }
        
        Arrays.sort(temp, (x, y) ->{
            for(int i=0;i<26; i++)
                if(dp[x-'A'][i] != dp[y-'A'][i]) 
                    return dp[y-'A'][i] - dp[x-'A'][i];
            return x-y;
        });
            
       for(int i=0; i<ans.length; i++)
        {
            ans[i] = temp[i];
        }
        return  new String(ans);
    }
}