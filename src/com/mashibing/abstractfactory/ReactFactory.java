package com.mashibing.abstractfactory;

import com.mashibing.Dir;
import com.mashibing.Group;
import com.mashibing.ReactBullet;
import com.mashibing.TankFrame;

public class ReactFactory extends AbstractFactory {
    @Override public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new ReactBullet(x, y, dir, group, tf);
    }

    @Override public BaseExpload createExpload() {
        return null;
    }
}
