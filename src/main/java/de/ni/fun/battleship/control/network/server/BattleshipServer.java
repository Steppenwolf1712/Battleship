package de.ni.fun.battleship.control.network.server;

import com.blogspot.debukkitsblog.net.Server;
import de.ni.fun.battleship.control.network.MethodID;
import de.ni.fun.battleship.control.network.server.methods.AWM_ListOfPlayers;
import de.ni.fun.battleship.control.network.server.methods.InitialisationMethod;
import de.ni.fun.battleship.control.network.server.security.PlayerRegistry;

public class BattleshipServer extends Server {

    public BattleshipServer(int port) {
        this(port, true, true, true);
    }

    public BattleshipServer(int port, boolean autoRegistrerEveryLient, boolean keepConnectionAlive, boolean useSSL) {
        super(port, autoRegistrerEveryLient, keepConnectionAlive, useSSL);
        PlayerRegistry.getInstance(); //Stellt sicher, dass die Playerregsirty initialisiert ist.
    }

    @Override
    public void preStart() {

        System.out.println("BattleShip-Server startet!");

        this.registerMethod(MethodID.INITIALCONNECTION, new InitialisationMethod(this));
        this.registerMethod(MethodID.REQUESTLISTOFPLAYERS, new AWM_ListOfPlayers(this));


    }
}
