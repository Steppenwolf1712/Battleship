package de.ni.fun.battleship.view.gui.jframe;

import de.ni.fun.battleship.model.GameState;
import de.ni.fun.battleship.model.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrameTest {

    public static void main(String args[]) {
        GameFrame testFrame = new GameFrame(new Settings());

        JFrame controlFrame = new JFrame();
        controlFrame.setLayout(new BorderLayout());

        JButton genShips = new JButton("Generiere Schiffe!");
        genShips.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testFrame.ownArea.generateShips();
            }
        });
        controlFrame.add(genShips, BorderLayout.NORTH);

        JButton changeGameState = new JButton("Ändere GameState ("+ GameState.getInstance().isOwnTurn()+")");
        changeGameState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameState.getInstance().setTurn(!GameState.getInstance().isOwnTurn());
                changeGameState.setText("Ändere GameState ("+ GameState.getInstance().isOwnTurn()+")");
            }
        });
        controlFrame.add(changeGameState, BorderLayout.CENTER);

        controlFrame.pack();
        controlFrame.setVisible(true);
    }
}
