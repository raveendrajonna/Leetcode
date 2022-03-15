class Solution {
    public boolean canTransform(String start, String end) {
      int i=0;
      int j=0;
        
     int n = start.length();
        while(i < n && j < n)
        {
            while(j<n && end.charAt(j) == 'X')
               j++;
            
            while(i<n && start.charAt(i) =='X')
                i++;
            
            if(i == n || j ==n)
                break;
            
            if(i<n && j<n && start.charAt(i) == end.charAt(j))
            {
                if(end.charAt(j) == 'L' && i < j )
                    return false;
                
                if(end.charAt(j) == 'R' && i > j)
                    return false;
                
                i++;
                j++;
            }
            else
            {
                return false;
            }
        }
        while(i<n && start.charAt(i) == 'X')
            i++;
        
        while(j<n && end.charAt(j) == 'X')
            j++;
        
        System.out.println(" i : " + i +", j : " + j );
        if(i==n && j == n)
            return true;
        return false;
    }
}