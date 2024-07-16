package com.app.algorithm.geometry;

/**
 * The PointLinePosition class provides methods for determining the position of a point relative to a line.
 *
 * @param <T> the type of the coordinates (must extend Number)
 */

public class PointLinePosition<T extends Number> {
    private final double a;
    private final double b;
    private final double c;

    /**
     * Constructs a PointLinePosition object with the coefficients of the line equation.
     *
     * @param a the coefficient of x in the line equation
     * @param b the coefficient of y in the line equation
     * @param c the constant term in the line equation
     */

    public PointLinePosition(T a, T b, T c) {
        this.a = a.doubleValue();
        this.b = b.doubleValue();
        this.c = c.doubleValue();
    }

    /**
     * Determines the position of a point relative to the line.
     *
     * @param point the point to be evaluated
     * @return 0 if the point lies on the line, 1 if it is above the line, -1 if it is below the line
     */

    public int getPosition(Point point) {
        var result = point.evaluateLinearEquation(a, b, c);
        if (result == 0) {
            return 0;
        }
        return result > 0 ? 1 : -1;
    }
}
