package com.mashibing;

public class WallBulletCollider implements Collider {
    @Override public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Wall && o2 instanceof Bullet) {
            Wall wall = (Wall)o1;
            Bullet bullet = (Bullet)o2;
            if(wall.rect.intersects(bullet.rect)) {
               bullet.die();
            }
        }
        if (o2 instanceof Wall && o1 instanceof Bullet) {
            collide(o2, o1);
        }
        return true;
    }
}
