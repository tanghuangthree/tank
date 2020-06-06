package com.mashibing.vo;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 5;
    public final int WIDTH = ResourceMgr.bulletD.getWidth();
    public final int HIGHT = ResourceMgr.bulletD.getHeight();
    private int x, y;
    private Group group;

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
    private TankFrame tf;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {

        if (!living) {
            tf.bullets.remove(this);
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
    }

    public void die() {
        this.living = false;
    }

    public void collideWith(Tank tank) {
        if (this.group.equals(tank.getGroup())) {
            return;
        }
        Rectangle rectangle1 = new Rectangle(this.x, this.y, this.WIDTH, this.HIGHT);
        Rectangle rectangle2 = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HIGHT);
        if (rectangle1.intersects(rectangle2)) {
            this.die();
            tank.die();
        }
    }
}
