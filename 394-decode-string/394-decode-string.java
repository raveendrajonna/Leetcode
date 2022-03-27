class Solution {
    public String decodeString(String s) {
        Stack<Integer> stkNum = new Stack<>();
        Stack<StringBuilder> stkStr = new Stack<>();
        
        int num =0;
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray())
        {
            if(Character.isDigit(c))
            {
                num = num*10 + (c-'0');
                
            }
            else if(c == '[')
            {
                stkNum.push(num);
                num=0;
                stkStr.push(sb);
                sb = new StringBuilder();
            }
            else if(c == ']')
            {
                StringBuilder temp = stkStr.pop();
                int val = stkNum.pop();
                while(val > 0)
                {
                    temp.append(sb.toString());
                    val--;
                }
                sb = temp;
            }
            else
            {
                sb.append(c);
            }
        }
        
       return sb.toString(); 
    }
}