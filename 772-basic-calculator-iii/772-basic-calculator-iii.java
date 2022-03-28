class Solution {
    public int calculate(String s) {
        int[] idx = new int[1];
        idx[0] = 0;
        return eval(s, idx);
    }
    
    public int eval(String s, int[] idx)
    {
        int num =0;
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        char op ='+';
        
        while(idx[0] < s.length())
        {
            char c = s.charAt(idx[0]);
            
            if(Character.isDigit(c))
            {
                num = num*10 + c-'0';
                idx[0]++;
            }
            else if(c=='(')
            {
                idx[0]++;
                num = eval(s,idx);
               // System.out.println(" eval :"+ num +" idx : " + idx[0]);
            }
            else if(c ==')')
            {
                handle(stk, num, op);
                int sum =0;
                while(stk.size() > 0)
                {
                  sum = sum + stk.pop();
                }
                idx[0]++;
                return sum;
            }
            else
            {
               // System.out.println(stk +", ****  idx :" + idx[0]);
                handle(stk, num, op);
                op = s.charAt(idx[0]);
                idx[0]++;
                num =0;
            }
        }
        handle(stk, num, op);
        int sum =0;
        while(stk.size() > 0)
        {
            System.out.println(stk.peek());
            sum = sum+stk.pop();
        }
        return sum;
    }
    
    public void handle(Stack<Integer> stk, int num, char c)
    {
        if(c=='+')
        {
            stk.push(num);
        }
        else if(c == '-')
        {
            stk.push( -1 * num);
        }
        else if(c == '*')
        {
            int num1 = stk.pop();
            stk.push(num1*num);
        }
        else{
            int num1 = stk.pop();
            stk.push(num1/num);
        }
         //System.out.println(" num :" + num +", c : "+ c + " stk : " + stk);
    }
}