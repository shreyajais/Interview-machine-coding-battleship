package model.boundary;

import model.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class RectangularBoundary implements IBoundary{ // check for the placing
    private final Coordinate topLeft;
    private final Coordinate bottomRight;

    public RectangularBoundary(Coordinate topLeft, Coordinate bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }


    public Coordinate getTopLeft() {
        return topLeft;
    }

    public Coordinate getBottomRight() {
        return bottomRight;
    }

    public List<Coordinate> allCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = topLeft.getX(); i <= bottomRight.getX(); i++) {
            for (int j = topLeft.getY(); j >= bottomRight.getY(); j--) {
                coordinates.add(new Coordinate(i, j));
            }
        }
        return coordinates;
    }

    public boolean contains(final Coordinate coordinate) { /// check for null exceptions
        return coordinate.getX() >= topLeft.getX() && coordinate.getX() <= bottomRight.getX()
                && coordinate.getY() >= bottomRight.getY() && coordinate.getY() <= topLeft.getY();
    }
}
