class Solution {
    Node root;
    int rows,cols;
    int[] ra = new int[]  {-1, 0, 1, 0};
    int[] ca = new int[] {0,  1, 0, -1};
    List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
      root = new Node();  
        res = new ArrayList<>();
        for(String word : words)
        {
            insert(word);
        }
        
        rows = board.length;
        cols = board[0].length;        
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                dfs(board,i,j, root);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board, int r, int c,Node root)
    {
        char ch = board[r][c];
        if(ch == '#' || root.next[ch-'a'] == null )
        {
            return;
        }
        
