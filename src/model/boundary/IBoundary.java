package model.boundary;


import model.Coordinate;

import java.util.List;

public interface IBoundary {
    boolean contains(Coordinate coordinate); // check for null exception in coordinates
    List<Coordinate> allCoordinates();
}
