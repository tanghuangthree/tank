package com.mashibing;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        System.out.println(PropertiesMgr.get("initTankCount"));

        int initTankCount = Integer.parseInt((String) PropertiesMgr.get("initTankCount"));
        //  初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tankFrame.badTanks.add(new Tank(100 + (i * 100), 200, Dir.DOWN, Group.BAD, true, tankFrame));
        }

        new Thread(() -> new Audio("audio/war1.wav").loop()).start();

        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
