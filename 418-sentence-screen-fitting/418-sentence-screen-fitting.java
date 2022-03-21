class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String str = String.join(" ", sentence)+" ";
        int len = str.length();
        int start=0;
        for(int i=0; i<rows; i++)
        {
            start = start+cols;
            while(start>=0 && str.charAt(start%len) != ' ')
            {
                start--;
            }
            start++;
        }
        return start/len;
        
    }
}