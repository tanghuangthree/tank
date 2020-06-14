package com.mashibing;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.mashibing.Dir.UP;

public class GameModel {
    public Tank goodTank = new Tank(200, 400, UP, Group.GOOD, false, this);

    List<GameObject> gm = new ArrayList<>();

    ColliderChain colliderChain = new ColliderChain();

    public GameModel() {
        System.out.println(PropertiesMgr.get("initTankCount"));
        int initTankCount = Integer.parseInt((String) PropertiesMgr.get("initTankCount"));
        //  初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(100 + (i * 100), 200, Dir.DOWN, Group.BAD, true, this));
        }
    }

    public void add(GameObject object) {
        gm.add(object);
    }

    public void remove(GameObject object) {
        gm.remove(object);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        /*g.drawString("子弹数量：" + bullets.size(), 10, 60);
        g.drawString("敌方坦克数量：" + badTanks.size(), 10, 80);*/
        g.setColor(c);
        goodTank.paint(g);

        for (int i = 0; i < gm.size(); i++) {
            gm.get(i).paint(g);
        }
        // 是使用for在遍历时，又去更改gm，会报java.util.ConcurrentModificationException异常，所以这里使用fori
        for (int i = 0; i < gm.size(); i++) {
            for (int j = i + 1; j < gm.size(); j++) {
                GameObject o1 = gm.get(i);
                GameObject o2 = gm.get(j);
                colliderChain.collide(o1, o2);
            }

        }
    }
}
