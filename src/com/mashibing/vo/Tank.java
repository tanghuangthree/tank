package com.mashibing.vo;

import java.awt.*;

public class Tank {
    private int x;
    private int y;
    private Dir dir;
    private static final int SPEED = 5;
    private TankFrame tf;
    public final int WIDTH = ResourceMgr.tankD.getWidth();
    public final int HIGHT = ResourceMgr.tankD.getHeight();
    private boolean living = true;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

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

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private boolean moving = false;

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.tanks.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            default:
                break;

        }
        move();
    }

    public void move() {
        if (!moving) {
            return;
        }
        switch (dir) {
            case DOWN:
                y += SPEED;
                break;
            case UP:
                y -= SPEED;
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

    public void fire() {
        switch (dir) {
            case LEFT:
                tf.bullets.add(new Bullet(x + ResourceMgr.tankL.getWidth() / 2 - ResourceMgr.bulletL.getWidth() / 2 - 20, y + ResourceMgr.tankL.getHeight() / 2 - ResourceMgr.bulletL.getHeight() / 2 - 1, dir, tf));
                break;
            case RIGHT:
                tf.bullets.add(new Bullet(x + ResourceMgr.tankR.getWidth() / 2 - ResourceMgr.bulletR.getWidth() / 2 + 20, y + ResourceMgr.tankR.getHeight() / 2 - ResourceMgr.bulletR.getHeight() / 2 + 1, dir, tf));
                break;
            case UP:
                tf.bullets.add(new Bullet(x + ResourceMgr.tankU.getWidth() / 2 - ResourceMgr.bulletU.getWidth() / 2 + 1, y + ResourceMgr.tankU.getHeight() / 2 - ResourceMgr.bulletU.getHeight() / 2 - 20, dir, tf));
                break;
            case DOWN:
                tf.bullets.add(new Bullet(x + ResourceMgr.tankD.getWidth() / 2 - ResourceMgr.bulletD.getWidth() / 2 - 1, y + ResourceMgr.tankD.getHeight() / 2 - ResourceMgr.bulletD.getHeight() / 2 + 20, dir, tf));
                break;
            default:
                break;
        }

    }

    public void die() {
        this.living = false;
    }
}
