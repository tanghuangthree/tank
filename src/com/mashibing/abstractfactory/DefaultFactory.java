package com.mashibing.abstractfactory;

import com.mashibing.Bullet;
import com.mashibing.Dir;
import com.mashibing.Group;
import com.mashibing.TankFrame;

public class DefaultFactory extends AbstractFactory {

    @Override public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Bullet(x, y, dir, group, tf);
    }

    @Override public BaseExpload createExpload() {
        return null;
    }
}
