
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameWindow extends Frame implements Runnable {

    Image imgBackground;

    Thread thread;
    Image backBufferImage;

    PlaneViewController planeViewController1;
    PlaneViewController planeViewController2;

    public GameWindow() {

        this.setSize(Screen.width, Screen.height);

        planeViewController1 = new PlaneViewController(
                new Plane(100, 100),
                Utils.loadImage("resources/PLANE4.png")
        );

        planeViewController2 = new PlaneViewController(
            new Plane(200, 200),
                Utils.loadImage("resources/PLANE3.png")
        );

        this.setVisible(true);

        imgBackground = Utils.loadImage("resources/Background.png");

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
                    case KeyEvent.VK_UP:
                        planeViewController1.up();
                        break;
                    case KeyEvent.VK_DOWN:
                        planeViewController1.down();
                        break;
                    case KeyEvent.VK_LEFT:
                        planeViewController1.left();
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeViewController1.right();
                        break;
                    case KeyEvent.VK_SPACE:
                        planeViewController1.shot();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_DOWN:
                        planeViewController1.stopY();
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                        planeViewController1.stopX();
                        break;
                    default:
                        break;
                }
            }
        });
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
        Graphics backBufferGraphics = backBufferImage.getGraphics();

        backBufferGraphics.drawImage(imgBackground, 10, 10, null);
        planeViewController1.paint(backBufferGraphics);

        g.drawImage(backBufferImage, 0, 0, null);
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(17);
                planeViewController1.run();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread running");
        }
    }
}