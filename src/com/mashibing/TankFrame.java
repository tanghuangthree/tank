package com.mashibing;


import com.mashibing.abstractfactory.AbstractFactory;
import com.mashibing.abstractfactory.BaseBullet;
import com.mashibing.abstractfactory.DefaultFactory;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import static com.mashibing.Dir.*;

public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 800, GAME_HIGHT = 600;
    public Tank goodTank = new Tank(200, 400, UP, Group.GOOD, false, this);
    public List<BaseBullet> bullets = new ArrayList<>();
    public List<Tank> badTanks = new ArrayList<>();
    public List<Expload> exploads = new ArrayList<>();


    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HIGHT);
        setResizable(false);
        setTitle("Tank War");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
    }

    @Override public void paint(Graphics g) {
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


    private void die(Tank tank) {
        badTanks.remove(tank);
    }

    Image offSrceenImage = null;

    @Override public void update(Graphics g) {
        if (offSrceenImage == null) {
            offSrceenImage = createImage(GAME_WIDTH, GAME_HIGHT);
        }
        Graphics imageGraphic = offSrceenImage.getGraphics();
        Color c = imageGraphic.getColor();
        imageGraphic.setColor(Color.BLACK);
        imageGraphic.fillRect(0, 0, GAME_WIDTH, GAME_HIGHT);
        imageGraphic.setColor(c);
        paint(imageGraphic);
        g.drawImage(offSrceenImage, 0, 0, null);

    }

    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_SHIFT:
                    try {
                       FireStrategy fireStrategy = (FireStrategy) Class.forName((String)PropertiesMgr.get("goodFireStrategy")).newInstance();
                        goodTank.fire(fireStrategy);
                        new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        public void setMainTankDir() {
            if (!bL && !bR && !bU && !bD) {
                goodTank.setMoving(false);
            } else {
                goodTank.setMoving(true);
                new Thread(()->new Audio("audio/tank_move.wav").play()).start();
            }

            if (bL) {
                goodTank.setDir(LEFT);
            }
            if (bR) {
                goodTank.setDir(RIGHT);
            }
            if (bU) {
                goodTank.setDir(UP);
            }
            if (bD) {
                goodTank.setDir(DOWN);
            }
        }

    }
}
