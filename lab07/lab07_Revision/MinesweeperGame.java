import java.util.Scanner;

public class MinesweeperGame {

    // Constants 
    static final int    ROWS            = 10;
    static final int    COLS            = 8;
    static final int    TOTAL_MINES     = 12;
    static final String HIDDEN_SYMBOL   =  "#";
    static final String MINE_SYMBOL     = "O";
    static final String FLAG_SYMBOL     = ">";
    static final String EMPTY_SYMBOL    = " ";
    static final String DISPOSAL_ITEM_SYMBOL = "X";
    static final String VICTORY_MESSAGE = "Victory! You cleared the minefield!";
    static final String DEFEAT_MESSAGE  = "Defeat! You hit a mine!";

    //  Static instances 
    static GameController gameController;
    static Scanner        scanner;

    //  Main method 
    public static void main(String[] args) {
        initializeVariables();
        playGame();
        handleGameEnding();
    }

    //  Initialization 
    static void initializeVariables() {
        scanner        = new Scanner(System.in);
        gameController = new GameController();
    }

    //  Main game loop 
    static void playGame() {
        // Complete this method
        while (!gameController.isGameOver()) {
            renderBoard();
            handlePlayerAction();
        }
    }

    //  End of game handling
    static void handleGameEnding() {
        // Complete this method
        renderBoard();

        if (gameController.isVictory()) {
            System.out.println(VICTORY_MESSAGE);
        } else {
            System.out.println(DEFEAT_MESSAGE);
        }

        System.out.println("Final Score: " + gameController.getScore());
    }

    // Renders the board and 
    static void renderBoard() {
        // Complete this method
        System.out.print("  ");
        for (int col = 0; col < COLS; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < ROWS; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < COLS; col++) {
                System.out.print(gameController.getBoard().getCell(row, col).display() + " ");
            }
            System.out.println();
        }

        System.out.println("------------------------");
        renderGameInformation();
    }

    // Renders score, flags placed, and other relevant information.
    static void renderGameInformation() {
        // Complete this method
        System.out.println("Score: " + gameController.getScore()
                + " | Flags: " + gameController.getFlagsPlaced()
                + " | Mines remaining: " + gameController.getMinesRemaining());
    }

    //  Handles the player's action choice and coordinates, and validates the input with getValidInput method.
    //  After getting valid inputs, calls the appropriate GameController method to update the game state.
    static void handlePlayerAction() {
        // Complete this method
        String action = "";
        boolean validAction = false;

        while (!validAction) {
            System.out.print("Action (R-Reveal, F-Flag): ");
            action = scanner.nextLine().trim().toUpperCase();

            if (action.equals("R") || action.equals("F")) {
                validAction = true;
            } else {
                System.out.println("Invalid action. Enter R or F.");
            }
        }

        int row = getValidInput("Enter row (0 to " + (ROWS - 1) + "): ", 0, ROWS - 1);
        int col = getValidInput("Enter column (0 to " + (COLS - 1) + "): ", 0, COLS - 1);

        if (action.equals("R")) {
            gameController.handleReveal(row, col);
        } else {
            gameController.handleFlag(row, col);
        }

    }

    // Prompts the user for action type (reveal or flag) and coordinates, and validates the input.
    static int getValidInput(String prompt, int min, int max) {
        // Complete this method
          boolean valid = false;
        int value = min;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                int parsedValue = Integer.parseInt(input);

                if (parsedValue >= min && parsedValue <= max) {
                    value = parsedValue;
                    valid = true;
                } else {
                    System.out.println("Invalid input. Enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between " + min + " and " + max + ".");
            }
        }

        return value;
    }
}
