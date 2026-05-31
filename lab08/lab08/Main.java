/**
 * The entry point for the Star Catcher game.
 */
public class Main {
    /**
     * Launches the game by creating a GameEngine instance and running it.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        game.run();
    }
}
