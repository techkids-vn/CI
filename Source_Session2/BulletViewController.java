import java.awt.*;
import java.nio.Buffer;

/**
 * Created by qhuydtvt on 4/21/2016.
 */
public class BulletViewController {
    private Bullet bullet;
    private Movement movement;
    private Image image;
    private boolean isAlive;

    public BulletViewController(Bullet bullet, Image image) {
        this.bullet = bullet;
        this.movement = new Movement(0, -5);
        this.image = image;
        this.isAlive = true;
    }

    public void run() {
        bullet.move(movement);
        if(!Screen.isInRange(bullet.getX(), bullet.getY())){
            isAlive = false;
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(image, bullet.getX(), bullet.getY(), null);
    }
}
