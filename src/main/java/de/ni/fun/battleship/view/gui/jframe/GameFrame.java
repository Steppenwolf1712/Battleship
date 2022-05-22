package de.ni.fun.battleship.view.gui.jframe;

import de.ni.fun.battleship.model.Settings;
import de.ni.fun.battleship.view.gui.jframe.panels.ShipAreas;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private JLabel l_status;
    public ShipAreas ownArea, enemyArea;

    private Settings settings;

    public GameFrame(Settings settings) {
        this.settings = settings;
        init();
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    public void init() {
        JPanel mainPanel = (JPanel)getContentPane();
        mainPanel.setLayout(new BorderLayout());

        l_status = new JLabel(getStatus());
        l_status.setHorizontalTextPosition(JLabel.CENTER);
        l_status.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(l_status, BorderLayout.NORTH);

        ownArea = new ShipAreas(this.settings, false);
        mainPanel.add(ownArea, BorderLayout.CENTER);
    }

    private String getStatus() {
        return "TestString";
    }
}
