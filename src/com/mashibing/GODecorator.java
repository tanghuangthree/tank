package com.mashibing;

import java.awt.*;

public abstract class GODecorator extends GameObject{
    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override  protected abstract void paint(Graphics g);
}
