package de.ni.fun.battleship.view.gui.jframe.panels;

import de.ni.fun.battleship.control.network.IMessage;
import de.ni.fun.battleship.control.network.IMsgList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LobbyChat extends JPanel implements ActionListener {

    private static final String DISPLAYBTNSENMSG = "Nachricht senden";
    private ArrayList<IMessage> messages;
    private JPanel p_Messages;
    private JTextArea msgArea;
    private JButton btn_SendMessage;

    public LobbyChat() {
        this(new IMsgList() {
            @Override
            public int getMsgSize() {
                return 0;
            }

            @Override
            public IMessage getMsg(int index) {
                return null;
            }
        });
    }

    public LobbyChat(IMsgList list) {
        messages = new ArrayList<IMessage>();
        for (int i = 0; i< list.getMsgSize(); i++) {
            messages.add(0, list.getMsg(i));
        }
        init();
    }

    public void init() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(3,3,0,3));

        p_Messages = new JPanel();
        p_Messages. setLayout(new BoxLayout(p_Messages, BoxLayout.Y_AXIS));
        p_Messages.setBackground(Color.WHITE);
        JScrollPane scrollPanel = new JScrollPane(p_Messages);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        add(scrollPanel, BorderLayout.CENTER);

        JPanel p_writing = new JPanel(new BorderLayout());
        p_writing.setBorder(BorderFactory.createEmptyBorder(0,0,3,0));

        msgArea = new JTextArea();
        msgArea.setMinimumSize(new Dimension(300, 45));
        msgArea.setPreferredSize(new Dimension(300, 45));
        p_writing.add(msgArea, BorderLayout.CENTER);

        btn_SendMessage = new JButton(DISPLAYBTNSENMSG);
        btn_SendMessage.addActionListener(this);
        p_writing.add(btn_SendMessage, BorderLayout.EAST);
        add(p_writing, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
