package de.ni.fun.battleship.control.network.server.security;

public class AlreadyRegisteredException extends Exception {

    public AlreadyRegisteredException() {
        super("Der Player ist tatsächlich schon beim Battleship-Server angemeldet!");
    }
}
