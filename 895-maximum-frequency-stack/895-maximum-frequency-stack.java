class FreqStack {

    HashMap<Integer,Integer> hmFreq;
    HashMap<Integer, Stack<Integer>> hmStack;
    int maxFreq=0;
    public FreqStack() {
        hmFreq = new HashMap<>();
        hmStack = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = hmFreq.getOrDefault(val,0)+1;
        hmFreq.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);
        hmStack.putIfAbsent(freq, new Stack<>());
        hmStack.get(freq).push(val);
    }
    
    public int pop() {
        int val = hmStack.get(maxFreq).pop();

        if(hmStack.get(maxFreq).size() == 0)
        {
            hmStack.remove(maxFreq);
            maxFreq--;
        }
        if(hmFreq.get(val) == 1)
        {
            hmFreq.remove(val);
        }
        else
        {
            hmFreq.put(val, hmFreq.get(val)-1); 
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