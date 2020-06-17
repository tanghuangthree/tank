package com.mashibing;

import java.awt.*;

public class Expload extends GameObject {
    public static final int WIDTH = ResourceMgr.exploads[0].getWidth(), HIGHT = ResourceMgr.exploads[0].getHeight();
    private int step = 0;

    public Expload(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override public void paint(Graphics g) {
        g.drawImage(ResourceMgr.exploads[step++], x, y, null);
        if (step >= ResourceMgr.exploads.length) {
            step = 0;
            GameModel.getInstance().remove(this);
        }
    }

    @Override protected int getWidth() {
        return WIDTH;
    }

    @Override protected int getHight() {
        return HIGHT;
    }
}
