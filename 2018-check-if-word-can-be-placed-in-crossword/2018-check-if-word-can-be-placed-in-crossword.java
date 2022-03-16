class Solution {
    int[] ra = new int[] { -1, 0, 1, 0};
    int[] ca = new int[] { 0, 1, 0, -1};
    
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j] ==' ' || board[i][j] == word.charAt(0) )
                {
                    
                    for(int k=0; k<4; k++)
                    {
                        int r = i;
                        int c = j;
                        int idx =0;
                        
                        if(inBoard(board, r-ra[k], c - ca[k]) && board[r-ra[k]][c-ca[k]] != '#')
                            continue;
                        
                        while( idx < word.length() && inBoard(board, r,c) 
                              &&  (board[r][c] == word.charAt(idx) || board[r][c] == ' ') )
                        {
                            idx++;
                            r = r+ra[k];
                            c = c+ca[k];
                        }
                        if(idx == word.length()  && (inBoard(board, r,c) == false || board[r][c] == '#'))
                        {
                            return true;
                        }
                    }
                    
                }
                
            }
        }
        return false;
    }
    
    public boolean inBoard(char[][] board, int r, int c)
    {
        return (r>=0 && r<board.length && c >= 0 && c<board[0].length);
    }
}