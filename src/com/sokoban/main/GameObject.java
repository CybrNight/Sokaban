package com.sokoban.main;

import java.awt.*;

public abstract class GameObject {

    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected ID id;
    protected boolean solid;

    public GameObject(float x, float y, int width, int height, ID id,
                      boolean solid) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        this.solid = solid;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public ID getId() {
        return id;
    }

    public boolean getSolid() {
        return solid;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
