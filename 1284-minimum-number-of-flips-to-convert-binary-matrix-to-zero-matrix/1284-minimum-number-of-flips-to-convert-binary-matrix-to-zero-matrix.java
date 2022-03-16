class Solution {
    public int minFlips(int[][] mat) {
        Node node = new Node(mat,0);
        Queue<Node> q = new LinkedList<>();
        if(node.isDone()) return 0;
        
        q.add(node);
        int ans =  Integer.MAX_VALUE;
        HashSet<String> hs = new HashSet<>();
        hs.add(node.toString());
        while(q.size() > 0)
        {
            Node cur = q.remove();
            //System.out.println(" **** cur :" + cur.toString() +", isDone :"+ cur.isDone());
            if(cur.isDone()) 
            {
                return cur.step;
            }
            
            
            
            for(int i=0; i<node.rows; i++)
            {
                for(int j=0; j< node.cols; j++)
                {
                    Node newNode = cur.flip(i, j);
                    if(!hs.contains(newNode.toString()))
                    {
                       //System.out.println(newNode.toString()+", step :" + newNode.step +", isDone :"+ newNode.isDone());
                        hs.add(newNode.toString());
                        q.add(newNode);
                    }
                }
            }
        }
        return -1;
        
    }
    
    class Node
    {
        int[][] mat;
        int rows;
        int cols;
        int step;
        
        public Node(int[][] mat, int step)
        {
            this.step = step;
            this.mat = mat;
            this.rows = mat.length;
            this.cols = mat[0].length;
        }
        
        public Node flip(int r, int c)
        {
            int[][] na = new int[rows][cols];
            for(int i=0; i<rows; i++)
            {
                for(int j=0; j<cols; j++)
                {
                    na[i][j] = mat[i][j];
                    if( (i==r-1 && j == c)  
                       || (i== r && j== c-1) || (i == r && j == c) || (i ==r && j == c+1)
                       || (i == r+1 && j == c))
                    {
                        na[i][j] = 1 - na[i][j];
                    }
                }
            }
            return new Node(na, step+1);
        }
        
        private boolean isDone()
        {
            for(int i=0; i<rows; i++)
            {
                for(int j=0; j<cols; j++)
                {
                    if(mat[i][j] == 1)
                    {
                        return false;
                    }
                }
            }
            //System.out.println(" true :" + mat.toString());
            return true;
        }
        

        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<rows; i++)
            {
                for(int j=0; j<cols; j++)
                {
                    sb.append(mat[i][j]);
                }
            }
            return sb.toString();
        }
    }
}