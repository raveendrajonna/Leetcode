class Solution {
    public boolean validTicTacToe(String[] board) {
       int nx = getCount(board,'X');
       int no = getCount(board,'O');
     
        if(no > nx) 
          return false;
        
        if( (nx-no) > 1) return false;
        
         System.out.println(" nx :" + nx +", no :"+ no);
        
 
        
       if( (nx-no)  > 0 && wins(board, 'O'))
           return false;
    
       if(nx == no && wins(board, 'X'))
           return false;
           
       return true;
        
    }
    
    public int getCount(String[] board, char c)
    {
        int cnt=0;
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(board[i].charAt(j) == c)
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public boolean wins(String[] board, char c)
    {
        if( validateRow(board, c) || validateColumns(board, c) || validateDiagonals(board, c))
            return true;
        return false;
    }
    
    public boolean validateRow(String[] board, char c)
    {
        for(int i=0; i<3; i++)
        {
            if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c)  
                return true;
        }
        return false;
    }
    
    public boolean validateColumns(String[] board, char c)
    {
        for(int i=0; i<3; i++)
        {
            if(board[0].charAt(i)== c && board[1].charAt(i)==c && board[2].charAt(i) == c)
                return true;
        }
        
        return false;
    }
    
    public boolean validateDiagonals(String[] board, char c)
    {
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if(board[2].charAt(0) == c && board[1].charAt(1) == c && board[0].charAt(2)== c) return true;
        return false;
    }
}