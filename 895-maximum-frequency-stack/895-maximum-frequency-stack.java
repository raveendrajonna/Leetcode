class FreqStack {

    HashMap<Integer, Integer> hmFreq;
    HashMap<Integer, Stack<Integer>> hmStack;
    int maxFreq = 0;
    public FreqStack() {
        hmFreq = new HashMap<>();
        hmStack = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = hmFreq.getOrDefault(val,0)+1;
        hmStack.putIfAbsent(freq, new Stack<>());
        hmFreq.put(val, freq);
        hmStack.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        
        int val = hmStack.get(maxFreq).pop();
        if(hmStack.get(maxFreq).size()  == 0)
        {
            hmStack.remove(maxFreq);
            maxFreq--;   
        }
        
        int freq = hmFreq.get(val);
        if(freq > 1)
            hmFreq.put(val, freq-1);
        else
        {
            hmFreq.remove(val);       
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */