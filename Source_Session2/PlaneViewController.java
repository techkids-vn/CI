import java.awt.*;

public class PlaneViewController {

    private Plane plane;
    private Movement movement;
    private Image sprite;
    public int speed;

    public PlaneViewController(Plane plane, Image sprite) {
        this.plane = plane;
        this.sprite = sprite;
        this.movement = new Movement();
        this.speed = 5;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public void moveTo(Point point){
        int destinationX = point.x - plane.getWidth()/2;
        int destinationY = point.y - plane.getHeight()/2;

        if(plane.getX() < destinationX - speed) {
            movement.dx = speed;
        }
        else if(plane.getX() > destinationX + speed) {
            movement.dx = -speed;
        }
        else movement.dx = 0;

        if(plane.getY() < destinationY - speed) {
            movement.dy = speed;
        }
        else if(plane.getY() > destinationY + speed) {
            movement.dy = -speed;
        }
        else movement.dy = 0;
    }

    public void left() {
        movement.dx = -speed;
    }

    public void  right() {
        movement.dx = speed;
    }

    public void up() {
        movement.dy = -speed;
    }

    public void down() {
        movement.dy = speed;
    }

    public void stopX() {
        movement.dx = 0;
    }

    public void stopY() {
        movement.dy = 0;
    }

    public void run() {
        plane.move(movement);
    }

    public void paint(Graphics g) {
        g.drawImage(sprite, plane.getX(), plane.getY(), plane.getWidth(), plane.getHeight(), null);
    }
}
