package de.ni.fun.battleship.control.network.client;

import com.blogspot.debukkitsblog.net.Client;
import com.blogspot.debukkitsblog.net.Datapackage;
import com.blogspot.debukkitsblog.net.Executable;
import de.ni.fun.battleship.control.network.MethodID;
import de.ni.fun.battleship.control.network.PlayerData;
import de.ni.fun.battleship.view.console.Printer;

import java.net.Socket;


public class BattleNetClient extends Client implements Executable {

    public BattleNetClient(String serverAddress, int ServerPort, String id, String group) {
        super(serverAddress, ServerPort, 300, false, false, id, group);
    }

    public void connect() {

        registerMethod(MethodID.LOGINBATTLENETUSER, this);
        registerMethod(MethodID.LOGOUTBATTLENETUSER, this);

        start();
    }

    public void loginUser(PlayerData data) {
        String answer = (String)sendMessage(new Datapackage(MethodID.INITIALCONNECTION, data)).get(1);
        Printer.getInstance().printMsg(this, "Antwort des Servers auf Login: "+answer);


    }

    @Override
    public void run(Datapackage datapackage, Socket socket) {
        String methodID = (String)datapackage.get(0);
        Printer.getInstance().printMsg(this, "Im BallteNetClient ist folgender Datapackage-Typ angekommen: "+methodID);
        switch (methodID) {
            case MethodID.LOGINBATTLENETUSER:

                break;
            case MethodID.LOGOUTBATTLENETUSER:

                break;
        }
    }
}
