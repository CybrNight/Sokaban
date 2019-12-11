package com.sokoban.main;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    JFrame frame = new JFrame();

    public Window(String title, int width, int height, Game game) {
        frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(game);
        frame.requestFocus();
        game.start();
    }
}
