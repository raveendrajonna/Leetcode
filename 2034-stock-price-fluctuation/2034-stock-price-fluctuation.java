class StockPrice {

    TreeMap<Integer,Integer> record;
    TreeMap<Integer,HashSet<Integer>> vals;
    
    public StockPrice() {
        vals = new TreeMap<>();
        record = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(record.containsKey(timestamp))
        {
            int prevVal = record.get(timestamp);
            HashSet<Integer>  book = vals.get(prevVal);
            book.remove(timestamp);
            if(book.isEmpty())
            {
                vals.remove(prevVal);
            }
        }
        record.put(timestamp, price);
        vals.put(price, vals.getOrDefault(price, new HashSet<>()));
        vals.get(price).add(timestamp);
    }
    
    public int current() {
      return record.lastEntry().getValue();
    }
    
    public int maximum() {
      return vals.lastKey();  
    }
    
    public int minimum() {
     return vals.firstKey();  
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