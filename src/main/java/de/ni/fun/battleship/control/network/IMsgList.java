package de.ni.fun.battleship.control.network;

import de.ni.fun.battleship.control.network.IMessage;

public interface IMsgList {

    public int getMsgSize();
    public IMessage getMsg(int index);
}
