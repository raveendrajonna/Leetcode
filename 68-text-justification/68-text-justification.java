class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left=0;
        List<String> res = new ArrayList<>();
        while(left<words.length)
        {
            int right = fidnRight(left, words, maxWidth);
            String line = justify(left, right, words, maxWidth);
            res.add(line);
            left = right+1;
        }
        return res;
    }
    
    public String justify(int left, int right, String[] words, int maxWidth)
    {
        StringBuilder sb = new StringBuilder();
        if(left == right)
        {
            //only one word.
            String res = words[left];
            int cnt = (maxWidth - res.length());
            res = res+getSpace(cnt);
            return res;
        }
        else if(right == words.length-1)
        {
            //last line, no extra pads
            int sum =  findSum(left, right, words);   
            int noOfSpaces = (right-left);
            int cnt = (maxWidth - sum-noOfSpaces);
            for(int i=left; i<right; i++)
            {
                sb.append(words[i]);
                sb.append(getSpace(1));
            }
            sb.append(words[right]);
            sb.append(getSpace(cnt));
            return sb.toString();
        }
        else
        {
            int sum =  findSum(left, right, words);   
            int noOfSpaces = (right-left);
            int cnt = (maxWidth - sum)/noOfSpaces;
            int rem = (maxWidth - sum) % noOfSpaces;
            
            for(int i=left; i<right; i++)
            {
                sb.append(words[i]);
                sb.append(getSpace(cnt));
                sb.append(getSpace(rem>0?1:0));
                rem--;
            }
            sb.append(words[right]);
            return sb.toString();
        }
    }
    
    public int fidnRight(int left, String[] words, int maxWidth)
    {
        if(left == words.length)
            return left;
        int len = words[left++].length();
        while(left < words.length && (len+words[left].length()+1) <= maxWidth)
        {
            len = len+words[left].length()+1;
            left++;
        }
        return left-1;
    }

    public int findSum(int left, int right, String[] words)
    {
        int sum =0;
        for(int i=left; i<=right; i++)
        {
            sum = sum+words[i].length();
        }
        return sum;
    }

    public String getSpace(int cnt)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cnt; i++)
        {
            sb.append(" ");
        }
        return sb.toString();
    }

}