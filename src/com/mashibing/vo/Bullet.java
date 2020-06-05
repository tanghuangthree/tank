package com.mashibing.vo;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 5;
    private static final int WIDTH = 30;
    private static final int HIGHT = 30;
    private int x, y;
    private final Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HIGHT);
        g.setColor(c);
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
    }

}
