package de.ni.fun.battleship.control.network.server.methods;

import com.blogspot.debukkitsblog.net.Datapackage;
import com.blogspot.debukkitsblog.net.Executable;
import com.blogspot.debukkitsblog.net.Server;
import de.ni.fun.battleship.control.network.server.BattleshipServer;
import de.ni.fun.battleship.control.network.server.security.PlayerRegistry;

import java.net.Socket;

public class AWM_ListOfPlayers implements Executable {

    Server server;

    public AWM_ListOfPlayers(BattleshipServer server) {
        this.server = server;
    }

    @Override
    public void run(Datapackage datapackage, Socket socket) {
        server.sendReply(socket, PlayerRegistry.getInstance().getListOfPlayers());
    }
}
