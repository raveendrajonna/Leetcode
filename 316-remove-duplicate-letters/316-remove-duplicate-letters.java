class Solution {
    public String removeDuplicateLetters(String s) {
        int[] res = new int[26];
        for(char c : s.toCharArray())
        {
            res[c-'a']++;
        }
        
        int idx=0;
        Stack<Integer> stk = new Stack<>();
        boolean[] visited = new boolean[26];
        for(char c : s.toCharArray())
        {
            idx = c-'a';
           res[idx]--;
           if(visited[idx])
               continue;
           
            
           while(stk.size() >0 && (stk.peek() > idx) && res[stk.peek()]!= 0)
           {
               int peek = stk.pop();
               visited[peek] = false;
           }
           stk.push(idx); 
           visited[idx] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(stk.size() > 0)
        {
            sb.insert(0, (char) ('a' + stk.pop()));
        }
        return sb.toString();
    }
}