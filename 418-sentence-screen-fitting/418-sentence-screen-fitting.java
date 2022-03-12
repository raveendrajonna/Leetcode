class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String str = String.join(" ",sentence)+" ";
        int len = str.length();
        int cur=0;
        for(int i=0; i<rows; i++)
        {
            cur = cur+cols;
            while(cur>=0 && str.charAt(cur%len) != ' ')
            {
                cur--;
            }
            
            cur++;
        }
        return cur/len;
    }
}