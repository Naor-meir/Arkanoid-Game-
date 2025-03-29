package Geometry;

import General.GeneralMethods;

/**
 * The type Point.
 */
public class Point {
    private double x, y;

    /**
     * Instantiates a new Point.
     *
     * @param x the x
     * @param y the y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return this.y;
    }

    /**
     * Distance double.
     *
     * @param other the other
     * @return the double
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.getX(), 2) +
                Math.pow(this.y - other.getY(), 2));
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equals(Point other) {
        return GeneralMethods.equalsEpsilonit(this.x, other.getX())
                && GeneralMethods.equalsEpsilonit(this.y, other.getY());
    }
}
