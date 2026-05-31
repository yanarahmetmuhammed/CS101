public class Asteroid extends Entity {

    public Asteroid(int x, int y) {
        super(x, y, 'X');
    }

    public void update() {
        y++;
    }
}
