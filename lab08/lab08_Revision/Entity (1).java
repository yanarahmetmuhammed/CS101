/**
 * The Entity class serves as the base (superclass) for all game objects.
 * It defines shared attributes and behaviors common to both the basket and the stars.
 */
public class Entity {
    /** The horizontal position (column) of the entity on the grid. */
    protected int x;
    /** The vertical position (row) of the entity on the grid. */
    protected int y;
    /** The character symbol used to visually represent the entity. */
    protected char symbol;

    /**
     * Initializes the entity’s position and symbol.
     *
     * @param x      horizontal position on the grid
     * @param y      vertical position on the grid
     * @param symbol character representing the entity
     */
    public Entity(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    /**
     * Checks if this entity occupies the exact same grid position as another entity.
     *
     * @param other the other entity to check collision against
     * @return true if both entities share the same (x, y) coordinates, false otherwise
     */
    public boolean collidesWith(Entity other) {
        return x == other.x && y == other.y;
    }

    /** @return the horizontal position (x) */
    public int getX() {
        return x;
    }

    /** @return the vertical position (y) */
    public int getY() {
        return y;
    }

    /** @return the character symbol */
    public char getSymbol() {
        return symbol;
    }
}
