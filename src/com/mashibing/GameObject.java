package com.mashibing;

import java.awt.*;

public abstract class GameObject {
    int x, y;

    abstract protected void paint(Graphics g);
    abstract protected int getWidth();
    abstract protected int getHight();
}
