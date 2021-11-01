package de.ni.fun.battleship.view.gui.jframe.panels;

import javax.swing.*;
import java.awt.*;

public class LobbyList extends JPanel {

    public LobbyList() {
        init();
    }

    public void init() {
        setLayout(new BorderLayout());
        JTabbedPane mainPanel = new JTabbedPane();
        mainPanel.setMinimumSize(new Dimension(250, 400));
        mainPanel.setPreferredSize(new Dimension(250, 400));

        JPanel p_Player = new JPanel(new BorderLayout());
        mainPanel.addTab("Spieler", p_Player);

        JPanel p_Games = new JPanel(new BorderLayout());
        mainPanel.addTab("Games", p_Games);

        JPanel p_invites = new JPanel(new BorderLayout());
        mainPanel.addTab("Einladungen", p_invites);

        add(mainPanel, BorderLayout.CENTER);
    }
}
