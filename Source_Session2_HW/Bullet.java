/**
 * Created by qhuydtvt on 4/21/2016.
 */
public class Bullet {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bullet() {}

    public void move(Movement movement) {
        this.x += movement.dx;
        this.y += movement.dy;
    }
}
