package vn.edu.techkids;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlaneViewController {

    private Plane plane;
    private GameVector gameVector;
    private Image sprite;
    public int speed;
    private BulletViewController bulletViewController;

    public PlaneViewController(Plane plane, Image sprite) {
        this.plane = plane;
        this.sprite = sprite;
        this.gameVector = new GameVector();
        this.speed = 5;
    }

    public void shot() {
        if(bulletViewController == null) {
            bulletViewController = new BulletViewController(
                    new Bullet(plane.getX() + 30, plane.getY(), 13, 33),
                    Utils.loadImage("resources/DAN.png")
            );
        }
    }

    public void left() {
        gameVector.dx = -speed;
    }

    public void  right() {
        gameVector.dx = speed;
    }

    public void up() {
        gameVector.dy = -speed;
    }

    public void down() {
        gameVector.dy = speed;
    }

    public void stopX() {
        gameVector.dx = 0;
    }

    public void stopY() {
        gameVector.dy = 0;
    }



    public void run() {
        plane.move(gameVector);
        if(bulletViewController != null) {
            bulletViewController.run();
            if(!bulletViewController.isAlive()) {
                bulletViewController = null;
            }
        }
    }

    public void moveTo(Point point){
        int destinationX = point.x - plane.getWidth()/2;
        int destinationY = point.y - plane.getHeight()/2;

        if(plane.getX() < destinationX - speed) {
            gameVector.dx = speed;
        }
        else if(plane.getX() > destinationX + speed) {
            gameVector.dx = -speed;
        }
        else gameVector.dx = 0;

        if(plane.getY() < destinationY - speed) {
            gameVector.dy = speed;
        }
        else if(plane.getY() > destinationY + speed) {
            gameVector.dy = -speed;
        }
        else gameVector.dy = 0;
    }

    public void paint(Graphics g) {
        g.drawImage(sprite, plane.getX(), plane.getY(), plane.getWidth(),plane.getHeight() , null);
        if(bulletViewController != null) {
            bulletViewController.paint(g);
        }
    }
}
