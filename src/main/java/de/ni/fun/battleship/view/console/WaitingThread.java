package de.ni.fun.battleship.view.console;

public class WaitingThread extends Thread {

    private boolean shutdown = false;

    public void run() {
        shutdown = false;
        System.out.print("Warte auf einen anderen Spieler ... -");
        try {
            int counter = 0;
            while (!shutdown) {
                switch (counter) {
                    case 0:
                        System.out.println("\b\\");
                        this.wait(500);
                        counter++;
                        break;
                    case 1:
                        System.out.println("\b|");
                        this.wait(500);
                        counter++;
                        break;
                    case 2:
                        System.out.print("\b/");
                        this.wait(500);
                        counter++;
                        break;
                    case 3:
                        System.out.println("\b-");
                        this.wait(500);
                        counter++;
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
