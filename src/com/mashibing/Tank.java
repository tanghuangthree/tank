package com.mashibing;

import java.awt.*;
import java.util.Random;

public class Tank {
    private int x;
    private int y;
    private Dir dir;
    private static final int SPEED = 3;
    private TankFrame tf;
    public static final int WIDTH = ResourceMgr.badTankD.getWidth();
    public static final int HIGHT = ResourceMgr.badTankD.getHeight();
    private boolean living = true;
    private Group group;
    private boolean moving;
    private Random random = new Random();
    Rectangle rect = new Rectangle();

    public Tank(int x, int y, Dir dir, Group group, boolean moving, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.moving = moving;
        this.tf = tf;
        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HIGHT;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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


    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.badTanks.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(Group.GOOD == this.group ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case DOWN:
                g.drawImage(Group.GOOD == this.group ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            case RIGHT:
                g.drawImage(Group.GOOD == this.group ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case UP:
                g.drawImage(Group.GOOD == this.group ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
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
        if (random.nextInt(100) > 95) {
            if (Group.BAD.equals(this.group)) {
                fire();
            }
        }
        randomDir();
        boundCheck();
        //update rect
        rect.x = x;
        rect.y = y;
    }

    private void boundCheck() {
        if (this.x < 2) {
            this.x = 2;
        }
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            this.x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (this.y < 30) {
            this.y = 30;
        }
        if (this.y > TankFrame.GAME_HIGHT - Tank.HIGHT - 2) {
            this.y = TankFrame.GAME_HIGHT - Tank.HIGHT - 2;
        }
    }

    private void randomDir() {
        if (Group.BAD.equals(this.group) && random.nextInt(100) > 95) {
            this.dir = Dir.values()[random.nextInt(4)];
        }
    }

    public void fire() {
        switch (dir) {
            case LEFT:
                tf.bullets.add(new Bullet(x + ResourceMgr.goodTankL.getWidth() / 2 - ResourceMgr.bulletL.getWidth() / 2 - 20, y + ResourceMgr.goodTankL.getHeight() / 2 - ResourceMgr.bulletL.getHeight() / 2 - 1, dir, this.group, tf));
                break;
            case RIGHT:
                tf.bullets.add(new Bullet(x + ResourceMgr.goodTankR.getWidth() / 2 - ResourceMgr.bulletR.getWidth() / 2 + 20, y + ResourceMgr.goodTankR.getHeight() / 2 - ResourceMgr.bulletR.getHeight() / 2 + 1, dir, this.group, tf));
                break;
            case UP:
                tf.bullets.add(new Bullet(x + ResourceMgr.goodTankU.getWidth() / 2 - ResourceMgr.bulletU.getWidth() / 2 + 1, y + ResourceMgr.goodTankU.getHeight() / 2 - ResourceMgr.bulletU.getHeight() / 2 - 20, dir, this.group, tf));
                break;
            case DOWN:
                tf.bullets.add(new Bullet(x + ResourceMgr.goodTankD.getWidth() / 2 - ResourceMgr.bulletD.getWidth() / 2 - 1, y + ResourceMgr.goodTankD.getHeight() / 2 - ResourceMgr.bulletD.getHeight() / 2 + 20, dir, this.group, tf));
                break;
            default:
                break;
        }

    }

    public void die() {
        this.living = false;
    }
}
