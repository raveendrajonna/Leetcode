class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int res=0;
        for(String s : input.split("\n"))
        {
            int level = s.lastIndexOf("\t")+1;
            while(stk.size() > level+1)
            {
                stk.pop();
            }
            
            int curLen =  stk.peek()+s.length()-level+1;
            stk.push(curLen);
            if(s.contains("."))
                res = Math.max(res, curLen-1);
        }
        return res;
    }
}