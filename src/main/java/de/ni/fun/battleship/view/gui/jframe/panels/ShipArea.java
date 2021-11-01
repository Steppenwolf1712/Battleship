package de.ni.fun.battleship.view.gui.jframe.panels;

import de.ni.fun.battleship.model.Settings;

import javax.swing.*;

public class ShipArea extends JPanel {

    private int size;

    public ShipArea(Settings setting, boolean enemyArea) {
        this.size = setting.getGameSize();
    }
}
