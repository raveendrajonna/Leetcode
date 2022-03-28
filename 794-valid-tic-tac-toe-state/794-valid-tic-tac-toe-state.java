class Solution {

    public boolean validTicTacToe(String[] board) {
        int xcnt = getCount(board, 'X');
        int ocnt = getCount(board, 'O');
        
        if(ocnt > xcnt)
            return false;
        
        if( (xcnt-ocnt) > 1)
            return false;
        
        if(xcnt > ocnt)
        {
            //last turn is x
            if(wins(board, 'O'))
            {
              return false;  
            }
        }
        else
        {
            if(wins(board, 'X'))
            {
                return false;
            }
            
        }
        
        return true;
    }
    
    public int getCount(String[] board, char c)
    {
        int cnt =0;
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(board[i].charAt(j) == c)
                    cnt++;
            }
        }
        return cnt;
    }
    
    public boolean wins(String[] board, char c)
    {
        if(verifyRows(board, c) || verifyCols(board, c) || verifyDiagonal(board, c))
        {
            return true;
        }
        
        return false;
    }
    
    public boolean verifyRows(String[] board, char c)
    {
        for(int i=0; i <3; i++)
        {
            if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c)
                return true;
        }
        return false;
    }
    
    public boolean verifyCols(String[] board, char c)
    {
        for(int i=0; i<3; i++)
        {
            if(board[0].charAt(i) == c && board[1].charAt(i)  ==c && board[2].charAt(i)  == c)
                return true;
        }
        return false;
    }
    
    public boolean verifyDiagonal(String[] board, char c)
    {
        if(board[0].charAt(0)  == c && board[1].charAt(1)  == c && board[2].charAt(2)  == c)
            return true;
        
        if(board[0].charAt(2) == c && board[1].charAt(1)  == c && board[2].charAt(0)  == c)
            return true;
        
        return false;
    }
}