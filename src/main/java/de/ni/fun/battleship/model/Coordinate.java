package de.ni.fun.battleship.model;

public class Coordinate {

    private int X = -1;
    private int Y = -1;

    public Coordinate(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
