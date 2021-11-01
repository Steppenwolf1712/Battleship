package de.ni.fun.battleship.view.gui.jframe;

import de.ni.fun.battleship.model.IModel;
import de.ni.fun.battleship.view.gui.jframe.panels.LobbyChat;
import de.ni.fun.battleship.view.gui.jframe.panels.LobbyList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lobby extends JFrame implements ActionListener {

    private static final String TITLE = "BattleShip: Lobby";
    private static final String DISPLAYBTNCREATEGAME = "Spiel erstellen";
    private static final String DISPLAYBTNLOGOUT = "Abmelden";
    private IModel model;

    private LobbyList list;
    private LobbyChat chat;
    private JButton btn_CreateGame;
    private JButton btn_Logout;

    public Lobby(IModel model) {
        super(Lobby.TITLE);
        this.model = model;
        init();
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
    }

    private void init() {
        JPanel mainPanel = (JPanel) getContentPane();
        mainPanel.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new BorderLayout());

        JLabel l_Status = new JLabel(createStatusText());
        l_Status.setHorizontalTextPosition(JLabel.LEFT);
        controlPanel.add(l_Status, BorderLayout.NORTH);

        list = new LobbyList();
        controlPanel.add(list, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new BorderLayout(0,0));
        btn_CreateGame = new JButton(DISPLAYBTNCREATEGAME);
        btn_CreateGame.addActionListener(this);
        btnPanel.add(btn_CreateGame, BorderLayout.NORTH);

        btn_Logout = new JButton(DISPLAYBTNLOGOUT);
        btn_Logout.addActionListener(this);
        btnPanel.add(btn_Logout, BorderLayout.SOUTH);
        controlPanel.add(btnPanel, BorderLayout.SOUTH);
        mainPanel.add(controlPanel, BorderLayout.WEST);

        chat = new LobbyChat();
        mainPanel.add(chat, BorderLayout.CENTER);
    }

    private String createStatusText() {

        return "TestString";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
