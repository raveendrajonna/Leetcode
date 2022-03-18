class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int start =0;
        List<String> res = new ArrayList<>();
        while(start < words.length)
        {
            int right = findRight(start, words, maxWidth);
            String line = justify(words, start, right,maxWidth);
            res.add(line);
            start = right+1;
        }
        return res;
    }
    
    public int findRight(int left, String[] words, int maxWidth)
    {
        if(left == words.length) return left;
        
        int sum = words[left++].length();
        while(left < words.length && (sum+1+words[left].length()) <= maxWidth)
        {
            sum = sum+1+words[left].length();
            left++;
        }
        return left-1;
    }
    
    public String justify(String[] words, int left, int right, int maxWidth)
    {
        StringBuilder sb = new StringBuilder();
       if(left == right)
       {
           //single word, So no spaces
           sb.append(words[left]);
           sb.append(getSpace(maxWidth-words[left].length()));
           return sb.toString();
       }
        else if(right == words.length-1)
        {
            //last line, no justification needed
            int sum = getSum(words,left, right);
            int spaceCnt = maxWidth-sum- (right-left);
            sb.append(words[left++]);
            while(left <= right)
            {
                sb.append(" ");
                sb.append(words[left++]);
            }
            
            sb.append(getSpace(spaceCnt));          
            return sb.toString();
        }
        else
        {
            // need to do justification.
            int sum = getSum(words, left, right);
            int cnt = (right-left);
            int spaceCnt = (maxWidth-sum)/cnt;
            int rem = (maxWidth-sum)%cnt;
            String space= getSpace(spaceCnt);
            sb.append(words[left++]);
            while(left <= right)
            {
                sb.append(space);
                sb.append(rem>0?" ":"");
                sb.append(words[left++]);
               
                rem--;
            }
            return sb.toString();
        }
    
    }
    
    public int getSum(String[] words, int left, int right)
    {
        int sum =0;
        for(int i=left; i<=right; i++)
        {
            sum += words[i].length();
        }
        return sum;
    }
    
    public String getSpace(int len)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++)
        {
            sb.append(" ");
        }
        return sb.toString();
    }
}