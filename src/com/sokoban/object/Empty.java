package com.sokoban.object;

import com.sokoban.main.GameObject;
import com.sokoban.main.ID;

import java.awt.*;

public class Empty extends GameObject {

    public Empty(float x, float y, int width, int height, ID id,
                 boolean solid) {
        super(x, y, width, height, id, solid);
    }

    public void tick() {

    }


    public void render(Graphics g) {

    }
}
