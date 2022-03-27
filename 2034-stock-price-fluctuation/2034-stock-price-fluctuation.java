class StockPrice {

   TreeMap<Integer,Integer> record;
    TreeMap<Integer,HashSet<Integer>> tm;
    public StockPrice() {
        tm = new TreeMap<>();
        record = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        Integer key = record.get(timestamp);
        if(key != null)
        {
            int prevVal = record.get(timestamp);
            HashSet<Integer> hs = tm.get(prevVal);
            hs.remove(timestamp);
            if(hs.size() == 0)
            {
                tm.remove(prevVal);
            }
        }
        
        record.put(timestamp, price);
        if(tm.get(price) == null)
        {
            tm.put(price, new HashSet<>());
        }
        tm.get(price).add(timestamp);
    }
    
    public int current() {
       return record.lastEntry().getValue();
    }
    
    public int maximum() {
        return tm.lastKey();
    }
    
    public int minimum() {
        return tm.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */