package de.ni.fun.battleship.model;

/**
 * In dieser Klasse sollen alle möglichen Einstellungen für das Spiel
 * gespeichert und für den Austausch mit dem Mitspieler vorbereitet werden.
 */
public class Settings implements ISettings {

    private int gameSize;

    private boolean noticeDestruction = false;

    private boolean seeOwnHistory = false;
    private boolean seeEnemyHistory = false;

    private ShipDefinitions ships;

    public Settings() {
        this(10, new ShipDefinitions(1, 3, 2, 1));
    }

    public Settings(int gameSize, ShipDefinitions definitions) {
        this(gameSize, definitions, true, true, true);
    }

    public Settings(int gameSize, ShipDefinitions definitions, boolean noticeDestruction, boolean seeOwnHistory, boolean seeEnemyHistory) {
        this.gameSize = gameSize;
        this.ships = definitions;
        this.noticeDestruction = noticeDestruction;
        this.seeOwnHistory = seeOwnHistory;
        this.seeEnemyHistory = seeEnemyHistory;
    }

    @Override
    public int getGameSize() {
        return this.gameSize;
    }

    @Override
    public boolean isNoticeDestructionOn() {
        return this.noticeDestruction;
    }

    @Override
    public boolean isOwnHistoryOn() {
        return this.seeOwnHistory;
    }

    @Override
    public boolean isEnemyHistoryOn() {
        return this.seeEnemyHistory;
    }

    @Override
    public ShipDefinitions getShipDefinitions() {
        return this.ships;
    }

}
