package com.sokoban.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class KeyInput extends KeyAdapter {


    private Handler handler;
    private Game game;
    private GridController grid;

    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;

    private final int gridSize = GridController.gridSize;

    int paddleSpeed = 10;

    KeyInput(Game game, Handler handler, GridController grid) {
        this.handler = handler;
        this.game = game;
        this.grid = grid;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_R) {
            try {
                grid.resetLevel();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //Iterate through all objects
        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject object = handler.gameObjects.get(i);

            if (object.getId() == ID.Player) {
                int x = (int) object.getX();
                int y = (int) object.getY();

                if (key == KeyEvent.VK_RIGHT && !right) {
                    right = true;

                    if (grid.isOpen(x + gridSize, y)) {
                        object.x += gridSize;
                    } else if (grid.getObject(x + gridSize, y).getId() == ID.Box
                            && grid.isOpen(x + gridSize * 2, y)) {
                        grid.getObject(x + gridSize, y).x += gridSize;
                        object.x += gridSize;
                    }
                }
                if (key == KeyEvent.VK_LEFT && !left) {
                    left = true;
                    if (grid.isOpen(x - gridSize, y)) {
                        object.x -= gridSize;
                    } else if (grid.getObject(x - gridSize, y).getId() == ID.Box
                            && grid.isOpen(x - gridSize * 2, y)) {
                        grid.getObject(x - gridSize, y).x -= gridSize;
                        object.x -= gridSize;
                    }
                }
                if (key == KeyEvent.VK_UP && !up) {
                    up = true;
                    if (grid.isOpen(x, y - gridSize)) {
                        object.y -= gridSize;
                    } else if (grid.getObject(x, y - gridSize).getId() == ID.Box &&
                            grid.isOpen(x, y - gridSize * 2)) {
                        grid.getObject(x, y - gridSize).y -= gridSize;
                        object.y -= gridSize;
                    }
                }
                if (key == KeyEvent.VK_DOWN && !down) {
                    down = true;
                    if (grid.isOpen(x, y + gridSize)) {
                        object.y += gridSize;
                    } else if (grid.getObject(x, y + gridSize).getId() == ID.Box &&
                            grid.isOpen(x, y + gridSize * 2)) {
                        grid.getObject(x, y + gridSize).y += gridSize;
                        object.y += gridSize;
                    }
                }
            }

        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT && left) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT && right) {
            right = false;
        }
        if (key == KeyEvent.VK_UP && up) {
            up = false;
        }
        if (key == KeyEvent.VK_DOWN && down) {
            down = false;
        }

    }
}
