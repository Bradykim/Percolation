public class PercolationUF implements IPercolate
{
    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private final int VTOP;
    private final int VBOTTOM;
    private int myOpenCount;

    public PercolationUF(IUnionFind finder, int size)
    {
        myGrid = new boolean[size][size];
        finder.initialize(size*size+2);
        myFinder=finder;
        VTOP = size*size;
        VBOTTOM = size*size+1;
        myOpenCount= 0;
    }

    @Override
    public void open(int row, int col) {
        if(!inBounds(row,col))
        {
            throw new IndexOutOfBoundsException(String.format("(%d,%d",row,col));
        }
        myGrid[row][col]= true;
        myOpenCount++;
        int single = row*myGrid.length+col;

        if(row ==0)
        {
            myFinder.union(VTOP,single);
        }
        if(row == myGrid.length-1)
        {
            myFinder.union(single,VBOTTOM);
        }
        if(isOpen(row,col))
        {
            if(inBounds(row-1,col) && isOpen(row-1,col))
            {
                int singles = (row-1)*myGrid.length+col;

                myFinder.union(single,singles);
            }
            if(inBounds(row+1,col) && isOpen(row+1,col))
            {
                int singles = (row+1)*myGrid.length+col;

                myFinder.union(single,singles);
            }
            if(inBounds(row,col-1) && isOpen(row,col-1))
            {
                int singles = row*myGrid.length+col-1;

                myFinder.union(single,singles);
            }
            if(inBounds(row,col+1) && isOpen(row,col+1))
            {
                int singles = row*myGrid.length+col+1;

                myFinder.union(single,singles);
            }
        }

    }


    @Override
    public boolean isOpen(int row, int col) {
        if(!inBounds(row,col))
        {
            throw new IndexOutOfBoundsException(String.format("(%d,%d",row,col));
        }
        return myGrid[row][col];
    }

    @Override
    public boolean isFull(int row, int col) {
        if(!inBounds(row,col))
        {
            throw new IndexOutOfBoundsException(String.format("(%d,%d",row,col));
        }
        int single = row*myGrid.length+col;
        return myFinder.connected(single,VTOP);
    }

    @Override
    public boolean percolates() {
        if(myFinder.connected(VBOTTOM,VTOP))
        {
            return true;
        }
        return false;
    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }
    public boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }
}
