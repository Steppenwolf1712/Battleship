package de.ni.fun.battleship.model;

public class ClientModel implements IModel{

    private static ClientModel single = null;

    private ClientModel() {

    }

    public static ClientModel getInstance() {
        if (single == null)
            single = new ClientModel();
        return single;
    }
}
