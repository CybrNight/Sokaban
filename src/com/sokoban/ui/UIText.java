package com.sokoban.ui;

import com.sokoban.main.STATE;

import java.awt.*;

public class UIText extends UIObject {

    String text;
    Color color;
    Font font;

    public UIText(int x, int y, String text, Color color, Font font,
                  STATE gameState) {
        super(x, y, gameState);

        this.text = text;
        this.font = font;
        this.color = color;
    }

    public UIText(int x, int y, String text, Color color, STATE gameState) {
        super(x, y, gameState);

        this.text = text;
        this.color = color;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        if (font == null) g.setFont(defaultFont);
        int heightOffset = g.getFontMetrics().getHeight();
        g.drawString(text, x - getStringWidth(g, text) / 2,
                y + heightOffset / 3);
    }

    @Override
    public void tick() {

    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
