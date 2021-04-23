package de.ni.fun.battleship.control.network;

import de.ni.fun.battleship.view.console.Printer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkManager implements INetworkManager {

    private static NetworkManager single;

    private final int port = 54321;
    private ServerSocket serverSocket;
    private Socket socket;

    public NetworkManager() {

    }

    public static INetworkManager getManager() {
        if (single == null)
            single = new NetworkManager();
        return single;
    }

    @Override
    public void waitForPlayer() throws IOException {
        serverSocket = new ServerSocket();
        Printer.getInstance().printMsg(this, "Serversocket auf port "+port+" gestartet!");

        socket = serverSocket.accept();


    }
}
