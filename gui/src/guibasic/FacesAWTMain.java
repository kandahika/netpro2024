package guibasic;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWTMain {

    public static void main(String[] args) {
        new FacesAWTMain();
    }

    FacesAWTMain() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    // Inner class definition
    class FaceFrame extends Frame {

        private FaceObj[] faces;

        FaceFrame() {
            faces = new FaceObj[9];
            for (int i = 0; i < 9; i++) {
                faces[i] = new FaceObj();
            }
        }

        public void paint(Graphics g) {
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 3; i++) {
                    faces[i + 3 * j].setPosition(200 * i + 50, 200 * j + 50);
                    faces[i + 3 * j].setEmotionLevel(i, j);
                    faces[i + 3 * j].drawFace(g);
                }
            }
        }
    }

    // Inner class FaceObj
    private class FaceObj {
        private int x, y;
        private Color faceColor, eyeColor, mouthColor;
        private int emotionLevel;

        FaceObj() {
            faceColor = new Color(255, 223, 196);
            eyeColor = Color.BLACK;
            mouthColor = Color.RED;
        }

        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setEmotionLevel(int i, int j) {
            // This is a simple example. You can customize it to create different expressions.
            this.emotionLevel = (i + j) % 3;
        }

        public void drawFace(Graphics g) {
            drawRim(g);
            drawEyes(g);
            drawMouth(g);
        }

        private void drawRim(Graphics g) {
            g.setColor(faceColor);
            g.fillRoundRect(x + 5, y + 5, 190, 190, 40, 40);
        }

        private void drawEyes(Graphics g) {
            g.setColor(eyeColor);
            g.fillOval(x + 50, y + 75, 20, 20);
            g.fillOval(x + 130, y + 75, 20, 20);
        }

        private void drawMouth(Graphics g) {
            g.setColor(mouthColor);
            if (emotionLevel == 0) {
                g.drawArc(x + 50, y + 100, 100, 50, 0, -180);
            } else if (emotionLevel == 1) {
                g.drawLine(x + 50, y + 125, x + 150, y + 125);
            } else {
                g.drawArc(x + 50, y + 100, 100, 50, 0, 180);
            }
        }
    }
}
