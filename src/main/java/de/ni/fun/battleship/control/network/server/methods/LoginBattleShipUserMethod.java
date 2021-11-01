package de.ni.fun.battleship.control.network.server.methods;

import com.blogspot.debukkitsblog.net.Datapackage;
import com.blogspot.debukkitsblog.net.Executable;
import com.blogspot.debukkitsblog.net.Server;
import de.ni.fun.battleship.control.network.Communications;
import de.ni.fun.battleship.control.network.PlayerData;
import de.ni.fun.battleship.control.network.server.security.AlreadyRegisteredException;
import de.ni.fun.battleship.control.network.server.security.PlayerRegistry;

import java.net.Socket;

public class LoginBattleShipUserMethod implements Executable {

    Server server;

    public LoginBattleShipUserMethod(Server server) {
        this.server = server;
    }

    @Override
    public void run(Datapackage datapackage, Socket socket) {

        PlayerData data = (PlayerData)datapackage.get(1);
        try {
            PlayerRegistry.getInstance().registerPlayer(data);
            server.sendReply(socket, Communications.ANSWERLOGINSUCCESS);
        } catch (AlreadyRegisteredException ex) {
            server.sendReply(socket, ex.getMessage());
        }
    }
}
