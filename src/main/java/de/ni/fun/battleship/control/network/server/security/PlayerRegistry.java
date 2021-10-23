package de.ni.fun.battleship.control.network.server.security;

import de.ni.fun.battleship.control.network.ISecurityToken;
import de.ni.fun.battleship.control.network.PlayerData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerRegistry implements Serializable {

    Map<String, RegisteredPlayerData> registeredPlayers;
    SecurityTokenValidationProcess validationProcess;

    public static PlayerRegistry single;

    public static final long maxTokenDuration_in_ms = 1800000;

    private PlayerRegistry() {
        registeredPlayers = new HashMap<String, RegisteredPlayerData>();
        validationProcess = new SecurityTokenValidationProcess();
        validationProcess.run();
    }

    public static PlayerRegistry getInstance() {
        if ( single == null)
            single = new PlayerRegistry();
        return single;
    }

    public List<PlayerData> getListOfPlayers() {
        List<PlayerData> answer = new ArrayList<PlayerData>();

        for (RegisteredPlayerData data: registeredPlayers.values())
            answer.add(data.getData());

        return answer;
    }

    public ISecurityToken registerPlayer(PlayerData player) throws AlreadyRegisteredException {
        if (registeredPlayers.containsKey(player.name))
            throw new AlreadyRegisteredException();
        RegisteredPlayerData regPlayer = new RegisteredPlayerData(player);

        registeredPlayers.put(regPlayer.getNameOfPlayer(), regPlayer);
        return regPlayer.getSecurityToken();
    }
}
