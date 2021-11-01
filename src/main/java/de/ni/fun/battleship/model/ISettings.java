package de.ni.fun.battleship.model;

public interface ISettings {

    public static final int[] SHIPSIZE = {2, 3, 4, 5, 6, 7, 8};

    public int getGameSize();
    public boolean isNoticeDestructionOn();
    public boolean isOwnHistoryOn();
    public boolean isEnemyHistoryOn();
    public ShipDefinitions getShipDefinitions();
}
