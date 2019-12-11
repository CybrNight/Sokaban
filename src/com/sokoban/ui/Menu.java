package com.sokoban.ui;

import com.sokoban.main.Game;
import com.sokoban.main.GridController;
import com.sokoban.main.Handler;
import com.sokoban.main.STATE;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.LinkedList;

public class Menu extends MouseAdapter {

    public LinkedList <UIObject> menuObjects = new LinkedList <>();

    Font defaultFont = new Font("arial", 1, 50);

    Game game;
    GridController gridController;
    UIHandler uiHandler;
    UIButton playButton;

    public Menu(Game game, UIHandler uiHandler, GridController gridController) {
        this.game = game;
        this.gridController = gridController;
        this.uiHandler = uiHandler;

        uiHandler.addUIObject(new UIText(Game.WIDTH / 2, 50,
                "SOKOBAN", Color.white, STATE.Menu));
        playButton =
                (UIButton) uiHandler.addUIObject(new UIButton(
                        Game.WIDTH / 2 - 100, 100, 200, 64, "Play",
                        Color.white, STATE.Menu));
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (playButton.mouseOver(mx, my)) {
            try {
                gridController.loadLevel("level.dat");
                Game.gameState = STATE.Game;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void startGame() {

    }

    public void tick() {

    }

    public void render(Graphics g) {
    }
}
