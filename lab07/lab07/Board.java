import java.util.ArrayList;
import java.util.Random;

public class Board {

    //  Instance variable 
    private Cell[][] grid;
    private Random random = new Random();

    //  Constructor 
    public Board() {
        initializeGrid();
        placeMines();
        computeNeighborCounts();
    }

    //  Methods 

    /** Creates a fresh Cell at every position in the grid. */
    void initializeGrid() {
        // Complete this method
        grid = new Cell[MinesweeperGame.ROWS][MinesweeperGame.COLS];

        for (int row = 0; row < MinesweeperGame.ROWS; row++) {
            for (int col = 0; col < MinesweeperGame.COLS; col++) {
                grid[row][col] = new Cell();
            }
        }    
    }

    /**
     * Randomly places TOTAL_MINES distinct mines on the grid.
     * Keeps picking random positions until all mines are placed.
     */
    void placeMines() {
        // Complete this method
        int minesPlaced = 0;

        while (minesPlaced < MinesweeperGame.TOTAL_MINES) {
            int row = random.nextInt(MinesweeperGame.ROWS);
            int col = random.nextInt(MinesweeperGame.COLS);

            if (!grid[row][col].isMine()) {
                grid[row][col].setMine(true);
                minesPlaced++;
            }
        }
    }

    /** Sets the neighborMineCount for every cell on the grid. */
    void computeNeighborCounts() {
        // Complete this method
        for (int row = 0; row < MinesweeperGame.ROWS; row++) {
            for (int col = 0; col < MinesweeperGame.COLS; col++) {
                int count = 0;
                ArrayList<Cell> neighbors = getNeighbors(row, col);

                for (Cell neighbor : neighbors) {
                    if (neighbor.isMine()) {
                        count++;
                    }
                }

                grid[row][col].setNeighborMineCount(count);
            }
        }
    }

    /**
     * Returns an ArrayList of all valid neighboring Cells for position (row, col).
     * Checks all 8 directions and skips out-of-bounds positions.
     */
    ArrayList<Cell> getNeighbors(int row, int col) {
        // Complete this method
        ArrayList<Cell> neighbors = new ArrayList<>();

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                boolean isCurrentCell = (dr == 0 && dc == 0);

                if (!isCurrentCell) {
                    int newRow = row + dr;
                    int newCol = col + dc;

                    if (newRow >= 0 && newRow < MinesweeperGame.ROWS
                            && newCol >= 0 && newCol < MinesweeperGame.COLS) {
                        neighbors.add(grid[newRow][newCol]);
                    }
                }
            }
        }

        return neighbors;
    }


    /**
     * Reveals the cell at (row, col).
     *   - Returns false if it is a mine (game over).
     *   - Triggers floodReveal method if neighborMineCount == 0.
     *   - Returns true otherwise.
     */
    boolean revealCell(int row, int col) {
        // Complete this method
        Cell cell = grid[row][col];

        if (cell.isMine()) {
            cell.reveal();
            return false;
        }

        if (cell.getNeighborMineCount() == 0) {
            floodReveal(row, col);
        } else {
            cell.reveal();
        }

        return true;
    }

    /**
     * Flood-fill:  reveals all connected zero-hint cells and
     * the numbered border cells surrounding the empty region.
     */
    void floodReveal(int row, int col) {
        ArrayList<int[]> queue = new ArrayList<>();
        queue.add(new int[]{row, col});
        grid[row][col].reveal();

        int queueIndex = 0;
        while (queueIndex < queue.size()) {
            int[] pos = queue.get(queueIndex++);
            int r = pos[0];
            int c = pos[1];

            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0) continue;
                    int nr = r + dr;
                    int nc = c + dc;
                    if (nr < 0 || nr >= MinesweeperGame.ROWS
                     || nc < 0 || nc >= MinesweeperGame.COLS) continue;

                    Cell neighbor = grid[nr][nc];
                    if (neighbor.isRevealed() || neighbor.isMine() || neighbor.isFlagged()) continue;

                    neighbor.reveal();
                    if (neighbor.getNeighborMineCount() == 0) {
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

  

    /** Toggles the flag on the cell at (row, col) if the position is valid. */
    void flagCell(int row, int col) {
        // Complete this method
        if (row >= 0 && row < MinesweeperGame.ROWS && col >= 0 && col < MinesweeperGame.COLS) {
            grid[row][col].toggleFlag();
        }
    }

    /** Reveals every mine — called on defeat so the player sees the full board. */
    void revealAllMines() {
        // Complete this method
        for (int row = 0; row < MinesweeperGame.ROWS; row++) {
            for (int col = 0; col < MinesweeperGame.COLS; col++) {
                if (grid[row][col].isMine()) {
                    grid[row][col].reveal();
                }
            }
        }
    }

    /**
     * Victory condition: every non-mine cell has been revealed.
     */
    boolean allSafeCellsRevealed() {
        // Complete this method
        for (int row = 0; row < MinesweeperGame.ROWS; row++) {
            for (int col = 0; col < MinesweeperGame.COLS; col++) {
                if (!grid[row][col].isMine() && !grid[row][col].isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }


    public Cell getCell(int row, int col) {
        //complete this method
        if (row >= 0 && row < MinesweeperGame.ROWS
        && col >= 0 && col < MinesweeperGame.COLS) {
            return grid[row][col];
        }
        return null;
    }

    public Cell[][] getGrid(){ 
        return grid; 
    }
}
