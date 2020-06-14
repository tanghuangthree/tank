package com.mashibing;

import java.awt.*;

public class Expload extends GameObject {
    private int x, y;
    private GameModel model;
    public static final int WIDTH = ResourceMgr.exploads[0].getWidth(), HIGHT = ResourceMgr.exploads[0].getHeight();
    private int step = 0;

    public Expload(int x, int y, GameModel model) {
        this.x = x;
        this.y = y;
        this.model = model;
    }

    @Override public void paint(Graphics g) {
        g.drawImage(ResourceMgr.exploads[step++], x, y, null);
        if (step >= ResourceMgr.exploads.length) {
            step = 0;
            model.remove(this);
        }
    }
}
