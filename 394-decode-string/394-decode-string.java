class Solution {
    public String decodeString(String s) {
        Stack<Integer> stk = new Stack<>();
        Stack<StringBuilder> stkStr = new Stack<>();
        int num=0;
        StringBuilder cur = new StringBuilder();
        int n = s.length();
        for(int i=0; i<n; i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                num = num*10 + s.charAt(i)-'0';
            }
            else if(s.charAt(i) == '[')
            {
                stk.push(num);
                num =0;
                stkStr.push(cur);
                cur = new StringBuilder();
            }
            else if(s.charAt(i)== ']')
            {
                StringBuilder sb = stkStr.pop();
                int tn = stk.pop();
                while(tn>0)
                {
                    sb.append(cur.toString());
                    tn--;
                }
                cur = sb;
            }
            else
            {
                cur.append(s.charAt(i));
            }
        }
        return cur.toString();
        
    }
}