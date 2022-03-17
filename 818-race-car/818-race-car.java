class Solution {
    public int racecar(int target) {
        HashSet<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 1});
        visited.add("0-1");
        int distance=0;
        
        while(q.size() > 0)
        {
            int size = q.size();
            while(size > 0)
            {
                size--;
                int[] cur = q.remove();
                
                if(target == cur[0])
                    return distance;
                
                //A
                int newPos = cur[0]+cur[1]; //curpos+cur speed
                int newSpeed = 2 * cur[1];
                
                if( !visited.contains(newPos+"-"+newSpeed) && Math.abs(newPos-target) < target)
                {
                    q.add(new int[] {newPos, newSpeed} );
                    visited.add(newPos+"-"+newSpeed);
                } 
                
                //R
                newPos = cur[0];
                newSpeed = cur[1]>0?-1:1;
                
               if( !visited.contains(newPos+"-"+newSpeed) && Math.abs(newPos-target) < target)
                {
                     q.add(new int[] {newPos, newSpeed} );
                    visited.add(newPos+"-"+newSpeed);
                } 
            }
            distance++;
        }
        
        return -1;
    }
}