package de.ni.fun.battleship.control.network;

import java.io.Serializable;
import java.util.Date;

public interface ISecurityToken extends Serializable {

    /**
     * Gibt zurück, ob das Token noch gültig ist (true) oder ob es schon abgelaufen ist (false).
     *
     * @return
     */
    public boolean isValid();

    /**
     * Gibt den Zeitpunkt zurück, zu dem das Token erstellt wurde.
     *
     * @return
     */
    public Date getCreationDate();
}
