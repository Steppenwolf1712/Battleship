package de.ni.fun.battleship.model;

public class ShipDefinitions {

    int[] ships;

    public ShipDefinitions(int countShortShips, int countSmallShips, int countMediumShips) {
        this(countShortShips, countSmallShips, countMediumShips, 0);
    }

    public ShipDefinitions(int countShortShips, int countSmallShips, int countMediumShips, int countLargeShips) {
        this(countShortShips, countSmallShips, countMediumShips, countLargeShips, 0);
    }

    public ShipDefinitions(int countShortShips, int countSmallShips, int countMediumShips, int countLargeShips, int countLongShips) {
        this(countShortShips, countSmallShips, countMediumShips, countLargeShips, countLongShips, 0);
    }

    public ShipDefinitions(int countShortShips, int countSmallShips, int countMediumShips, int countLargeShips, int countLongShips, int countLongerShips) {
        this(countShortShips, countSmallShips, countMediumShips, countLargeShips, countLongShips, countLongerShips, 0);
    }

    public ShipDefinitions(int countShortShips, int countSmallShips, int countMediumShips, int countLargeShips, int countLongShips, int countLongerShips, int countlongestShips) {
        ships = new int[7];
        ships[0] = countShortShips;
        ships[1] = countSmallShips;
        ships[2] = countMediumShips;
        ships[3] = countLargeShips;
        ships[4] = countLongShips;
        ships[5] = countLongerShips;
        ships[6] = countlongestShips;
    }


}
