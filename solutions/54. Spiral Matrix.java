               res.add(matrix[t][i]); 
            }
            t++;
            
            //last column top to bot
            for(int i=t; i<=b; i++)
            {
                res.add(matrix[i][r]);
            }
            r--;
            
            if(t>b)
                break;
            
            //Last row , right to left
            for(int i=r; i>=l; i--)
            {
                res.add(matrix[b][i]);
            }
            b--;
            
            
            if(l>r)
                break;
            
            //bot to up
            for(int i=b; i>=t; i--)
            {
                res.add(matrix[i][l]);
            }
            l++;
            
        }
        return res;
    }
}
