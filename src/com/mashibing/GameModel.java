package com.mashibing;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.mashibing.Dir.UP;

public class GameModel {
    public Tank goodTank = new Tank(200, 400, UP, Group.GOOD, false, this);
    public java.util.List<Bullet> bullets = new ArrayList<>();
    public java.util.List<Tank> badTanks = new ArrayList<>();
    public List<Expload> exploads = new ArrayList<>();

    public GameModel() {
        System.out.println(PropertiesMgr.get("initTankCount"));
        int initTankCount = Integer.parseInt((String) PropertiesMgr.get("initTankCount"));
        //  初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            badTanks.add(new Tank(100 + (i * 100), 200, Dir.DOWN, Group.BAD, true, this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量：" + bullets.size(), 10, 60);
        g.drawString("敌方坦克数量：" + badTanks.size(), 10, 80);
        g.setColor(c);
        goodTank.paint(g);

        for (int i = 0; i < badTanks.size(); i++) {
            badTanks.get(i).paint(g);
        }
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < exploads.size(); i++) {
            exploads.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < badTanks.size(); j++) {
                bullets.get(i).collideWith(badTanks.get(j));
            }
        }
    }
}
