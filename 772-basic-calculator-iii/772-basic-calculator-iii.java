class Solution {
    HashSet<Character> hs = new HashSet<>();
    public int calculate(String s) {
        hs.add('+');
        hs.add('-');
        hs.add('*');
        hs.add('/');
        int[] idx = new int[1];
        idx[0] = 0;
        return eval(s,idx);   
    }
    
    public int eval(String s, int[] index)
    {
        Stack<Integer> stk = new Stack<>();
        int num=0;
        char operator='+';
        while(index[0] < s.length())
        {
            if(Character.isDigit(s.charAt(index[0])))
            {
                num = num*10+ s.charAt(index[0])-'0';
                index[0]++;
            }
            else if( hs.contains(s.charAt(index[0])))
            {
                handleOperator(operator, num, stk);
                operator = s.charAt(index[0]);
                num=0;
                index[0]++;
            }
            else if(s.charAt(index[0]) == '(')
            {
                index[0]++;
                
                num = eval(s,index);
                //System.out.println(" num :"+ num);
                //stk.push(num);
            }
            else if(s.charAt(index[0]) == ')')
            {
               handleOperator(operator, num, stk);
               index[0]++;
               int sum=0;
               while(stk.size() > 0)
               {
                  sum = sum+stk.pop();  
               }
                return sum;
            }
            
        }
        handleOperator(operator,num, stk); 
        
        int sum =0;
        //System.out.println(" ***** " + stk.size());
        while(stk.size() > 0)
        {
            sum = sum + stk.pop();
           // System.out.println(" res :" + sum);
        }
        return sum;
    }
    
    public void  handleOperator(char operator, int num,Stack<Integer> stk)
    {
        switch(operator)
        {
            case '+':
                stk.push(num);
                break;
            case '-':
                stk.push(num*-1);
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