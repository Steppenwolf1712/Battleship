package de.ni.fun.battleship.control.network.server.security;

import de.ni.fun.battleship.view.console.Printer;

public class SecurityTokenValidationProcess extends Thread {

    private boolean stopIt;

    public SecurityTokenValidationProcess() {
        stopIt = false;
    }

    public void run() {
        PlayerRegistry registry = PlayerRegistry.getInstance();
        while (!stopIt) {
            try {
                for (RegisteredPlayerData data : registry.registeredPlayers.values()) {
                    if (!data.isRegistrationStillValid()) {
                        registry.registeredPlayers.remove(data.getNameOfPlayer());
                        Printer.getInstance().printMsg(this.getClass(), "Der Player " + data.getNameOfPlayer() + " wurde wegen Inaktivität aus der Registry entfernt!");
                    }
                }

                this.wait(60000);
            } catch (InterruptedException e) {
                Printer.getInstance().printMsg(this.getClass(), "Die Validierung der PlayerRegistry wurde interrupted! Valiation stopt!");
            }
        }
    }

    public void stopValidation() {
        this.stopIt = true;
        this.interrupt();
    }
}
