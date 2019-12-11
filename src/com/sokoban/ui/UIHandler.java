package com.sokoban.ui;

import com.sokoban.main.Game;

import java.awt.*;
import java.util.LinkedList;

public class UIHandler {

    public LinkedList <UIObject> uiObjects = new LinkedList <>();

    public void tick() {
        for (int i = 0; i < uiObjects.size(); i++) {
            UIObject uiObject = uiObjects.get(i);
            if (uiObject.state == Game.gameState)
                uiObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < uiObjects.size(); i++) {
            UIObject uiObject = uiObjects.get(i);
            if (uiObject.state == Game.gameState)
                uiObject.render(g);
        }
    }

    public UIObject addUIObject(UIObject uiObject) {
        uiObjects.add(uiObject);
        return uiObject;
    }

    public void removeUIObject(UIObject uiObject) {
        uiObjects.remove(uiObject);
    }
}
