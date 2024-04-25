public class TetrisGrid {
    private boolean[][] grid;
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }
    public boolean[][] getGrid() {
        return grid;
    }
    void clearRows() {
        for (int i=0; i<grid.length; i++) {
            int cnt=0;
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == true)
                    cnt++;
            }
            if (cnt == grid[i].length) {
                for (int j=0; j<grid[i].length; j++)
                    grid[i][j] = false;

                for (int k=i; k>0; k--) {
                    boolean[] c = grid[k];
                    grid[k] = grid[k-1];
                    grid[k-1] = c;
                }
            }
        }
    }
}
