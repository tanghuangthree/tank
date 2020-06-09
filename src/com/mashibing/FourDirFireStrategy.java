package com.mashibing;

public class FourDirFireStrategy implements FireStrategy<Tank>{
    @Override public void fire(Tank t) {
        for (Dir value : Dir.values()) {
            new Bullet(t.x + ResourceMgr.goodTankL.getWidth() / 2 - ResourceMgr.bulletL.getWidth() / 2 - 20, t.y + ResourceMgr.goodTankL.getHeight() / 2 - ResourceMgr.bulletL.getHeight() / 2 - 1, value, t.group, t.tf);
        }
    }
}
