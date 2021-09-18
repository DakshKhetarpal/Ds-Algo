package Graph;

//Finds the size of largest island in graph
public class LargestIslandInGraph {

    static final int ROW = 5, COL = 5;
    int maxSize=0;

    public static void main(String[] args){

        int M[][] = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };

        //making object because countIslands is not static function
        LargestIslandInGraph I = new LargestIslandInGraph();
        System.out.println("Number of islands is: " + I.countIslands(M));

    }

    // A function to check if a given cell (row, col) can
    // be included in DFS
    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    void DFS(int M[][], int row, int col, boolean visited[][],int size)
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        // we are considering diagonal also here
        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

        // Mark this cell as visited
        visited[row][col] = true;
        System.out.println("size is "+size);
        if(size>maxSize) maxSize=size;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
                DFS(M, row + rowNbr[k], col + colNbr[k], visited,++size);
    }

    int countIslands(int M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    //cells once visited for an island will not be visited again
                    int size=0;
                    DFS(M, i, j, visited,++size);
                    ++count;
                    System.out.println("maxSize is "+maxSize);
                }

        return count;
    }
}
