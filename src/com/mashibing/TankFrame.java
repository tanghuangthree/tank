package com.mashibing;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.mashibing.Dir.*;

public class TankFrame extends Frame {
    public static final int GAME_WIDTH = 800, GAME_HIGHT = 600;

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
        GameModel.getInstance().paint(g);
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
                    GameModel.getInstance().goodTank.fire();
                    new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
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
            Tank goodTank = GameModel.getInstance().goodTank;
            if (!bL && !bR && !bU && !bD) {
                goodTank.setMoving(false);
            } else {
                goodTank.setMoving(true);
                new Thread(() -> new Audio("audio/tank_move.wav").play()).start();
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
