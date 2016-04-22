import java.awt.*;

public class PlaneViewController {

    private Plane plane;
    private Movement movement;
    private Image sprite;
    public int speed;
    private BulletViewController bulletViewController;

    public PlaneViewController(Plane plane, Image sprite) {
        this.plane = plane;
        this.sprite = sprite;
        this.movement = new Movement();
        this.speed = 5;
    }

    public void shot() {
        if(bulletViewController == null) {
            bulletViewController = new BulletViewController(
                    new Bullet(plane.getX() + 30, plane.getY()),
                    Utils.loadImage("resources/DAN.png")
            );
        }
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
        if(bulletViewController != null) {
            bulletViewController.run();
            if(!bulletViewController.isAlive()) {
                bulletViewController = null;
            }
        }
    }

    public void paint(Graphics g) {
        g.drawImage(sprite, plane.getX(), plane.getY(), 70, 60, null);
        if(bulletViewController != null) {
            bulletViewController.paint(g);
        }
    }
}
