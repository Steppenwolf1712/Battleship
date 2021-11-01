package de.ni.fun.battleship.control.network;

import java.io.Serializable;

public class PlayerData implements Serializable {

    public final String name;

    public PlayerData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    };
}
