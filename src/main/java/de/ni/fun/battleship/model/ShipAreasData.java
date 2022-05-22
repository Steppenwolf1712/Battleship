package de.ni.fun.battleship.model;

import java.util.Observable;
import java.util.Observer;

public class ShipAreasData {

    private ShipAreaData[][] data;
    private int gameSize;

    ShipAreasData(Settings settings) {
        gameSize = settings.getGameSize();
        init();
    }

    public void init() {
        data = new ShipAreaData[gameSize][gameSize];

        for (int y = 0; y<gameSize; y++) {
            for (int x = 0; x<gameSize; x++) {
                data[x][y] = new ShipAreaData();
            }
        }
    }

    public void addObserver(Coordinate position, Observer obs) {
        data[position.getY()][position.getX()].addObserver(obs);
    }

    public void setHit(Coordinate position) {
        data[position.getY()][position.getX()].hit();
    }

    /**
     * Places a Ship starting at the startPoint and ends #length fields away, either to the right
     * or to the south, depending on isHorizontal.
     *
     * @param startPoint
     * @param length
     * @param isHorizontal
     */
    public void placeShip(Coordinate startPoint, int length, boolean isHorizontal) {
        this.data[startPoint.getY()][startPoint.getX()].setShipEnd(isHorizontal, true);
        Coordinate tempPosition;

        for (int i = 1; i + 2 <= length; i++) {
            if (isHorizontal)
                tempPosition = new Coordinate(startPoint.getX() + i, startPoint.getY());
            else
                tempPosition = new Coordinate(startPoint.getX(), startPoint.getY() + i);
            this.data[tempPosition.getY()][tempPosition.getX()].setShip();
        }
        if (isHorizontal)
            tempPosition = new Coordinate(startPoint.getX() + length -1, startPoint.getY());
        else
            tempPosition = new Coordinate(startPoint.getX(), startPoint.getY() + length - 1);
        this.data[tempPosition.getY()][tempPosition.getX()].setShipEnd(isHorizontal, false);
    }

    public void refreshData() {
        for (int y = 0; y<gameSize; y++) {
            for (int x = 0; x<gameSize; x++) {
                data[y][x].refresh();
            }
        }
    }

    public boolean isShip(Coordinate coordinate) {
        return data[coordinate.getY()][coordinate.getX()].hasShip;
    }

    public class ShipAreaData extends Observable {
        private boolean hasShip = false;
        private boolean hasHit = false;

        private boolean isShipEnd = false;
        private boolean hasHoriEnd = false;
        private boolean endNorthWest = false;

        public ShipAreaData() {
            refresh();
        }

        public void refresh() {
            this.hasShip = false;
            this.hasHit = false;
            this.isShipEnd = false;
            this.hasHoriEnd = false;
            this.endNorthWest = false;
            trigger();
        }

        public void hit() {
            this.hasHit = true;
            trigger();
        }

        public void setShip() {
            this.hasShip = true;
            trigger();
        }

        public void setShipEnd(boolean ishorizontal, boolean isNorthWest) {
            this.hasShip = true;
            this.isShipEnd = true;
            this.hasHoriEnd = ishorizontal;
            this.endNorthWest = isNorthWest;
            trigger();
        }

        private void trigger() {
            setChanged();
            notifyObservers();
            clearChanged();
        }

        public boolean hasShip() {
            return hasShip;
        }

        public boolean hasHit() {
            return hasHit;
        }

        public boolean isShipEnd() {
            return isShipEnd;
        }

        public boolean hasHoriEnd() {
            return hasHoriEnd;
        }

        public boolean isEndNorthWest() {
            return endNorthWest;
        }
    }
}
