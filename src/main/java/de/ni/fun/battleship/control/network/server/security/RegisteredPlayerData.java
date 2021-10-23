package de.ni.fun.battleship.control.network.server.security;

import de.ni.fun.battleship.control.network.ISecurityToken;
import de.ni.fun.battleship.control.network.PlayerData;

public class RegisteredPlayerData {

    private PlayerData data;

    private ISecurityToken securityToken;

    public RegisteredPlayerData(PlayerData data) {
        this.data = data;

        securityToken = SecurityTokenFactory.getInstance().generateToken();
    }

    public boolean isRegistrationStillValid() {
        return securityToken.isValid();
    }

    public String getNameOfPlayer() {
        return this.data.name;
    }

    public PlayerData getData() {
        return data;
    }

    public ISecurityToken getSecurityToken() {
        return this.securityToken;
    }

    public ISecurityToken createNewSecurityToken() {
        securityToken = SecurityTokenFactory.getInstance().generateToken();
        return securityToken;
    }
}
