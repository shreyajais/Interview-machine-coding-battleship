package model;

import exceptions.CoordinateOutOfBoundaryException;
import model.boundary.IBoundary;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<BoardItem> ships;
    private final IBoundary boundary;
    private final List<Coordinate> allBombLocations;

    public Board(List<BoardItem> ships, IBoundary boundary) {
        this.ships = ships;
        this.boundary = boundary;
        this.allBombLocations = new ArrayList<>();
    }

    public void takeHit(final Coordinate coordinate) { // check for null exception
        if (!boundary.contains(coordinate)) {
            throw new CoordinateOutOfBoundaryException();
        }

        allBombLocations.add(coordinate);
    }

    public List<BoardItem> getShips() {
        return ships;
    }

    public IBoundary getBoundary() {
        return boundary;
    }

    public List<Coordinate> getAllBombLocations() {
        return allBombLocations;
    }

    public boolean areAllShipsKilled() {
        for (BoardItem ship : ships) {
            if (!ship.isKilled(allBombLocations)) {
                return false;
            }
        }
        return true;
    }

    public List<Coordinate> hitLocations() {
        final List<Coordinate> result = new ArrayList<>();

        for (Coordinate coordinate: allBombLocations) {
            for (BoardItem ship: ships) {
                if (ship.containsCoordinate(coordinate)) {
                    result.add(coordinate);
                    break;
                }
            }
        }

        return result;
    }

    public List<Coordinate> missLocations() {
        final List<Coordinate> result = new ArrayList<>();

        for (Coordinate coordinate: allBombLocations) {
            boolean doesBelongToShip = false;
            for (BoardItem ship: ships) {
                if (ship.containsCoordinate(coordinate)) {
                    doesBelongToShip = true;
                    break;
                }
            }
            if (!doesBelongToShip) {
                result.add(coordinate);
            }
        }

        return result;
    }
}
