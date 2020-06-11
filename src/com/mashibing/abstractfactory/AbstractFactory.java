package com.mashibing.abstractfactory;

import com.mashibing.Dir;
import com.mashibing.Group;
import com.mashibing.TankFrame;

public abstract class AbstractFactory {
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseExpload createExpload();
}
