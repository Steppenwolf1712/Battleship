package de.ni.fun.battleship.view.console;

public class WaitingThread extends Thread {

    public final static Object obj = new Object();

    private boolean shutdown = false;

    public synchronized void run() {
        shutdown = false;
        System.out.print("Warte auf einen anderen Spieler ... -");
        try {
            int counter = 0;
            while (!shutdown) {
                switch (counter) {
                    case 0:
                        System.out.print("\b\\");
                        this.wait(500L);
                        counter++;
                        break;
                    case 1:
                        System.out.print("\b|");
                        this.wait(500L);
                        counter++;
                        break;
                    case 2:
                        System.out.print("\b/");
                        this.wait(500L);
                        counter++;
                        break;
                    case 3:
                        System.out.print("\b-");
                        this.wait(500L);
                        counter = 0;
                        break;
                    default:
                        break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void doStop() {
        shutdown = true;
    }
}
