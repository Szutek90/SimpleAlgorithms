package com.app.algorithm.geometry;

/**
 * The LineEquationOperator class provides methods for checking if a point lies on a line defined by its equation.
 *
 * @param <T> the type of the coordinates (must extend Number)
 */

public class LineEquationOperator<T extends Number> {
    private final double a;
    private final double b;

    /**
     * Constructs a LineEquationOperator object with the coefficients of the line equation.
     *
     * @param a the coefficient of x in the line equation
     * @param b the constant term in the line equation
     */

    public LineEquationOperator(T a, T b) {
        this.a = a.doubleValue();
        this.b = b.doubleValue();
    }

    /**
     * Checks if a point lies on the line defined by the equation ax + b.
     *
     * @param point the point to be checked
     * @return true if the point lies on the line, false otherwise
     */

    public boolean checkIfPointIsInLine(Point point) {
        return point.isPointOnLine(a, b);
    }
}
