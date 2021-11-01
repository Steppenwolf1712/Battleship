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
@Deprecated
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

    @Override
    public void askLogin() {

    }

    @Override
    public void askRegistration() {

    }

    @Override
    public void askSettings() {

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
