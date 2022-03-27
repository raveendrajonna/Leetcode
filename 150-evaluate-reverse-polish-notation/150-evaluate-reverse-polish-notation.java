class Solution {
    public int evalRPN(String[] tokens) {
        int res=0;
        Stack<Integer> stk = new Stack<>();
        for(String token : tokens)
        {
            if("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token))
            {
                int num2 = stk.pop();
                int num1 = stk.pop();
                if("+".equals(token))
                {
                  stk.push(num1 + num2);
                }
                else if("-".equals(token))
                {
                    stk.push(num1-num2);
                }
                else if("*".equals(token))
                {
                    stk.push(num1*num2);
                }
                else
                {
                    stk.push(num1/num2);
                }
            }
            else
            {
                stk.push( Integer.parseInt(token));
            }
        }
        return stk.pop();
    }
}