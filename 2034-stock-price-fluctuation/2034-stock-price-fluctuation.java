class StockPrice {

    TreeMap<Integer,HashSet<Integer>> tm;
    TreeMap<Integer,Integer> record;
    public StockPrice() {
       record = new TreeMap<>();
       tm = new TreeMap<>();
       
    }
    
    public void update(int timestamp, int price) {
       if(record.containsKey(timestamp))
       {
           HashSet<Integer> hs = tm.get(record.get(timestamp));
           hs.remove(timestamp);
           if(hs.size() == 0)
           {
               tm.remove(record.get(timestamp));
           }
       }
        
        record.put(timestamp,price);
        if(!tm.containsKey(price))
        {
           tm.put(price,new HashSet<>());
        }
        tm.get(price).add(timestamp);
    }
    
    public int current() {
      return record.lastEntry().getValue(); 
    }
    
    public int maximum() {
      return tm.lastEntry().getKey(); 
    }
    
    public int minimum() {
      return tm.firstEntry().getKey();  
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