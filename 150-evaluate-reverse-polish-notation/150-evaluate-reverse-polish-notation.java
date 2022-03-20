class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stk = new Stack<>();
        for(String token : tokens)
        {
            if("+".equals(token) ||
              "-".equals(token) || 
               "*".equals(token) ||
               "/".equals(token))
            {
                int n2 = stk.pop();
                int n1 = stk.pop();
                stk.push(handle(n1, n2, token.charAt(0)));
            }
            else
            {
                 stk.push(Integer.parseInt(token));
            }
        }
        
        int res=0;
        while(stk.size() > 0)
        {
            res = res + stk.pop();
        }
        return res;
    }
    
    public int handle(int n1, int n2, char c)
    {
        if(c == '+')
        {
            return n1+n2;
        }
        else if(c == '-')
        {
            return n1-n2;
        }
        else if(c == '*')
        {
            return n1*n2;
        }
        else
        {
            return n1/n2;
        }
        
    }
}