package com.sokoban.object;

import com.sokoban.main.GameObject;
import com.sokoban.main.ID;

import java.awt.*;

public class Box extends GameObject {

    private float velX;
    private float velY;

    private boolean onGoal;

    public Box(float x, float y, int width, int height, ID id, boolean solid) {
        super(x, y, width, height, id, solid);
    }

    public void tick() {

    }


    public void render(Graphics g) {
        g.setColor(Color.yellow);
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

    public boolean getOnGoal() {
        return onGoal;
    }
}
