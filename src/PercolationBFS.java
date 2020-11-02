import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast
{
    public PercolationBFS(int n)
    {
        super(n);
    }
    @Override
    protected void dfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        myGrid[row][col] = FULL;
        q.add(new int[]{row,col});
        while(q.size()!=0)
        {
            int[] array = q.remove();
            int row1= array[0];
            int col1= array[1];
            if(inBounds(row1-1,col1) && isOpen(row1-1,col1) && !isFull(row1-1,col1))
            {
                myGrid[row1-1][col1] = FULL;
                q.add(new int[]{row1-1,col1});

            }
            if(inBounds(row1+1,col1) && isOpen(row1+1,col1) && !isFull(row1+1,col1))
            {
                myGrid[row1+1][col1] = FULL;
                q.add(new int[]{row1+1,col1});
            }
            if(inBounds(row1,col1+1) && isOpen(row1,col1+1) && !isFull(row1,col1+1))
            {
                myGrid[row1][col1+1] = FULL;
                q.add(new int[]{row1,col1+1});
            }
            if(inBounds(row1,col1-1) && isOpen(row1,col1-1) && !isFull(row1,col1-1))
            {
                myGrid[row1][col1-1] = FULL;
                q.add(new int[]{row1,col1-1});
            }

            
        }
    }
}
