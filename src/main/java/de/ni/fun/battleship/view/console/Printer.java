package de.ni.fun.battleship.view.console;

import de.ni.fun.battleship.control.network.NetworkManager;

public class Printer {

    private static Printer single;

    private Printer() {

    }

    public static Printer getInstance() {
        if (single == null)
            single = new Printer();
        return single;
    }

    public void printError (Object obj, String msg, Exception ex) {
        System.out.println(obj.getClass().getName()+ ": "+msg+"\nError because of "+ex.toString());
    }

    public void printError(Object obj, Exception ex) {
        System.out.println(obj.getClass().getName()+": "+ex.toString());
    }

    public void printMsg(Object obj, String msg) {
        System.out.println(obj.getClass().getName() + msg);
    }
}

