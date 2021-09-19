package de.ni.fun.battleship.control.network.server.security;

import de.ni.fun.battleship.control.network.ISecurityToken;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

public class SecurityTokenFactory {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    private static  SecurityTokenFactory single = null;

    private SecurityTokenFactory() {

    }

    public static SecurityTokenFactory getInstance() {
        if (single == null)
            single = new SecurityTokenFactory();
        return single;
    }

    public ISecurityToken generateToken() {
        Date creationTime = new Date();

        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        String token = base64Encoder.encodeToString(randomBytes);

        return new SecurityToken(creationTime, token);
    }
}
