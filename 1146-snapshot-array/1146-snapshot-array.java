class SnapshotArray {

    TreeMap<Integer,Integer> tm[];
    int snapshot;
    public SnapshotArray(int length) {
        snapshot=0;
        tm = new TreeMap[length];
        for(int i=0; i<length; i++)
        {
           tm[i] = new TreeMap<>();
           tm[i].put(snapshot, 0);
        }
    }
    
    public void set(int index, int val) {
        tm[index].put(snapshot, val);
    }
    
    public int snap() {
       snapshot++;
       return snapshot-1;
    }
    
    public int get(int index, int snap_id) {
      return  tm[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */