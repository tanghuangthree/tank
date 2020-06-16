package com.mashibing;

import java.awt.*;

public class Wall extends GameObject {
    private int width, height;
    public Rectangle rect;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new Rectangle(x, y, width, height);
    }


    @Override protected void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
        g.setColor(color);
    }
}
