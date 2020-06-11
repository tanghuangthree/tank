package com.mashibing.abstractfactory;

import com.mashibing.Tank;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void collideWith(Tank tank);

    public abstract void paint(Graphics g);
}
