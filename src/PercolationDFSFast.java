import java.util.Arrays;

public class PercolationDFSFast extends PercolationDFS
{
   
    public PercolationDFSFast(int n)
    {
        super(n);
    }


    @Override
    protected void updateOnOpen(int row, int col) {
        if(row==0)
        {
            dfs(row, col);
        }

        else if(inBounds(row,col+1)&&myGrid[row][col+1]==FULL)
        {
            dfs(row, col);
        }
        else if(inBounds(row,col-1)&&myGrid[row][col-1]==FULL)
        {
            dfs(row,col);
        }
        else if( inBounds(row+1,col) && myGrid[row+1][col] ==FULL)
        {
            dfs(row,col);
        }
        else if(inBounds(row-1,col) && myGrid[row-1][col]==FULL){
            dfs(row,col);
        }






    }


}
