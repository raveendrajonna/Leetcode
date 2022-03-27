class Solution {
    public boolean canTransform(String start, String end) {
       int i=0, j=0; 
        int n = start.length();
       while(i <n && j<n)
       {
          while(i<n && start.charAt(i) == 'X')
          {
              i++;
          }

           while(j < n && end.charAt(j) == 'X')
           {
               j++;
           }
           
           if(i <n && j < n && start.charAt(i) != end.charAt(j))
           {
               return false; 
           }
           else if( i <n && j < n && start.charAt(i) =='L' && i < j )
           {
               return false;
           }
           else if(i<n && j <n && start.charAt(i) =='R' && i > j)
           {
               return false;
           }
           i++;
           j++;
       }
        
        while(i <n && start.charAt(i) =='X' )
            i++;
        
        while(j <n && end.charAt(j) == 'X')
            j++;
       // System.out.println(" i :"+ i +", j : "+ j);
        return i==j;
    }
}