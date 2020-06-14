package com.mashibing;

import java.awt.*;

public class Bullet extends GameObject{
    private static final int SPEED = 5;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HIGHT = ResourceMgr.bulletD.getHeight();
    private int x, y;
    public Group group;
    Rectangle rect = new Rectangle();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private final Dir dir;
    private boolean living = true;
    public GameModel model;

    public Bullet(int x, int y, Dir dir, Group group, GameModel model) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.model = model;
        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HIGHT;
    }

    @Override public void paint(Graphics g) {

        if (!living) {
            model.remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            default:
                break;
        }

        move();
    }

    private void move() {
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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HIGHT) {
            living = false;
        } else {
            living = true;
        }
        // update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    public void die() {
        this.living = false;
    }
}
