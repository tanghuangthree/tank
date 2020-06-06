package com.mashibing;

import com.mashibing.vo.Dir;
import com.mashibing.vo.Tank;
import com.mashibing.vo.TankFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        //  初始化敌方坦克
        for (int i = 0; i < 5; i++) {
            tankFrame.tanks.add(new Tank(100 + (i * 100), 200, Dir.DOWN, tankFrame));
        }

        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
