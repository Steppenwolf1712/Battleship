package de.ni.fun.battleship.control.main;

import de.ni.fun.battleship.control.network.INetworkManager;
import de.ni.fun.battleship.control.network.NetworkManager;
import de.ni.fun.battleship.view.IView;
import de.ni.fun.battleship.model.Settings;
import de.ni.fun.battleship.view.console.ConsoleView;

import java.io.IOException;

/**
 * This File is the Main-Main file for executing/starting the project
 */
public class Main {

    public static final String MODE_CONSOLE = "Konsole";
    public static final String MODE_GUI = "GUI";

    public static IView view;
    public static INetworkManager netMngr;

    public static void main(String args[]) {

        if (args.length == 1 && args[0].equals(MODE_CONSOLE)) {
            view = ConsoleView.getConsole();

            int mode = view.askMode();
            if (mode == 1) {
                //Ask for Settings of the Game
                Settings settings = view.askSettings();

                netMngr = NetworkManager.getManager();
                view.waitForPlayer(settings);

                try {
                    netMngr.waitForPlayer();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            } else if (mode == 2){

            }
        } else {

        }
    }
}
