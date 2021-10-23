package de.ni.fun.battleship.control.network.server.security;

import de.ni.fun.battleship.control.network.Communications;
import de.ni.fun.battleship.control.network.MethodID;

public class AlreadyRegisteredException extends Exception {

    public AlreadyRegisteredException() {
        super(Communications.ANSWERLOGINFAILURE);
    }
}
