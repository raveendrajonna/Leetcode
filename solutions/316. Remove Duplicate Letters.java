class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for(char c : s.toCharArray())
            cnt[c-'a']++;
        
        boolean[] visited = new boolean[26];
        Stack<Integer> stk = new Stack<>();
        int idx;
        for(char c : s.toCharArray())
        {
            idx = c-'a';
            cnt[idx]--;
            if(visited[idx] == true)
                continue;
            while(stk.size() > 0 && stk.peek() > idx && cnt[stk.peek()] > 0)
            {
                int pop = stk.pop();
                visited[pop] = false;
            }
            
            stk.push(idx);
            visited[idx] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while(stk.size() > 0)
        {
            sb.insert(0, (char)('a'+stk.pop()));
        }
        
        return sb.toString();
    }
}
