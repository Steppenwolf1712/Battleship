package de.ni.fun.battleship.view.console;

import de.ni.fun.battleship.model.Settings;
import de.ni.fun.battleship.view.IView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

/**
 * This Class describes a singleton Console class for simple representation and testings
 */
public class ConsoleView extends Observable implements IView {

    private static ConsoleView single = null;

    private WaitingThread waitingThread = null;

    private ConsoleView() {

    }

    public static ConsoleView getConsole() {
        if (single == null)
            single = new ConsoleView();
        return single;
    }

    public int askMode() {
        System.out.println("Willkommen zu Battleship!\nWollen Sie ein Spiel eröffnen (1) oder einem Spiel beitreten (2)?");
        System.out.print("Antwort:");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buffReader = new BufferedReader(reader);

        int mode = 0, temp;
        String answer = null;
        do {
            try {
                answer = buffReader.readLine();
                temp = Integer.parseInt(answer);

                if (answer.toLowerCase().equals("eröffnen") || temp == 1)
                    mode = 1;
                if (answer.toLowerCase().equals("beitreten") || temp == 2)
                    mode = 2;

                System.out.println("Geben Sie Ihre Wahl mit \"1\"/\"eröffnen\" oder \"2\"/\"beitreten\" an:");
                System.out.print("Antwort:");
            } catch (IOException e) {
                System.out.println("Ein Ein/Ausgabe-Fehler ist aufgetreten! Benutzen Sie für Ihre Antwort bitte einfache Zeichen!");
            }
        } while (mode != 0);
        return mode;
    }

    @Override
    public Settings askSettings() {
        return new Settings();
    }

    @Override
    public void waitForPlayer(Settings settings) {
        if (waitingThread == null)
            waitingThread = new WaitingThread();
        waitingThread.start();
    }

    @Override
    public void stopWaitingForPlayer() {
        waitingThread.doStop();
    }
}
