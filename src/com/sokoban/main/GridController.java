package com.sokoban.main;

import com.sokoban.object.*;

import java.io.*;
import java.util.LinkedList;

public class GridController {

    public static final int gridSize = 64;
    public int gridHeight = (Game.WIDTH / gridSize);
    public int gridLength = Game.HEIGHT / gridSize;
    public LinkedList <GameObject> goals = new LinkedList <>();

    protected String[][] charGrid = new String[gridHeight][gridLength];

    private Handler handler;
    private String loadedLevel;

    public GridController(Handler handler) {
        this.handler = handler;
    }

    public void loadLevel(String level) throws IOException {
        File file = new File("./resources/" + level);


        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        int row = 0;
        while ((line = br.readLine()) != null) {
            String[] array1 = line.split(",");
            charGrid[row] = array1;
            row++;
        }

        //Iterate through charGrid and place goal object
        for (int i = 0; i < charGrid.length; i++) {
            for (int j = 0; j < charGrid[i].length; j++) {
                if (charGrid[j][i] == null) continue;

                if (charGrid[j][i].equals("G")) {
                    GameObject goal = handler.addObject(new Goal(i * gridSize,
                            j * gridSize, gridSize, gridSize, ID.Goal, false));
                    goals.add(goal);
                }
            }
        }

        //Iterate through character grid and place objects
        for (int i = 0; i < charGrid.length; i++) {
            for (int j = 0; j < charGrid[i].length; j++) {
                if (charGrid[j][i] == null) continue;

                switch (charGrid[j][i]) {
                    case "W":
                        handler.addObject(new Wall(i * gridSize,
                                j * gridSize,
                                gridSize
                                , gridSize, ID.Wall, true));
                        break;
                    case "B":
                        handler.addObject(new Box(i * gridSize,
                                j * gridSize, gridSize, gridSize, ID.Box,
                                true));
                        break;
                    case "P":
                        handler.addObject(new Player(i * gridSize,
                                j * gridSize, gridSize, gridSize, ID.Player,
                                false));
                        break;
                }
            }
        }

        br.close();
        loadedLevel = level;
    }

    public void resetLevel() throws IOException {
        handler.gameObjects.clear();
        loadLevel(loadedLevel);
    }

    public void tick() {
        int goalCount = 0;
        for (int i = 0; i < goals.size(); i++) {
            GameObject goal = goals.get(i);
            if (getObject((int) goal.x, (int) goal.y).getId() == ID.Box) {
                goalCount++;
            }
        }

        if (goalCount >= goals.size()) {
            System.out.println("Win!");
        }
    }

    public GameObject getObject(int x, int y) {
        LinkedList <GameObject> objectsAtLocation = new LinkedList <>();
        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);
            if (tempObject.x == x && tempObject.y == y)
                objectsAtLocation.add(tempObject);
        }
        if (objectsAtLocation.size() == 1) {
            return objectsAtLocation.get(0);
        } else {
            for (GameObject gameObject : objectsAtLocation) {
                if (gameObject.getId() != ID.Goal) {
                    return gameObject;
                }
            }
        }
        return null;
    }

    public boolean isOpen(int x, int y) {
        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);
            ;
            if (tempObject.getX() == x && tempObject.y == y)
                if (tempObject.getSolid()) return false;
        }
        return true;
    }
}
