package com.sokoban.ui;

import com.sokoban.main.STATE;

import java.awt.*;

public abstract class UIObject {

    protected int x;
    protected int y;

    protected STATE state;
    protected Font defaultFont;

    public UIObject(int x, int y, STATE state) {
        this.x = x;
        this.y = y;
        this.state = state;

        defaultFont = new Font("arial", Font.BOLD, 50);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public int getStringWidth(Graphics g, String string) {
        int width = g.getFontMetrics().stringWidth(string);
        return width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public STATE getState() {
        return state;
    }

}
