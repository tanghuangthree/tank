package com.mashibing;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        new Thread(() -> new Audio("audio/war1.wav").loop()).start();
        while (true) {
            Thread.sleep(100);
            tankFrame.repaint();
        }
    }
}
