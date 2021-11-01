package de.ni.fun.battleship.control.network.client;

import com.blogspot.debukkitsblog.net.Client;
import com.blogspot.debukkitsblog.net.Datapackage;
import com.blogspot.debukkitsblog.net.Executable;
import de.ni.fun.battleship.control.network.Communications;
import de.ni.fun.battleship.control.network.MethodID;
import de.ni.fun.battleship.control.network.PlayerData;
import de.ni.fun.battleship.view.console.Printer;

import java.net.Socket;
import java.util.List;


public class BattleshipClient extends Client implements Executable {

    private boolean isBusyPlaying;

    public BattleshipClient(String serverAddress, int ServerPort, String id, String group) {
        super(serverAddress, ServerPort, 300, false, true, id, group);
        isBusyPlaying = false;
    }

    public void connect() {

        registerMethod(MethodID.LOGINBATTLESHIPUSER, this);
        registerMethod(MethodID.LOGOUTBATTLESHIPUSER, this);

        start();
    }

    public boolean loginUser(PlayerData data) {
        String answer = (String)sendMessage(new Datapackage(MethodID.LOGINBATTLESHIPUSER, data)).get(1);
        Printer.getInstance().printMsg(this, "Antwort des Servers auf Login: "+answer);

        if (answer.equals(Communications.ANSWERLOGINSUCCESS))
            return true;
        else
            return false;

    }

    public List<PlayerData> askForPlayers() {
        List<PlayerData> answer = (List<PlayerData>) sendMessage(MethodID.REQUESTLISTOFPLAYERS, new String("NULL")).get(1);
        return answer;
    }

    public void setBusyPlaying(boolean isBusyPlaying) {
        this.isBusyPlaying = isBusyPlaying;
    }

    @Override
    public void run(Datapackage datapackage, Socket socket) {
        String methodID = (String)datapackage.get(0);
        Printer.getInstance().printMsg(this, "Im Battleship-Client ist folgender Datapackage-Typ angekommen: "+methodID);
        if (isBusyPlaying) {

        } else {
            switch (methodID) {
                case MethodID.LOGINBATTLESHIPUSER:

                    break;
                case MethodID.LOGOUTBATTLESHIPUSER:

                    break;
                case MethodID.PLAYINGUSERBUSY:

                    break;
                case MethodID.PLAYINGUSERSTOP:

                    break;
            }
        }
    }
}
