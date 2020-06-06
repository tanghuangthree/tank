package com.mashibing.vo;

import java.awt.*;

public class Expload {
    private int x, y;
    private TankFrame tf;
    private static final int WIDTH = ResourceMgr.exploads[0].getWidth(), HIGHT = ResourceMgr.exploads[0].getHeight();
    private int step = 0;

    public Expload(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.exploads[step++], x, y, null);
        if (step >= ResourceMgr.exploads.length) {
            step = 0;
        }
    }
}
