package model;

import model.boundary.IBoundary;

import java.util.List;

public class BoardItem {
    private final String name;
    private final IBoundary boundary;

    public String getName() {
        return name;
    }

    public IBoundary getBoundary() {
        return boundary;
    }

    public BoardItem(String name, IBoundary boundary) {
        this.name = name;
        this.boundary = boundary;
    }

    public boolean isKilled(final List<Coordinate> hitLocations) { // null exception
        final List<Coordinate> shipCoordinates = boundary.allCoordinates();
        for (Coordinate shipCoordinate: shipCoordinates) {
            if (!hitLocations.contains(shipCoordinate)) { // to be changed
                return false;
            }
        }
        return true;
    }

    public boolean containsCoordinate(final Coordinate coordinate) { // null exception
        return this.boundary.contains(coordinate);
    }
}
