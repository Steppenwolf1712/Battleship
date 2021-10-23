package de.ni.fun.battleship.view.gui.jframe;

import javax.swing.*;
import java.awt.*;

public class StartAndLogin extends JFrame {

    //Describtions
    private static final String TITLE = "Anmeldung beim BattleShip-Netzwerk";
    private static final String LOGINTEXT = "Anmelden";
    private final String dialogContent = "<html><body><h1>Willkommen bei BattleShip</h1><br>Geben Sie Ihren Namen und einen Benutzernamen ein, um sich beim BattleShip-Netzwerk anzumelden!</body></html>";
    private final String hintName = "Name:";
    private final String hintUserName = "Benutzername";
    private final String hintPassword = "Password"; // TODO Hier müsste man eigentlich noch über eine Anmeldung und das Schützen von Userdaten wie Rekorden7Statisken nachdenken!

    //GUI-Elements
    private JPanel panel_mainBorder;
    private JLabel label_mainDialog;
    private JLabel label_hintName;
    private JTextField tf_name;
    private JLabel label_hintUserName;
    private JButton b_login;
    private JTextField tf_userName;

    public StartAndLogin(int width, int height) {
        super(StartAndLogin.TITLE);
        this.setSize(width, height);
        init();
        //this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void init() {
        //TODO: Wie bekomme ich einen Abstand hin?
        //this.setLayout();

        Container mainPanel = this.getContentPane();

        panel_mainBorder = new JPanel();
        panel_mainBorder.setLayout(new BoxLayout(panel_mainBorder, BoxLayout.Y_AXIS));
        panel_mainBorder.setBorder(BorderFactory.createLineBorder(Color.black));
        //panel_mainBorder.setBounds(5,5, mainPanel.getWidth()-10, (int)(mainPanel.getHeight()-10));
        this.add(panel_mainBorder);

        label_mainDialog = new JLabel(dialogContent);
        //label_mainDialog.setHorizontalTextPosition(JLabel.CENTER);
        label_mainDialog.setSize(new Dimension(panel_mainBorder.getWidth(), 200));
        panel_mainBorder.add(label_mainDialog);

        panel_mainBorder.add(Box.createRigidArea(new Dimension(0, 5)));

        label_hintName = new JLabel(hintName);
        label_hintName.setHorizontalTextPosition(JLabel.LEFT);
        panel_mainBorder.add(label_hintName);

        tf_name = new JTextField();
        panel_mainBorder.add(tf_name);

        label_hintUserName = new JLabel(hintUserName);
        label_hintUserName.setHorizontalTextPosition(JLabel.LEFT);
        panel_mainBorder.add(label_hintUserName);

        tf_userName = new JTextField();
        panel_mainBorder.add(tf_userName);

        b_login = new JButton(LOGINTEXT);
        panel_mainBorder.add(b_login);
    }
}
