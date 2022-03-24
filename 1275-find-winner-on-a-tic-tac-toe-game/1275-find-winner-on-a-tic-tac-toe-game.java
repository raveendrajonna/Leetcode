class Solution {
    public String tictactoe(int[][] moves) {
        
        char[][] arr = new char[3][3];
        char turn ='A';
        for(int i=0; i<moves.length; i++)
        {
            int[] cur = moves[i];
            arr[cur[0]][cur[1]] = turn;
            turn = turn=='A'?'B':'A';
        }
        System.out.println( Arrays.toString(arr[0]));
        System.out.println( Arrays.toString(arr[1]));
        System.out.println( Arrays.toString(arr[2]));
        
        if(wins(arr, 'A'))
            return "A";
        
        if(wins(arr, 'B'))
            return "B";
        
        int aCnt = count(arr,'A');
        int bCnt = count(arr, 'B');
        
        if(aCnt + bCnt == 9)
            return "Draw";
        else
            return "Pending";
        
    }
    
    
    public boolean wins(char[][] arr, char c)
    {
        if(verifyRow(arr,c))
            return true;
        
        if(verifyColumn(arr, c))
             return true;
        
        if(verifyDiagonal(arr,c))
            return true;
        
        return false;
    }
    
    public boolean verifyRow(char[][] arr, char c)
    {
        for(int i=0; i<3; i++)
        {
        
            if(arr[i][0] ==c && arr[i][1] == c && arr[i][2] ==c)
                return true;
        }
        return false;
    }
    
    public boolean verifyColumn(char[][] arr, char c)
    {
        for(int i=0; i<3; i++)
        {
           if(arr[0][i] == c && arr[1][i] == c && arr[2][i] == c)
               return true;
        }
        return false;
    }
    
    public boolean verifyDiagonal(char[][] arr, char c)
    {
        if(arr[0][0] == c && arr[1][1] == c && arr[2][2] == c)
            return true;
        
        if(arr[2][0] == c && arr[1][1] == c && arr[0][2] == c)
            return true;
        
        return false;
    }
    
    public int count(char[][] arr, char c)
    {
        int cnt =0;
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(arr[i][j] == c)
                    cnt++;
            }
        }
        return cnt;
    }
}

/*
 A B A
 A B B
 A A B

*/