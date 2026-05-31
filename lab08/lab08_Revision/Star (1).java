/**
 * The Star class represents the falling objects in the game.
 * It extends the Entity superclass, inheriting position and symbol ('*'),
 * and adds gravity (downward movement) behavior.
 */
public class Star extends Entity {

    /**
     * Constructs a Star at the given starting position.
     * The symbol is permanently set to '*'.
     *
     * @param x initial horizontal position
     * @param y initial vertical position (should be 0 when spawned)
     */
    public Star(int x, int y) {
        super(x, y, '*');
    }

    /**
     * Moves the star one step downward on the grid by increasing its y coordinate.
     * This simulates the star falling each turn.
     */
    public void update() {
        y++;
    }
}
