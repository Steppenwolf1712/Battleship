package de.ni.fun.battleship.view.gui.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginUser extends JFrame implements ActionListener {

    //Describtions
    private static final String TITLE = "Battleship: Anmelden";
    private final String LOGINTEXT = "Anmelden";
    private final String REGISTERTEXT = "Registrieren";
    private final String DIALOGCONTENT = "<html><body><h1>Willkommen bei BattleShip</h1><br>Geben Sie Ihren Benutzernamen und ihr Password ein,<br> um sich beim BattleShip-Netzwerk anzumelden!</body></html>";
    private final String DISPLAYUSERNAME = "Benutzername:";
    private final String DISPLAYPASSWORD = "Passwort:";

    //GUI-Elements
    //private JPanel panel_mainBorder;
    private JLabel label_mainDialog;
    private JLabel label_hintUserName;
    private JTextField tf_name;
    private JLabel label_hintPassword;
    private JButton btn_login;
    private JTextField tf_userName;
    private JButton btn_register;

    private boolean canRegister;

    public LoginUser(boolean canRegister) {
        super(LoginUser.TITLE);
        this.canRegister = canRegister;
        init();
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void init() {
        //TODO: Wie bekomme ich einen Abstand hin?

        JPanel mainPanel = (JPanel)this.getContentPane();

        mainPanel.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
        //panel_mainBorder = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        //mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        label_mainDialog = new JLabel(DIALOGCONTENT);
        label_mainDialog.setHorizontalTextPosition(JLabel.LEFT);
        this.add(label_mainDialog, BorderLayout.NORTH);

        //this.add(Box.createRigidArea(new Dimension(0, 5)));

        JPanel contentPanel = new JPanel(new BorderLayout());

        JPanel namePanel = new JPanel(new GridLayout(2,1));
        label_hintUserName = new JLabel(DISPLAYUSERNAME);
        label_hintUserName.setHorizontalTextPosition(JLabel.LEFT);
        namePanel.add(label_hintUserName);

        tf_name = new JTextField(1);
        tf_name.setHorizontalAlignment(JTextField.LEFT);
        namePanel.add(tf_name);
        contentPanel.add(namePanel, BorderLayout.NORTH);

        JPanel userNamePanel = new JPanel(new GridLayout(2,1));
        label_hintPassword = new JLabel(DISPLAYPASSWORD);
        label_hintPassword.setHorizontalTextPosition(JLabel.LEFT);
        userNamePanel.add(label_hintPassword);

        tf_userName = new JTextField(1);
        tf_userName.setHorizontalAlignment(JTextField.LEFT);
        userNamePanel.add(tf_userName);
        contentPanel.add(userNamePanel, BorderLayout.CENTER);

        this.add(contentPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new BorderLayout());
        btn_login = new JButton(LOGINTEXT);
        btn_login.addActionListener(this);
        btnPanel.add(btn_login, BorderLayout.WEST);

        if (canRegister) {
            btn_register = new JButton(REGISTERTEXT);
            btn_register.addActionListener(this);
            btnPanel.add(btn_register, BorderLayout.EAST);
        }
        this.add(btnPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
