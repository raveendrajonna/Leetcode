                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(rz)
        {
            for(int i=0; i<m; i++)
            {
                matrix[i][0] =0;
            }
        }
        
        if(cz)
        {
            for(int i=0; i<n; i++)
            {
                matrix[0][i] = 0;
            }
        }
    }
}
