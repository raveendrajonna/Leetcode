class Solution {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new int[]{0,1});
        visited.add("0-1");
        int dis =0;
        while(q.size() > 0)
        {
            int size = q.size();
            while(size >0)
            {
                size--;
                int[] cur = q.remove();
                if(cur[0] == target)
                    return dis;
                
                //A
                int pos = cur[0];
                int speed = cur[1];
                
                int newPos = pos+speed;
                int newSpeed = 2*speed;
                if( !visited.contains(newPos+"-"+newSpeed) && Math.abs(target-newPos) < target) 
                {
                    visited.add(newPos+"-"+newSpeed);
                    q.add(new int[] { newPos, newSpeed});
                }
                
                //if R
                 newPos = pos;
                 newSpeed = speed > 0 ? -1: 1;
                if(!visited.contains(newPos+"-"+newSpeed) && Math.abs(target-newPos) < target)
                {
                     visited.add(newPos+"-"+newSpeed);
                     q.add(new int[]{ newPos, newSpeed});
                }
            }
            dis++;
        }
        return dis;
        
    }
}