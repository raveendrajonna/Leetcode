class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stk = new Stack<>();
        for(char c : s.toCharArray())
        {
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
            res = res.substring(0, idx)+ res.substring(idx+1);
        }
        return res;
    }
}
