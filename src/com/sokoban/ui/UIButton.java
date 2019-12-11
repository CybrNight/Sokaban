package com.sokoban.ui;

import com.sokoban.main.STATE;

import java.awt.*;

public class UIButton extends UIObject {

    String text;
    Font font;
    Color color;

    int width;
    int height;

    public UIButton(int x, int y, int width, int height, String text, Color color, Font font, STATE gameState) {
        super(x, y, gameState);
        this.text = text;
        this.color = color;
        this.font = font;
        this.width = width;
        this.height = height;
    }

    public UIButton(int x, int y, int width, int height, String text, Color color, STATE gameState) {
        super(x, y, gameState);
        this.text = text;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        if (font == null) g.setFont(defaultFont);
        int heightOffset = g.getFontMetrics().getHeight();
        g.drawString(text, x + width / 2 - getStringWidth(g, text) / 2, y + height / 2 + heightOffset / 3);
        g.drawRect(x, y, width, height);
    }

    public void tick() {
        // TODO Auto-generated method stub

    }

    public boolean mouseOver(int mx, int my) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            }
        }
        return false;
    }
}
