package vn.edu.techkids;

import java.awt.*;

/**
 * Created by qhuydtvt on 4/21/2016.
 */
public class BulletViewController {
    private Bullet bullet;
    private GameVector gameVector;
    private Image image;
    private boolean isAlive;

    public BulletViewController(Bullet bullet, Image image) {
        this.bullet = bullet;
        this.gameVector = new GameVector(0, -5);
        this.image = image;
        this.isAlive = true;
    }

    public void run() {
        bullet.move(gameVector);
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
