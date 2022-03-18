class LRUCache {
    
    Node head, tail;
    int capacity;
    HashMap<Integer, Node> hm;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        this.capacity = capacity;
        hm = new HashMap<>();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key))
        {
            Node node = hm.get(key);
            removeNode(node);
            addNodeFirst(node);
            return hm.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.size() == capacity && !hm.containsKey(key))
        {
            
            Node lnode = tail.prev;
            hm.remove(lnode.key);
            removeNode(lnode);
            
            Node node = new Node(key, value);
            addNodeFirst(node);
            hm.put(key, node);   
            //System.out.println("key :" + key +" , removed and inserted" +", lnode :" + lnode.key);
        }
        else if(hm.containsKey(key))
        {
            Node node = hm.get(key);
            node.val = value;
            removeNode(node);
            addNodeFirst(node);
            //hm.put(key, node);
        }
        else
        {
            Node node = new Node(key, value);
            addNodeFirst(node);
            hm.put(key, node);
        }
        
    }
    
    public void addNodeFirst(Node node)
    {
        Node next = head.next;
        
        node.next = next;
        next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public void removeNode(Node node)
    {
        Node prev = node.prev;
        Node next = node.next;
        next.prev = prev;
        prev.next  = next;
    }
    
    class Node
    {
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int value)
        {
            this.key = key;
            this.val = value;
            next = null;
            prev = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */