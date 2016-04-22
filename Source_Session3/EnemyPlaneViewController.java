package vn.edu.techkids;

import java.awt.*;

/**
 * Created by qhuydtvt on 4/22/2016.
 */
public class EnemyPlaneViewController {

    private GameVector gameVector;
    private EnemyPlane enemyPlane;
    private Image image;

    public EnemyPlaneViewController(EnemyPlane enemyPlane, Image image) {
        this.enemyPlane = enemyPlane;
        this.image = image;
        gameVector = new GameVector(0, 3);
    }

    public void paint(Graphics g) {
        g.drawImage(image, enemyPlane.getX(), enemyPlane.getY(), enemyPlane.getWidth(), enemyPlane.getHeight() , null);
    }

    public void run() {
        this.enemyPlane.move(this.gameVector);
    }
}
