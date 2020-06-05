package com.mashibing;

import com.mashibing.vo.TankFrame;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        while (true) {
            Thread.sleep(500);
            tankFrame.repaint();
        }
    }
}
