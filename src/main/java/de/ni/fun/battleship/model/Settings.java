package de.ni.fun.battleship.model;

/**
 * In dieser Klasse sollen alle möglichen Einstellungen für das Spiel
 * gespeichert und für den Austausch mit dem Mitspieler vorbereitet werden.
 */
public class Settings {

    private int gameSize;

    private boolean noticeDestruction = false;

    private boolean seeOwnHistory = false;
    private boolean seeEnemyHistory = false;

    private int[] ships;

    public Settings() {
        gameSize = 10;
        ships = new int[]{0, 2, 3, 2, 1, 0, 0};
    }
}
