package com.sokoban.main;

import java.awt.*;

import com.sokoban.ui.Menu;
import com.sokoban.ui.UIHandler;

import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = -240968198586083206L;
    private Thread thread;
    private boolean running = false;

    public static final int WIDTH = 640, HEIGHT = 480;
    public static STATE gameState = STATE.Menu;

    Handler handler;
    UIHandler uiHandler;

    GridController gridController;
    Menu menu;

    public static void main(String[] args) throws IOException {
        new Game();
    }

    public Game() throws IOException {
        handler = new Handler();
        uiHandler = new UIHandler();

        gridController = new GridController(handler);

        menu = new Menu(this, uiHandler, gridController);

        this.addKeyListener(new KeyInput(this, handler, gridController));
        this.addMouseListener(menu);

        new Window("Sokoban", WIDTH, HEIGHT, this);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private synchronized void stop() {

    }

    private void tick() {
        handler.tick();
        uiHandler.tick();

        if (gameState == STATE.Game) {
            gridController.tick();
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, 640, 480);

        if (gameState == STATE.Game)
            handler.render(g);

        uiHandler.render(g);

        g.dispose();
        bs.show();
    }

    public void run() {
        //Game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }
}
