package com.mashibing.vo;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.mashibing.vo.Dir.*;

public class TankFrame extends Frame {
    private static final int GAME_WIDTH = 800, GAME_HIGHT = 600;
    private Tank tank = new Tank(200, 200, DOWN);
    private Bullet bullet = new Bullet(200, 200, DOWN);

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
        tank.paint(g);
        bullet.paint(g);
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
            tank.setMoving(!bL && !bR && !bU && !bD);
            if (bL) {
                tank.setDir(LEFT);
            }
            if (bR) {
                tank.setDir(RIGHT);
            }
            if (bU) {
                tank.setDir(UP);
            }
            if (bD) {
                tank.setDir(DOWN);
            }
        }

    }
}
