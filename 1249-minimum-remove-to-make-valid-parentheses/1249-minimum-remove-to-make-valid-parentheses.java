class Solution {
    public String minRemoveToMakeValid(String s) {
       Stack<Integer> stk = new Stack<>();
       StringBuilder sb = new StringBuilder();
       for(int i=0; i< s.length(); i++)
       {
           char c = s.charAt(i);
           if(c == '(')
           {
               stk.push(sb.length());
               sb.append(c);
           }
           else if(c == ')')
           {
               if(stk.size() > 0)
               {
                   stk.pop();
                   sb.append(c);
               }
               
           }
           else 
           {
               sb.append(c);
           }
       }
       
       String res = sb.toString();
        while(stk.size() > 0)
        {
            int idx = stk.pop();
            res = res.substring(0,idx)+ res.substring(idx+1);
        }
        return res;
    }
}