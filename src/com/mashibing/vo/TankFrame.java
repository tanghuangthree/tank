package com.mashibing.vo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    private int x = 200;
    private int y = 200;

    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override public void paint(Graphics g) {
        System.out.println("x,"+ x);
        System.out.println("y,"+ y);
        g.fillRect(x,y, 50,50);
        x += 10;
        y += 10;
    }
}
