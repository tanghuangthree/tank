package com.mashibing;

public class DefaultFireStrategy implements FireStrategy<Tank> {
    @Override public void fire(Tank t) {
        switch (t.dir) {
            case LEFT:
                new Bullet(t.x + ResourceMgr.goodTankL.getWidth() / 2 - ResourceMgr.bulletL.getWidth() / 2 - 20, t.y + ResourceMgr.goodTankL.getHeight() / 2 - ResourceMgr.bulletL.getHeight() / 2 - 1, t.dir, t.group, t.tf);
                break;
            case RIGHT:
               new Bullet(t.x + ResourceMgr.goodTankR.getWidth() / 2 - ResourceMgr.bulletR.getWidth() / 2 + 20, t.y + ResourceMgr.goodTankR.getHeight() / 2 - ResourceMgr.bulletR.getHeight() / 2 + 1, t.dir, t.group, t.tf);
                break;
            case UP:
                new Bullet(t.x + ResourceMgr.goodTankU.getWidth() / 2 - ResourceMgr.bulletU.getWidth() / 2 + 1, t.y + ResourceMgr.goodTankU.getHeight() / 2 - ResourceMgr.bulletU.getHeight() / 2 - 20, t.dir, t.group, t.tf);
                break;
            case DOWN:
                new Bullet(t.x + ResourceMgr.goodTankD.getWidth() / 2 - ResourceMgr.bulletD.getWidth() / 2 - 1, t.y + ResourceMgr.goodTankD.getHeight() / 2 - ResourceMgr.bulletD.getHeight() / 2 + 20, t.dir, t.group, t.tf);
                break;
            default:
                break;
        }
    }
}
