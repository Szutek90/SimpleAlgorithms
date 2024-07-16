package com.app.algorithm.geometry;

/**
 * The LineSegmentIntersection class provides methods for determining whether two line segments intersect.
 */

public class LineSegmentIntersection {
    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Point p4;

    /**
     * Constructs a LineSegmentIntersection object with the specified endpoints of two line segments.
     *
     * @param p1 the first endpoint of the first line segment
     * @param p2 the second endpoint of the first line segment
     * @param p3 the first endpoint of the second line segment
     * @param p4 the second endpoint of the second line segment
     */
    public LineSegmentIntersection(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    /**
     * Determines whether the two line segments intersect.
     *
     * @return true if the line segments intersect, false otherwise
     */

    public boolean areIntersect() {
        var v1 = dotProduct(p1, p2, p3);
        var v2 = dotProduct(p1, p2, p4);
        var v3 = dotProduct(p3, p4, p1);
        var v4 = dotProduct(p4, p3, p2);
        if ((v1 > 0 && v2 < 0 || v1 < 0 && v2 > 0) && (v3 > 0 && v4 < 0 || v3 < 0 && v4 > 0)) {
            return true;
        }
        if (v1 == 0 && isPointOnLine(p1, p2, p3)) {
            return true;
        }
        if (v2 == 0 && isPointOnLine(p1, p2, p4)) {
            return true;
        }
        if (v3 == 0 && isPointOnLine(p3, p4, p1)) {
            return true;
        }
        return v4 == 0 && isPointOnLine(p3, p4, p2);
    }

    /**
     * Checks if a point lies on a line segment defined by two endpoints.
     *
     * @param p1 the first endpoint of the line segment
     * @param p2 the second endpoint of the line segment
     * @param p3 the point to be checked
     * @return true if the point lies on the line segment, false otherwise
     */

    private boolean isPointOnLine(Point p1, Point p2, Point p3) {
        return (p3.xIsHigherOrEqualThan(p1.getPointWithLowerXCoordinate(p2)) &&
                (p3.xIsLowerOrEqualThan(p1.getPointWithHigherXCoordinate(p2)) &&
                        (p3.yIsHigherOrEqualThan(p1.getPointWithLowerYCoordinate(p2)) &&
                                (p3.yIsLowerOrEqualThan(p1.getPointWithHigherYCoordinate(p2))))));
    }

    /**
     * Calculates the dot product of two vectors defined by three points.
     *
     * @param p1 the first point of the first vector
     * @param p2 the second point of the first vector
     * @param p3 the first point of the second vector
     * @return the dot product of the two vectors
     */

    private double dotProduct(Point p1, Point p2, Point p3) {
        return (p3.subtractGivePointX(p1)) * (p2.subtractXGivenPointFromY(p2)) -
                (p2.subtractGivePointX(p1)) * (p3.subtractGivenPointY(p1));
    }
}
