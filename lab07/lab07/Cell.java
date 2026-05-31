public class Cell {

    //  Instance variables 
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int     neighborMineCount;

    //Constructor
    public Cell() {
        // Complete this constructor
        isMine = false;
        isRevealed = false;
        isFlagged = false;
        neighborMineCount = 0;
    }

    //Methods 

    /**
     * Reveals this cell. Has no effect if the cell is flagged.
     */
    public void reveal() {
        // Complete this method
        if (!isFlagged) {
            isRevealed = true;
        }
    }

    /**
     * Places or removes a flag. Has no effect if the cell is already revealed.
     */
    public void toggleFlag() {
        // Complete this method
        if (!isRevealed) {
            isFlagged = !isFlagged;
        }
    }

    /**
     * Returns the symbol that should be displayed for this cell.
     *   >  – flagged
     *   #  – hidden (not yet revealed)
     *   O  – revealed mine
     *   "3" – revealed with more than zero neighboring mines (example "3")
     *   " "  – revealed, no neighboring mines
     */
    public String display() {
        if (isFlagged) {
            return MinesweeperGame.FLAG_SYMBOL;
        }

        if (!isRevealed) {
            return MinesweeperGame.HIDDEN_SYMBOL;
        }

        if (isMine) {
            return MinesweeperGame.MINE_SYMBOL;
        }

        if (neighborMineCount > 0) {
            return String.valueOf(neighborMineCount);
        }

        return MinesweeperGame.EMPTY_SYMBOL;
    }


    public boolean isMine(){ 
        return isMine; 
    }
    public boolean isRevealed(){ 
        return isRevealed; 
    }
    public boolean isFlagged(){ 
        return isFlagged; 
    }
    public int     getNeighborMineCount(){ 
        return neighborMineCount; 
    }


    public void setMine(boolean mine){
         this.isMine = mine; 
        }
    public void setNeighborMineCount(int count){ 
        this.neighborMineCount = count; 
    }
}
