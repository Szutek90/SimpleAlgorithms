package com.app.algorithm.geometry;

/**
 * The TriangleRuleChecker class provides methods for checking properties of a triangle based on its side lengths.
 *
 * @param <T> the type of the side lengths (must extend Number)
 */

public class TriangleRuleChecker<T extends Number> {

    private final double sideA;
    private final double sideB;
    private final double sideC;

    /**
     * Constructs a TriangleRuleChecker object with the specified side lengths.
     *
     * @param sideA the length of the first side of the triangle
     * @param sideB the length of the second side of the triangle
     * @param sideC the length of the third side of the triangle
     */

    public TriangleRuleChecker(T sideA, T sideB, T sideC) {
        this.sideA = sideA.doubleValue();
        this.sideB = sideB.doubleValue();
        this.sideC = sideC.doubleValue();
    }

    /**
     * Checks if the triangle can exist based on the triangle inequality theorem.
     *
     * @return true if the triangle can exist, false otherwise
     */

    public boolean canBeTriangle() {
        return sideA + sideB > sideC && sideA + sideC > sideB && sideC + sideB > sideA && sideA > 0 && sideB > 0 && sideC > 0;
    }

    /**
     * Checks if the triangle is equilateral (all sides are of equal length).
     *
     * @return true if the triangle is equilateral, false otherwise
     */

    public boolean isEquilateral() {
        return sideA == sideB && sideA == sideC;
    }

    /**
     * Checks if the triangle is isosceles (at least two sides are of equal length).
     *
     * @return true if the triangle is isosceles, false otherwise
     */

    public boolean isIsosceles() {
        return sideA == sideB || sideA == sideC || sideB == sideC;
    }

    /**
     * Checks if the triangle is scalene (all sides are of different lengths).
     *
     * @return true if the triangle is scalene, false otherwise
     */

    public boolean isScalene() {
        return canBeTriangle() && sideA != sideB && sideA != sideC && sideB != sideC;
    }

    /**
     * Checks if the triangle is rectangular (has one right angle).
     *
     * @return true if the triangle is rectangular, false otherwise
     */

    public boolean isRectangular() {
        var max = Math.max(sideA, Math.max(sideB, sideC));
        var min1 = Math.min(sideA, Math.min(sideB, sideC));
        var min2 = sideA + sideB + sideC - max - min1;

        return max * max == min1 * min1 + min2 * min2;
    }

    /**
     * Calculates the perimeter of the triangle.
     *
     * @return the perimeter of the triangle
     */

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    /**
     * Calculates the area of the triangle using Heron's formula.
     *
     * @return the area of the triangle
     */

    public double getArea() {
        var s = getPerimeter() / 2;
        return (double) Math.round(Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)) * 100) / 100;
    }
}
