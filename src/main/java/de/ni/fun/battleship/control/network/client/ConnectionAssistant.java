package de.ni.fun.battleship.control.network.client;

import com.blogspot.debukkitsblog.net.Client;
import com.blogspot.debukkitsblog.net.Datapackage;
import com.blogspot.debukkitsblog.net.Executable;
import de.ni.fun.battleship.control.network.MethodID;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;


public class ConnectionAssistant extends Client implements Executable {

    public ConnectionAssistant(String serverAddress, int ServerPort, String id, String group) {
        super(serverAddress, ServerPort, 300, false, false, id, group);
    }

    public void connect() {

        registerMethod(MethodID.INITIALCONNECTION, this);

        start();
    }

    @Override
    public void run(Datapackage datapackage, Socket socket) {
        String methodID = (String)datapackage.get(0);

        switch (methodID) {
            case MethodID.INITIALCONNECTION:

                break;
        }
    }
}
