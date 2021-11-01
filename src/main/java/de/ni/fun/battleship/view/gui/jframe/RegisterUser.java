package de.ni.fun.battleship.view.gui.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUser extends JFrame implements ActionListener {

    private static final String TITLE = "BattleShip: Registrierung eines Spielers";
    private final String DIALOGCONTENT = "<html><body><h2>Willkommen bei BattleShip</h2>Geben Sie Ihren Namen, einen Benutzernamen und ein Passwort ein,<br> um sich beim BattleShip-Netzwerk zu registrieren!</body></html>";
    private final String DISPLAYNAME ="Name:";
    private final String DISPLAYUSERNAME = "Benutzername";
    private final String DISPLAYPASSWORD = "Passwort:";
    private final String DISPLAYPASSWORDREPEAT = "Passwort wiederholen:";
    private final String DISPLAYBTNREGISTER = "Registrieren";
    private final String DISPLAYBTNCANCEL = "Abbrechen";

    private JButton btn_register;
    private JButton btn_cancel;
    private JTextField tf_Name;
    private JTextField tf_UserName;
    private JPasswordField tf_Password;
    private JPasswordField tf_PasswordRepeat;

    public RegisterUser() {
        super(RegisterUser.TITLE);
        init();
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void init() {
        JPanel mainPanel = (JPanel)getContentPane();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
        mainPanel.setLayout(new BorderLayout());

        JLabel l_describtion = new JLabel(DIALOGCONTENT);
        l_describtion.setHorizontalAlignment(JLabel.LEFT);
        mainPanel.add(l_describtion, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new BorderLayout());
        JPanel namePanel = new JPanel(new BorderLayout());

        JLabel l_name = new JLabel(DISPLAYNAME);
        l_name.setHorizontalAlignment(JLabel.LEFT);
        namePanel.add(l_name, BorderLayout.NORTH);

        tf_Name = new JTextField(1);
        tf_Name.setHorizontalAlignment(JTextField.LEFT);
        namePanel.add(tf_Name, BorderLayout.CENTER);
        contentPanel.add(namePanel, BorderLayout.NORTH);

        JPanel userNamePanel = new JPanel(new BorderLayout());

        JLabel l_UserName = new JLabel(DISPLAYUSERNAME);
        l_UserName.setHorizontalAlignment(JLabel.LEFT);
        userNamePanel.add(l_UserName, BorderLayout.NORTH);

        tf_UserName = new JTextField(1);
        tf_UserName.setHorizontalAlignment(JTextField.LEFT);
        userNamePanel.add(tf_UserName, BorderLayout.CENTER);
        contentPanel.add(userNamePanel, BorderLayout.CENTER);

        JPanel passPanel = new JPanel(new BorderLayout());
        JPanel pass1Panel = new JPanel(new BorderLayout());
        JLabel l_pass1 = new JLabel(DISPLAYPASSWORD);
        l_pass1.setHorizontalAlignment(JLabel.LEFT);
        pass1Panel.add(l_pass1, BorderLayout.NORTH);

        tf_Password = new JPasswordField(1);
        tf_Password.setHorizontalAlignment(JPasswordField.LEFT);
        pass1Panel.add(tf_Password, BorderLayout.CENTER);
        passPanel.add(pass1Panel, BorderLayout.NORTH);

        JPanel pass2Panel = new JPanel(new BorderLayout());
        JLabel l_pass2 = new JLabel(DISPLAYPASSWORDREPEAT);
        l_pass2.setHorizontalTextPosition(JLabel.LEFT);
        pass2Panel.add(l_pass2, BorderLayout.NORTH);

        tf_PasswordRepeat = new JPasswordField();
        tf_PasswordRepeat.setHorizontalAlignment(JPasswordField.LEFT);
        pass2Panel.add(tf_PasswordRepeat, BorderLayout.CENTER);
        passPanel.add(pass2Panel, BorderLayout.CENTER);
        contentPanel.add(passPanel, BorderLayout.SOUTH);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new BorderLayout());
        JPanel btnPanel2 = new JPanel(new BorderLayout());

        btn_register = new JButton(DISPLAYBTNREGISTER);
        btn_register.setHorizontalAlignment(JButton.RIGHT);
        btn_register.addActionListener(this);
        btnPanel2.add(btn_register, BorderLayout.EAST);
        btnPanel.add(btnPanel2, BorderLayout.CENTER);

        btn_cancel = new JButton(DISPLAYBTNCANCEL);
        btn_register.setHorizontalAlignment(JButton.LEFT);
        btn_register.addActionListener(this);
        btnPanel.add(btn_cancel, BorderLayout.EAST);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
