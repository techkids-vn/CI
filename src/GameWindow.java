import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by qhuydtvt on 4/19/2016.
 */
public class GameWindow extends Frame implements Runnable {

    BufferedImage imgBackground;
    BufferedImage imgPlane;
    int planeX, planeY;
    int dx, dy;
    Thread thread;
    Image backBufferImage;

    public GameWindow(){
        this.setSize(410, 610);
        planeX = 200 - 35;
        planeY = 600 - 62;
        dx = 0;
        dy = 0;

        this.setVisible(true);

        try {
            imgBackground = ImageIO.read(new File("resources/Background.png"));
            imgPlane = ImageIO.read(new File("resources/PLANE4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        dx = -5;
                        System.out.println("Go Left");
                        break;
                    case KeyEvent.VK_RIGHT:
                        dx = 5;
                        System.out.println("Go right");
                        break;
                    case KeyEvent.VK_UP:
                        dy = -5;
                        System.out.println("Go up");
                        break;
                    case KeyEvent.VK_DOWN:
                        dy = 5;
                        System.out.println("Go down");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        dx = 0;
                        System.out.println("Go Left");
                        break;
                    case KeyEvent.VK_RIGHT:
                        dx = 0;
                        System.out.println("Go right");
                        break;
                    case KeyEvent.VK_UP:
                        dy = 0;
                        System.out.println("Go up");
                        break;
                    case KeyEvent.VK_DOWN:
                        dy = 0;
                        System.out.println("Go down");
                        break;
                    default:
                        break;
                }
            }
        });

        this.repaint();
    }

    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Graphics g) {

        if(backBufferImage == null) {
            backBufferImage = createImage(getWidth(), getHeight());
        }
        Graphics backbufferGraphics = backBufferImage.getGraphics();

        backbufferGraphics.drawImage(imgBackground, 10, 10, null); /* Background drawing */
        backbufferGraphics.drawImage(imgPlane, planeX, planeY, null); /* Coordinates explanation */

        g.drawImage(backBufferImage, 0, 0, null);
    }

//    @Override
//    public void paint(Graphics g) {
//        g.drawImage(imgBackground, 10, 10, null); /* Background drawing */
//        g.drawImage(imgPlane, planeX, planeY, null); /* Coordinates explanation */
//    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(17);
                planeX += dx;
                planeY += dy;
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread running");
        }
    }
}
