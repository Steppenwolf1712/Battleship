package de.ni.fun.battleship.view;

import de.ni.fun.battleship.model.Settings;

public interface IView {

    /**
     * Makes the View ask for Server/Client Mode
     * <p>
     * returns Answer whether the game shall be hosted (1) oder be joined (2)
     */

    public void askLogin();
    public void askRegistration();
    public void askSettings();

    public void waitForPlayer(Settings settings);
    public void stopWaitingForPlayer();
}
