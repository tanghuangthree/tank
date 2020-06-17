package com.mashibing;

import java.awt.*;

public class TailDecorator extends GODecorator{

    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override protected void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawLine(go.x, go.y, go.x + getWidth(), go.y + getHight());
        g.setColor(c);
    }

    @Override protected int getWidth() {
        return super.go.getWidth();
    }

    @Override protected int getHight() {
        return super.go.getHight();
    }
}
