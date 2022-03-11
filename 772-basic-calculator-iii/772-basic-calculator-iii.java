class Solution {
    
    public int calculate(String s) {
       int[] idx =new int[]{0};
       return eval(s, idx);
    }
    
    public int eval(String s, int[] idx)
    {
       char operator ='+';
       int num = 0;
        Stack<Integer> stk = new Stack<>();
       while(idx[0] < s.length())
       {
          char c =  s.charAt(idx[0]); 
          if(Character.isDigit(c))
          {
              num = num*10 + (s.charAt(idx[0])-'0');
              idx[0]++;
          }
          else if(c == '(')
          {
              idx[0]++;
              num = eval(s, idx);
          }
          else if(c == '+' || c == '-' || c == '*' || c == '/')
          {
              handleOpr(operator, num, stk);
              operator = c;
              num =0;
              idx[0]++;
          }
          else if(c == ')')
          {
              handleOpr(operator,num, stk); 
              num =0;
              int sum =0;
              while(stk.size() > 0)
              {
                  sum = sum+stk.pop();
              }
              idx[0]++;
              return sum;
          }

       }
       handleOpr(operator, num, stk); 
       int sum =0;
       while(stk.size() > 0)
       {
          sum = sum+stk.pop();
          // System.out.println(" su :"+ sum);
       }
       return sum;
    }
    
    public void handleOpr(char operator, int num, Stack<Integer> stk)
    {
        switch(operator)
        {
            case '+':
                stk.push(num);
                break;
            case '-':
                stk.push(-1*num);
                break;
            case '*':
                stk.push(stk.pop()*num);
                break;
            case '/':
                stk.push(stk.pop()/num);
                break;
        }
    }
}