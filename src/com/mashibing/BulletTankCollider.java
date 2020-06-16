package com.mashibing;

public class BulletTankCollider implements Collider{
    @Override public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet bullet = (Bullet)o1;
            Tank tank = (Tank)o2;
            if (bullet.group.equals(tank.getGroup())) {
                return true;
            }
            if (bullet.rect.intersects(tank.rect)) {
                bullet.die();
                tank.die();
                int eX = tank.getX() + Tank.WIDTH / 2 - Expload.WIDTH / 2;
                int eY = tank.getY() + Tank.HIGHT / 2 - Expload.HIGHT / 2;
                GameModel.getInstance().add(new Expload(eX, eY));
                new Thread(() -> new Audio("audio/explode.wav").play()).start();
                return false;
            }
        }
        if (o2 instanceof Bullet && o1 instanceof Tank) {
            collide(o2,o1);
        }
        return true;
    }
}
