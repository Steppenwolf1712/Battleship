package de.ni.fun.battleship.view.gui.jframe;

import de.ni.fun.battleship.model.ClientModel;

public class LobbyTest {
    public static void main(String args[]) {
        new Lobby(ClientModel.getInstance());
    }
}
