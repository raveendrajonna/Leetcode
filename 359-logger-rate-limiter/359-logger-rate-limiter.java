class Logger {

    HashMap<String,Integer> hm;
    public Logger() {
      hm = new HashMap<>();  
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
      if(hm.getOrDefault(message,0) <= timestamp)  
      {
          hm.put(message, timestamp+10);
          return true;
      }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */