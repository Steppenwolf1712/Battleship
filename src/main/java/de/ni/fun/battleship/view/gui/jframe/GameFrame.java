package de.ni.fun.battleship.view.gui.jframe;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private JLabel l_status;

    public GameFrame() {
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



    }

    private String getStatus() {
        return "TestString";
    }
}
