import java.util.List;

/**
 * The Drawer class handles all visual console output for the game.
 * It contains only static methods and does not store game state.
 */
public class Drawer {

    /**
     * Prints the game instructions and controls to the console.
     */
    public static void printControls() {
        System.out.println("Welcome to Star Catcher!");
        System.out.println("Controls: 'A' to move Left, 'D' to move Right, 'S' to Stay, 'Q' to Quit.");
        System.out.println("Catch the stars ('*') with your basket ('U').");
        System.out.println("Missed stars cost health!");
    }

    /**
     * Draws the current state of the game on the console.
     * This method:
     * 1. Creates a 2D char array (grid) of HEIGHT x WIDTH.
     * 2. Fills it with empty spaces.
     * 3. Places all active stars at their respective coordinates.
     * 4. Places the basket at its current coordinate.
     * 5. Calls printField to display the grid with borders.
     * * @param basket the player-controlled basket
     * @param stars  the list of active stars falling down
     * @param score  the player's current score
     */
    public static void render(Basket basket, List<Star> stars, List<Asteroid> asteroids, int score) {
        char[][] grid = new char[GameEngine.HEIGHT][GameEngine.WIDTH];

        for (int row = 0; row < GameEngine.HEIGHT; row++) {
            for (int col = 0; col < GameEngine.WIDTH; col++) {
                grid[row][col] = ' ';
            }
        }

        for (Star star : stars) {
            if (isInsideGrid(star.getX(), star.getY())) {
                grid[star.getY()][star.getX()] = star.getSymbol();
            }
        }

        for (Asteroid asteroid : asteroids) {
            if (isInsideGrid(asteroid.getX(), asteroid.getY())) {
                grid[asteroid.getY()][asteroid.getX()] = asteroid.getSymbol();
            }
        }

        if (isInsideGrid(basket.getX(), basket.getY())) {
            grid[basket.getY()][basket.getX()] = basket.getSymbol();
        }

        System.out.println();
        printField(grid);
        System.out.println("Score: " + score + " | Health: " + basket.getHealth());
    }

    /**
     * Checks whether a coordinate is inside the game grid.
     *
     * @param x the horizontal coordinate
     * @param y the vertical coordinate
     * @return true if the coordinate is inside the grid, false otherwise
     */
    private static boolean isInsideGrid(int x, int y) {
        return x >= 0 && x < GameEngine.WIDTH && y >= 0 && y < GameEngine.HEIGHT;
    }

    /**
     * Helper method to print the 2D grid with formatted borders.
     * Each row should look exactly like this: "|          * |"
     * Ensure there are NO extra spaces around the symbol that push the walls.
     * * @param grid the 2D char array representing the game area
     */
    private static void printField(char[][] grid) {
        for (int i = 0; i < GameEngine.WIDTH + 2; i++) {
            System.out.print("=");
        }
        System.out.println();

        for (int row = 0; row < grid.length; row++) {
            System.out.print("|");
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col]);
            }
            System.out.println("|");
        }

        for (int i = 0; i < GameEngine.WIDTH + 2; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
