package de.ni.fun.battleship.control.network.server.security;

import de.ni.fun.battleship.control.network.ISecurityToken;

import java.util.Date;

public class SecurityToken implements ISecurityToken {

    private final Date creationDate;

    private final String tokenContent;

    SecurityToken(Date creationDate, String token) {
        this.creationDate = creationDate;
        tokenContent = token;
    }

    @Override
    public boolean isValid() {
        long difference = (new Date()).getTime()-this.creationDate.getTime();
        if (difference< PlayerRegistry.maxTokenDuration_in_ms)
            return true;
        return false;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }
}
