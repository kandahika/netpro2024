package guichat;

import java.awt.Color;
import java.awt.Graphics;

class GUIAnimatinFaceLook {// 顔のオブジェクト

    int h = 100;
    int w = 100;

    int xStart = 0;
    int yStart = 0;

    public void setXY(int x, int y) {
        this.xStart = x;
        this.yStart = y;
    }

    public void setSize(int h, int w) {
        this.h = h;
        this.w = h;
    }

    public GUIAnimatinFaceLook() {
    }

    public void makeFace(Graphics g, String emotion) {
        if (emotion.equals("smile")) {
            makeSmileFace(g);
        } else if (emotion.equals("angry")) {
            makeAngryFace(g);
        } else {
            makeNormalFace(g);
        }
    }

    void makeSmileFace(Graphics g) {
        makeEyes(g, w / 5);
        makeNose(g, h / 5);
        makeSmileMouth(g, w / 2);
    }

    void makeAngryFace(Graphics g) {
        makeEyes(g, w / 5);
        makeNose(g, h / 5);
        makeAngryMouth(g, w / 2);
    }

    void makeNormalFace(Graphics g) {
        makeEyes(g, w / 5);
        makeNose(g, h / 5);
        makeNormalMouth(g, w / 2);
    }

    void makeEyes(Graphics g, int eyeSize) {
        g.setColor(Color.blue);
        g.fillOval(xStart + (h * 2 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
        g.fillOval(xStart + (h * 4 / 7), yStart + (w * 1 / 3), eyeSize, eyeSize);
    }

    void makeNose(Graphics g, int noseSize) {
        g.drawLine(xStart + (h * 1 / 2), yStart + (w * 2 / 4), xStart + (h * 1 / 2), yStart + (w * 2 / 4) + noseSize);
    }

    void makeSmileMouth(Graphics g, int mouthSize) {
        g.drawArc(xStart + (h / 4), yStart + (w * 2 / 3), mouthSize, mouthSize / 2, 0, -180);
    }

    void makeAngryMouth(Graphics g, int mouthSize) {
        g.drawArc(xStart + (h / 4), yStart + (w * 2 / 3), mouthSize, mouthSize / 2, 0, 180);
    }

    void makeNormalMouth(Graphics g, int mouthSize) {
        g.drawLine(xStart + (h / 4), yStart + (w * 2 / 3), xStart + (3 * h / 4), yStart + (w * 2 / 3));
    }
}
