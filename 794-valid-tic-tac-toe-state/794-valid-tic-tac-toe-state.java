class Solution {
    public boolean validTicTacToe(String[] board) {
        
        int xcnt = count(board,'X');
        int ocnt = count(board, 'O');
        
        if(ocnt > xcnt )
            return false;
        
        if((xcnt-ocnt) > 1)
            return false;
        
        if(ocnt == xcnt && wins(board,'X'))
        {
            return false;
        }
        else if(ocnt < xcnt && wins(board, 'O'))
        {
            return false;
        }
        return true;
    }
    
    public int count(String[] board, char c)
    {
        int cnt =0;
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length(); j++)
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
        if(checkRow(board,c)) 
            return true;
        if(checkCol(board,c))
            return true;
        if(checkDiagonal(board,c))
            return true;
        
        return false;
    }
    
    public boolean checkRow(String[] board, char c)
    {
        for(int i=0; i<3; i++)
        {
             if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c)
                 return true;
        }
        return false;
    }
    
    public boolean checkCol(String[] board, char c)
    {
        for(int i=0; i<3; i++)
        {
            if(board[0].charAt(i) == c && board[1].charAt(i) ==c && board[2].charAt(i) == c)
                return true;
        }
        return false;
    }
    
    public boolean checkDiagonal(String[] board, char c)
    {
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) ==c)
            return true;
        if(board[0].charAt(2) == c && board[1].charAt(1) ==c && board[2].charAt(0) == c)
            return true;
        return false;
    }
    
    
}