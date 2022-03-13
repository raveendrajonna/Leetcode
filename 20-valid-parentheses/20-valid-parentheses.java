class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c=='(' || c=='{' || c == '[')
            {
                stk.push(c);
            }
            else
            {
                if(stk.size() == 0) return false;
                
                char peek = stk.pop();
                if( peek =='(' && c ==')' || peek == '{' && c == '}' || peek == '[' && c == ']')
                {
                    continue;
                }
                
                return false;
            }
        }
        
        if(stk.size() == 0)
            return true;
        
        return false;
    }
}