import java.util.List;
import java.util.Random;

/**
 * GameField manages the main gameplay environment, tracking all active
 * entities,
 * handling star generation, collision detection, and scorekeeping.
 */
public class GameField {
    private Basket basket;
    private List<Star> stars;
    private int score;

    /**
     * Initializes the game field with references to the basket and the star list.
     * Initializes the score to zero.
     *
     * @param basket the player-controlled basket
     * @param stars  the list of active stars
     */
    public GameField(Basket basket, List<Star> stars) {
        this.basket = basket;
        this.stars = stars;
        score = 0;
    }

    /**
     * Spawns a single Star at the very top of the grid (y = 0).
     * The x coordinate is chosen randomly between 0 and (GameEngine.WIDTH - 1).
     */
    public void spawnStar() {
        Random rand = new Random();
        int x = rand.nextInt(GameEngine.WIDTH);
        stars.add(new Star(x, 0));
    }

    /**
     * Evaluates all stars for collisions.
     * - If a star shares the exact same coordinates as the basket, it is "caught"
     * (score increases, star removed).
     * - If a star reaches the bottom of the grid (y == GameEngine.HEIGHT - 1) and
     * is missed,
     * it hits the ground (health decreases, star removed).
     */
    public void checkCollisions() {
        for (int i = stars.size() - 1; i >= 0; i--) {
            Star star = stars.get(i);

            if (star.collidesWith(basket)) {
                score++;
                stars.remove(i);
            } else if (star.getY() >= GameEngine.HEIGHT - 1) {
                basket.setHealth(basket.getHealth() - 1);
                stars.remove(i);
            }
        }
    }

    /** @return the player's current score */
    public int getScore() {
        return score;
    }
}
