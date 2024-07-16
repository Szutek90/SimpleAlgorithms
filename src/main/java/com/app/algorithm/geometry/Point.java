package com.app.algorithm.geometry;

import lombok.EqualsAndHashCode;

/**
 * The Point class represents a point in a 2D coordinate system and provides methods for geometric operations.
 */
@EqualsAndHashCode
public class Point {
    private final double x;
    private final double y;

    /**
     * Constructs a Point object with the specified x and y coordinates.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public <T extends Number> Point(T x, T y) {
        this.x = x.doubleValue();
        this.y = y.doubleValue();
    }

    /**
     * Subtracts the x-coordinate of the given point from the x-coordinate of this point.
     *
     * @param p the point whose x-coordinate is to be subtracted
     * @return the difference between the x-coordinates
     */
    public double subtractGivePointX(Point p) {
        return x - p.x;
    }

    /**
     * Subtracts the y-coordinate of the given point from the y-coordinate of this point.
     *
     * @param p the point whose y-coordinate is to be subtracted
     * @return the difference between the y-coordinates
     */
    public double subtractGivenPointY(Point p) {
        return y - p.y;
    }

    /**
     * Subtracts the x-coordinate of the given point from the y-coordinate of this point.
     *
     * @param p the point whose x-coordinate is to be subtracted
     * @return the difference between this point's y-coordinate and the given point's x-coordinate
     */
    public double subtractXGivenPointFromY(Point p) {
        return y - p.x;
    }

    /**
     * Checks if this point lies on the line defined by the equation y = ax + b.
     *
     * @param a the slope of the line
     * @param b the y-intercept of the line
     * @return true if the point lies on the line, false otherwise
     */
    public boolean isPointOnLine(double a, double b) {
        return y == a * x + b;
    }

    /**
     * Compares this point with the given point and returns the point with the lower x-coordinate.
     *
     * @param p the point to compare with
     * @return the point with the lower x-coordinate
     */
    public Point getPointWithLowerXCoordinate(Point p) {
        return p.x < x ? p : this;
    }

    /**
     * Compares this point with the given point and returns the point with the higher x-coordinate.
     *
     * @param p the point to compare with
     * @return the point with the higher x-coordinate
     */
    public Point getPointWithHigherXCoordinate(Point p) {
        return p.x > x ? p : this;
    }

    /**
     * Checks if the x-coordinate of this point is higher than or equal to the x-coordinate of the given point.
     *
     * @param p the point to compare with
     * @return true if the x-coordinate of this point is higher than or equal to the x-coordinate of the given point, false otherwise
     */
    public boolean xIsHigherOrEqualThan(Point p) {
        return x >= p.x;
    }

    /**
     * Checks if the x-coordinate of this point is lower than or equal to the x-coordinate of the given point.
     *
     * @param p the point to compare with
     * @return true if the x-coordinate of this point is lower than or equal to the x-coordinate of the given point, false otherwise
     */
    public boolean xIsLowerOrEqualThan(Point p) {
        return x <= p.x;
    }

    /**
     * Compares this point with the given point and returns the point with the lower y-coordinate.
     *
     * @param p the point to compare with
     * @return the point with the lower y-coordinate
     */
    public Point getPointWithLowerYCoordinate(Point p) {
        return p.y < y ? p : this;
    }

    /**
     * Compares this point with the given point and returns the point with the higher y-coordinate.
     *
     * @param p the point to compare with
     * @return the point with the higher y-coordinate
     */
    public Point getPointWithHigherYCoordinate(Point p) {
        return p.y > y ? p : this;
    }

    /**
     * Checks if the y-coordinate of this point is higher than or equal to the y-coordinate of the given point.
     *
     * @param p the point to compare with
     * @return true if the y-coordinate of this point is higher than or equal to the y-coordinate of the given point, false otherwise
     */
    public boolean yIsHigherOrEqualThan(Point p) {
        return y >= p.y;
    }

    /**
     * Checks if the y-coordinate of this point is lower than or equal to the y-coordinate of the given point.
     *
     * @param p the point to compare with
     * @return true if the y-coordinate of this point is lower than or equal to the y-coordinate of the given point, false otherwise
     */
    public boolean yIsLowerOrEqualThan(Point p) {
        return y <= p.y;
    }

    /**
     * Evaluates the linear equation ax + by + c using the coordinates of this point.
     *
     * @param a the coefficient of x
     * @param b the coefficient of y
     * @param c the constant term
     * @return the result of the linear equation evaluated at this point
     */
    public double evaluateLinearEquation(double a, double b, double c) {
        return a * x + b * y + c;
    }
}
