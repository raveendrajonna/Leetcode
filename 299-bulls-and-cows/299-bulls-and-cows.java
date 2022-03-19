class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] cnt = new int[10];
        int cows=0, bulls=0;
        for(int i=0; i<n; i++)
        {
            if(secret.charAt(i) == guess.charAt(i))
            {
                bulls++;
            }
            else
            {
                int s = Character.getNumericValue(secret.charAt(i));
                int g = Character.getNumericValue(guess.charAt(i));
                if(cnt[s] < 0) cows++;
                if(cnt[g]>0 ) cows++;
                
                cnt[s]++;
                cnt[g]--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}