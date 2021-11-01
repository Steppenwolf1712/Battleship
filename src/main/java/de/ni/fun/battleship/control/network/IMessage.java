package de.ni.fun.battleship.control.network;

import java.util.Date;

public interface IMessage {

    public Date getTimeStamp();
    public String getMessage();
    public PlayerData getAuthor();
}
