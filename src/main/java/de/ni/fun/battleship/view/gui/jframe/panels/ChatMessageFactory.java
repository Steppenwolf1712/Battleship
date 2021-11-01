package de.ni.fun.battleship.view.gui.jframe.panels;

import de.ni.fun.battleship.control.network.IMessage;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class ChatMessageFactory {

    private static ChatMessageFactory single = null;

    private ChatMessageFactory() {

    }

    public ChatMessageFactory getInstance() {
        if (single == null)
            single = new ChatMessageFactory();
        return single;
    }

    public JPanel createChatMessage(IMessage msg, boolean isSelf) {
        JPanel answer = new JPanel(new BorderLayout());

        JLabel l_author = new JLabel(msg.getAuthor().getName());
        answer.add(l_author, BorderLayout.NORTH);

        JLabel l_msg = new JLabel(msg.getMessage());
        answer.add(l_msg, BorderLayout.CENTER);

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy - hh:mm");
        JLabel l_date = new JLabel(format.format(msg.getTimeStamp()));
        answer.add(l_date, BorderLayout.SOUTH);

        if (isSelf) {
            answer.setBorder(BorderFactory.createEmptyBorder(3,16,3,3));
            l_author.setHorizontalTextPosition(JLabel.RIGHT);
            l_author.setHorizontalAlignment(JLabel.RIGHT);

        } else {
            answer.setBorder(BorderFactory.createEmptyBorder(3,1,3,16));
            l_date.setHorizontalAlignment(JLabel.RIGHT);
            l_date.setHorizontalTextPosition(JLabel.RIGHT);
        }
        return answer;
    }
}
