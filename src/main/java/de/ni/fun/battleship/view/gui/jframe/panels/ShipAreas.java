package de.ni.fun.battleship.view.gui.jframe.panels;

import de.ni.fun.battleship.model.*;

import javax.swing.*;
import java.util.Random;

public class ShipAreas extends JPanel {

    private int gameSize;
    private Settings settings;
    private boolean isEnemyArea;

    private ShipArea[][] fields;

    public ShipAreas(Settings setting, boolean enemyArea) {
        this.gameSize = setting.getGameSize();
        this.settings = setting;
        this.isEnemyArea = enemyArea;

        GameState.getInstance().setup(this.settings);
        initFields();
    }

    public void initFields() {
        fields = new ShipArea[gameSize][gameSize];

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        ShipArea temp;
        JPanel fieldsline;

        for (int y = 0; y < gameSize; y++) {
            fieldsline = new JPanel();
            fieldsline.setLayout(new BoxLayout(fieldsline, BoxLayout.X_AXIS));
            for (int x = 0; x < gameSize; x++) {
                Coordinate position = new Coordinate(x,y);
                temp = new ShipArea(position, this);
                GameState.getInstance().getOwnShipAreasData().addObserver(position, temp);
                fields[y][x] = temp;
                fieldsline.add(temp);
            }
            this.add(fieldsline);
        }
    }

    public void hit(Coordinate position) {
        if (isEnemyArea) {
            //ToDo: Die logik für Competive muss noch umgesetzt werden
        } else {
            GameState.getInstance().getOwnShipAreasData().setHit(position);
        }
    }

    public void generateShips() {
        GameState.getInstance().refresh();
        ShipDefinitions defs = settings.getShipDefinitions();

        Coordinate pos;
        Random rand = new Random();
        boolean isHori;
        for (int size = 8; size>1; size--) {
            for (int numberOfShips = defs.getNumberofShipsByLength(size);numberOfShips>0;numberOfShips--) {
                isHori = rand.nextBoolean();
                if (isHori) {
                    pos = new Coordinate(rand.nextInt(gameSize -size), rand.nextInt(gameSize));
                } else {
                    pos = new Coordinate(rand.nextInt(gameSize), rand.nextInt(gameSize -size));
                }
                if (doesShipFit(pos, size, isHori)) {
                    GameState.getInstance().getOwnShipAreasData().placeShip(pos, size, isHori);
                } else {
                    numberOfShips++;
                }
            }
        }
    }

    public boolean doesShipFit(Coordinate startPosition, int length, boolean isHori) {
        System.out.println("Teste Position "+startPosition+" mit Länge "+length+" (Horizontal="+isHori+")");
        ShipAreasData data = GameState.getInstance().getOwnShipAreasData();
        boolean answer = false;
        for (int i = 0; i<length; i++) {
            if (isHori)
                answer = data.isShip(new Coordinate(startPosition.getX()+i, startPosition.getY()));
            else
                answer = data.isShip(new Coordinate(startPosition.getX(), startPosition.getY()+i));
            if (answer)
                return !answer;
        }
        return !answer;
    }

}
