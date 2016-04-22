
public class Plane {
    private int x;
    private int y;

    public Plane() {
        x = 0;
        y = 0;
    }

    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move(Movement movement) {
        this.x += movement.dx;
        this.y += movement.dy;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
