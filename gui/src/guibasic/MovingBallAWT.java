package guibasic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MovingBallAWT {
    public static void main(String[] args) {
        FFrame f = new FFrame();
        f.setSize(500, 500);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    static class FFrame extends Frame implements Runnable {
        Thread th;
        Ball[] balls;
        private boolean enable = true;
        private int counter = 0;
        private int numBalls = 5;

        FFrame() {
            balls = new Ball[numBalls];
            for (int i = 0; i < numBalls; i++) {
                balls[i] = new Ball();
                balls[i].setPosition((int)(Math.random() * 400), (int)(Math.random() * 400));
                balls[i].setR((int)(Math.random() * 20) + 10);
                balls[i].setColor(new Color((int)(Math.random() * 0x1000000)));
            }
            th = new Thread(this);
            th.start();
        }

        public void run() {
            while (enable) {
                try {
                    th.sleep(100);
                    counter++;
                    if (counter >= 200) enable = false;
                } catch (InterruptedException e) {}

                for (Ball ball : balls) {
                    ball.move();
                }
                repaint();  // paint() method is called
            }
        }

        public void paint(Graphics g) {
            for (Ball ball : balls) {
                ball.draw(g);
            }
        }

        // Inner class Ball
        class Ball {
            int x, y, r; // radius
            Color c = Color.RED;
            int xDir = 1;  // 1: + direction  -1: - direction
            int yDir = 1;

            void setColor(Color c) {
                this.c = c;
            }

            void move() {
                if ((xDir == 1) && (x >= 450 - r)) {
                    xDir = -1;
                }
                if ((xDir == -1) && (x <= r)) {
                    xDir = 1;
                }
                if (xDir == 1) {
                    x = x + 10;
                } else {
                    x = x - 10;
                }

                if ((yDir == 1) && (y >= 450 - r)) {
                    yDir = -1;
                }
                if ((yDir == -1) && (y <= r)) {
                    yDir = 1;
                }
                if (yDir == 1) {
                    y = y + 10;
                } else {
                    y = y - 10;
                }
            }

            void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
            }

            void setR(int r) {
                this.r = r;
            }

            void draw(Graphics g) {
                g.setColor(c);
                g.fillOval(x - r, y - r, 2 * r, 2 * r);  // r is the radius, so it's doubled
            }
        }// Inner class Ball end
    }
}
