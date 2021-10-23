package de.ni.fun.battleship.control.main;

import de.ni.fun.battleship.control.network.client.BattleshipClient;
import de.ni.fun.battleship.control.network.server.BattleshipServer;
import de.ni.fun.battleship.view.IView;
import de.ni.fun.battleship.model.Settings;
import de.ni.fun.battleship.view.console.ConsoleView;
import de.ni.fun.battleship.view.console.Printer;

import java.util.Date;

/**
 * This File is the Main-Main file for executing/starting the project
 */
public class Main {

    public static final String MODE_CONSOLE = "Konsole";
    public static final String MODE_GUI = "GUI";
    public static final String MODE_SERVER = "SERVER";
    public static final String MODE_CLIENT = "CLIENT";

    public static final int SERVER_PORT = 58234;
    public static final String SERVER_URL = "home.jamadeluxe.de";

    public static IView view;

    public static void main(String args[]) {
        if (args.length < 2) {
            System.out.println("Achtung! Battleship kann nur mit mindestens zwei weiteren Argumenten gestartet werdem!");
            System.exit(0);
        }
        if (args[0].equals(MODE_SERVER)) {
            BattleshipServer server = new BattleshipServer(SERVER_PORT);

            server.preStart();
        } else if (args[0].equals(MODE_CLIENT)){
            String id = "Battle_Player"+(new Date()).getTime();
            String group = "Battleship_Player";

            BattleshipClient assist = new BattleshipClient(SERVER_URL, SERVER_PORT, id, group);


            if (args[1].equals(MODE_CONSOLE)) {
                view = ConsoleView.getConsole();


            }
        } else {

        }
    }
}
