class Solution {
    public String decodeString(String s) {
        Stack<Integer> stkCnt = new Stack<>();
        int n=0;
        StringBuilder cur = new StringBuilder();
        Stack<StringBuilder> stkStr = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(Character.isDigit(c))
            {
              n = (n*10)+(c-'0');
            }
            else if(c=='[')
            {
                stkCnt.push(n);
                n=0;
                stkStr.push(cur);
                cur = new StringBuilder();
            }
            else if(c == ']')
            {
                StringBuilder temp = stkStr.pop();
                for(int i=stkCnt.pop(); i>0; i--)
                {
                    temp.append(cur);
                }
                cur = temp;
            }
            else
            {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}