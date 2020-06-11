package com.mashibing;

import com.mashibing.abstractfactory.AbstractFactory;
import com.mashibing.abstractfactory.ReactFactory;

public class FourDirFireStrategy implements FireStrategy<Tank>{

    public AbstractFactory factory = new ReactFactory();

    @Override public void fire(Tank t) {
        for (Dir value : Dir.values()) {
            factory.createBullet(t.x + ResourceMgr.goodTankL.getWidth() / 2 - ResourceMgr.bulletL.getWidth() / 2 - 20, t.y + ResourceMgr.goodTankL.getHeight() / 2 - ResourceMgr.bulletL.getHeight() / 2 - 1, value, t.group, t.tf);
        }
    }
}
