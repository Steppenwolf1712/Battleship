package de.ni.fun.battleship.model;

import java.util.Observable;

public class GameState extends Observable {

    private static GameState single = null;

    private boolean ownTurn;

    private ShipAreasData ownData;
    private ShipAreasData enemyData;

    private GameState() {
         ownTurn = false;
    }

    public void setup(Settings settings) {
        ownData = new ShipAreasData(settings);
        enemyData = new ShipAreasData(settings);
    }

    public void refresh() {
        this.ownTurn = false;
        ownData.refreshData();
        enemyData.refreshData();
    }

    public ShipAreasData getOwnShipAreasData() {
        return ownData;
    }

    public ShipAreasData getEnemyShipAreasData() {
        return enemyData;
    }

    public static GameState getInstance() {
        if (single ==null)
            single = new GameState();
        return single;
    }


    public boolean isOwnTurn () {
        return ownTurn;
    }

    public void setTurn(boolean ownTurn) {
        this.ownTurn = ownTurn;
        setChanged();
        notifyObservers(this);
        clearChanged();
    }
}
