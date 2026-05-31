public class GameController {

    // Instance variables
    private Board   board;
    private int     score;
    private int     flagsPlaced;
    private boolean gameOver;

    // Constructor initializes a new game with a fresh board and reset stats.
    public GameController() {
        board       = new Board();
        score       = 0;
        flagsPlaced = 0;
        gameOver    = false;
    }

    // Methods

    /**
     * Attempts to reveal the cell at (row, col).
     *  - Does nothing if the cell is already revealed or flagged.
     *  - Sets gameOver and reveals all mines if a mine is hit.
     *  - Otherwise counts newly revealed cells and adds them to score.
     */
    public void handleReveal(int row, int col) {
        // Complete this method 
        Cell cell = board.getCell(row, col);

        if (cell == null || cell.isRevealed() || cell.isFlagged()) {
            return;
        }

        int before = countRevealedSafeCells();
        boolean safe = board.revealCell(row, col);

        if (!safe) {
            gameOver = true;
            board.revealAllMines();
        } else {
            int after = countRevealedSafeCells();
            score += (after - before);
        }
    }

    /**
     * Toggles a flag at (row, col).
     * Adjusts flagsPlaced accordingly, never below 0.
     */
    public void handleFlag(int row, int col) {
        // Complete this method
        Cell cell = board.getCell(row, col);

        if (cell == null || cell.isRevealed()) {
            return;
        }

        boolean wasFlagged = cell.isFlagged();
        board.flagCell(row, col);
        boolean isFlaggedNow = cell.isFlagged();

        if (!wasFlagged && isFlaggedNow) {
            flagsPlaced++;
        } else if (wasFlagged && !isFlaggedNow) {
            flagsPlaced--;
        }

        if (flagsPlaced < 0) {
            flagsPlaced = 0;
        }
    }

    /** Returns true if the player hit a mine OR all safe cells are revealed. */
    public boolean isGameOver() {
        // Complete this method
        return gameOver || board.allSafeCellsRevealed();
    }

    /** Returns true if all safe cells are revealed and no mine was hit. */
    public boolean isVictory() {
        // Complete this method
        return board.allSafeCellsRevealed() && !gameOver;
    }

  

    /** Counts all non-mine cells that have been revealed. */
    private int countRevealedSafeCells() {
        // Complete this method
        int count = 0;

        for (int row = 0; row < MinesweeperGame.ROWS; row++) {
            for (int col = 0; col < MinesweeperGame.COLS; col++) {
                Cell cell = board.getCell(row, col);
                if (cell != null && cell.isRevealed() && !cell.isMine()) {
                    count++;
                }
            }
        }

        return count;
    }

    

    public int   getScore(){ 
        return score; 
    }
    public int   getFlagsPlaced(){ 
        return flagsPlaced; 
    }
    public int   getMinesRemaining(){ 
        //complete this method
        return MinesweeperGame.TOTAL_MINES - flagsPlaced;
    }
    public Board getBoard(){ 
        return board; 
    }
}
