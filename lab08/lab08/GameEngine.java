import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * GameEngine implements the main logic and loop of the Star Catcher game.
 * It manages initialization, frame updates, and input processing.
 */
public class GameEngine {
    public static final int WIDTH = 20;
    public static final int HEIGHT = 6;
    public static final int BASKET_HEALTH = 3;

    private GameField field;
    private Scanner in;
    private Basket basket;
    private List<Star> stars;

    /**
     * Initializes the game. Creates the basket at the bottom center,
     * an empty list of stars, the GameField, and the Scanner for input.
     */
    public GameEngine() {
        basket = new Basket(WIDTH / 2, HEIGHT - 1, BASKET_HEALTH);
        stars = new ArrayList<Star>();
        field = new GameField(basket, stars);
        in = new Scanner(System.in);
    }

    /**
     * Starts the main game loop.
     * Displays controls, renders the frame, processes user input,
     * and ends the game when health drops to 0 or user quits.
     */
    public void run() {
        boolean quit = false;

        Drawer.printControls();
        field.spawnStar();

        while (basket.getHealth() > 0 && !quit) {
            Drawer.render(basket, stars, field.getScore());
            System.out.print("Enter command: ");

            String input = in.nextLine();
            char command = 'S';

            if (input.length() > 0) {
                command = Character.toUpperCase(input.charAt(0));
            }

            if (command == 'Q') {
                quit = true;
            }
            else {
                update(command);
            }
        }

        System.out.println();
        if (basket.getHealth() <= 0) {
            System.out.println("Game Over! You ran out of health.");
        }
        else {
            System.out.println("Game Over! Thanks for playing.");
        }
        System.out.println("Final Score: " + field.getScore());
    }

    /**
     * Executes one complete frame/turn of the game.
     * 1. Processes user movement (A = Left, D = Right, S = Stay).
     * 2. Updates all stars (moves them down).
     * 3. Checks for collisions (catches or ground hits).
     * 4. Randomly decides whether to spawn a new star this turn.
     *
     * @param command the character input from the user
     */
    public void update(char command) {
        if (command == 'A') {
            basket.moveLeft();
        }
        else if (command == 'D') {
            basket.moveRight();
        }

        for (Star star : stars) {
            star.update();
        }

        field.checkCollisions();

        if (Math.random() < 0.30) {
            field.spawnStar();
        }
    }
}
