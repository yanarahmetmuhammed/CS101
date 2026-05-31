/**
 * The Basket class represents the player-controlled object at the bottom of the screen.
 * It extends the Entity superclass, inheriting position and symbol ('U'),
 * and adds health tracking and horizontal movement behaviors.
 */
public class Basket extends Entity {
    /** The number of health points the player currently has. */
    private int health;

    /**
     * Constructs a Basket at the given position with a specified health value.
     * The symbol is permanently set to 'U'.
     *
     * @param x       initial horizontal position on the grid
     * @param y       initial vertical position on the grid (usually at the bottom)
     * @param health  initial health value
     */
    public Basket(int x, int y, int health) {
        super(x, y, 'U');
        this.health = health;
    }

    /**
     * Moves the basket one cell to the left.
     * Must ensure the basket does not move past the left boundary (x < 0).
     */
    public void moveLeft() {
        if (x > 0) {
            x--;
        }
    }

    /**
     * Moves the basket one cell to the right.
     * Must ensure the basket does not move past the right boundary (x >= GameEngine.WIDTH).
     */
    public void moveRight() {
        if (x < GameEngine.WIDTH - 1) {
            x++;
        }
    }

    /** @return the current health of the basket */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the basket’s health to a new value.
     * Used when a star hits the ground and the player loses health.
     *
     * @param health the new health value
     */
    public void setHealth(int health) {
        this.health = health;
    }
}