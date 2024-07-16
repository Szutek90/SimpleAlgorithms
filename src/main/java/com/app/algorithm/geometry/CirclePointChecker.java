package com.app.algorithm.geometry;

/**
 * The CirclePointChecker class provides methods for checking if a point is inside a circle.
 *
 * @param <T> the type of the radius, extending Number
 */


public class CirclePointChecker<T extends Number> {
    private final Point point0;
    private final double squaredRadius;

    /**
     * Constructs a CirclePointChecker object with the specified point and radius.
     *
     * @param point0  the center point of the circle
     * @param radius the radius of the circle
     */

    public CirclePointChecker(Point point0, T radius) {
        this.point0 = point0;
        squaredRadius = Math.pow(radius.doubleValue(), 2);
    }

    /**
     * Checks if the given point is inside the circle.
     *
     * @param point the point to be checked
     * @return true if the point is inside the circle, false otherwise
     */

    public boolean isInside(Point point) {
        return squaredRadius >= Math.pow(point0.subtractGivePointX(point), 2) + Math.pow(point0.subtractGivenPointY(point), 2);
    }
}
