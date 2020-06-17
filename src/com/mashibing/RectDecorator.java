package com.mashibing;

import java.awt.*;

public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override protected void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;

        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(super.go.x, super.go.y, super.go.getWidth()+2, super.go.getHight()+2);
        g.setColor(c);
    }

    @Override protected int getWidth() {
        return super.go.getWidth();
    }

    @Override protected int getHight() {
        return super.go.getHight();
    }
}
