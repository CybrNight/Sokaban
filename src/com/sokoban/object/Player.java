package com.sokoban.object;

import com.sokoban.main.GameObject;
import com.sokoban.main.ID;

import java.awt.*;

public class Player extends GameObject {

    private float velX;
    private float velY;

    public Player(float x, float y, int width, int height, ID id,
                  boolean solid) {
        super(x, y, width, height, id, solid);
    }

    public void tick() {
        x += velX;
        y += velY;
    }


    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, (int) width, (int) height);
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }
}
