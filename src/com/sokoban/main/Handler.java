package com.sokoban.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    public LinkedList <GameObject> gameObjects = new LinkedList <GameObject>();

    //Update all GameObjects
    public void tick() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            gameObject.tick();
        }
    }

    //Render all GameObjects
    public void render(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject gameObject = gameObjects.get(i);
            gameObject.render(g);
        }
    }

    public GameObject addObject(GameObject gameObject) {
        gameObjects.add(gameObject);
        return gameObject;
    }

    public GameObject removeObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
        return gameObject;
    }
}
