package Geometry;

import General.GeneralMethods;


import java.util.List;

/**
 * The type Line.
 */
public class Line {
    private Point start, end;
    private Object slope = null;
    private double b;

    /**
     * Instantiates a new Line.
     *
     * @param start the start
     * @param end   the end
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        setSlope();
        calculationB();
    }

    /**
     * Instantiates a new Line.
     *
     * @param x1 the x 1
     * @param y1 the y 1
     * @param x2 the x 2
     * @param y2 the y 2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        setSlope();
        calculationB();
    }

    /**
     * Gets slope.
     *
     * @return the slope
     */
    public Object getSlope() {
        return slope;
    }

    /**
     * Gets b.
     *
     * @return the b
     */
    public double getB() {
        return this.b;
    }

    /**
     * Gets end.
     *
     * @return the end
     */
    public Point getEnd() {
        return this.end;
    }

    /**
     * Gets start.
     *
     * @return the start
     */
    public Point getStart() {
        return this.start;
    }

    /**
     * Length double.
     *
     * @return the double
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Middle point.
     *
     * @return the point
     */
    public Point middle() {
        return new Point(GeneralMethods.average(this.start.getX(), this.end.getX()),
                GeneralMethods.average(this.start.getY(), this.end.getY()));
    }

    /**
     * Is intersecting boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean isIntersecting(Line other) {

        if (this.slope == null && other.getSlope() == null) {
            return isIntersectingBothSlopeIdentical(other);

        } else if (this.slope == null) {
            return isIntersectingOneVertical(this, other);
        } else if (other.getSlope() == null) {
            return isIntersectingOneVertical(other, this);

        } else if (GeneralMethods.equalsEpsilonit((double) this.slope, (double) other.getSlope())) {
            return isIntersectingBothSlopeIdentical(other);

        } else {
            return this.pointOnLine(this.pointOfIntersectionNoneVertical(other))
                    && other.pointOnLine(other.pointOfIntersectionNoneVertical(this));


        }


    }

    /**
     * Intersection with point.
     *
     * @param other the other
     * @return the point
     */
    public Point intersectionWith(Line other) {
        if (this.equals(other) || !this.isIntersecting(other)) return null;
        if (this.slope == null && other.getSlope()!=null) {
            return this.pointOfIntersectionOneVertical(other);
        }
        if (other.getSlope() == null && this.slope!=null) {
            return other.pointOfIntersectionOneVertical(this);
        }
        if (this.equalsSlope(other)) {
            if (this.theLineIsPoint()) return this.start;
            if (other.theLineIsPoint()) return other.getStart();
            return this.continuePoint(other);
        }
        return this.pointOfIntersectionNoneVertical(other);


    }


    private boolean isIntersectingBothSlopeIdentical(Line other) {
        if (this.equals(other)) return true;
        if (this.itparallels(other)) return false;
        return this.itcontained(other);


    }

    private boolean isIntersectingOneVertical(Line vertical, Line line) {
        return vertical.pointOnLine(vertical.pointOfIntersectionOneVertical(line))
                && line.pointOnLine(vertical.pointOfIntersectionOneVertical(line));
    }

    private void setSlope() {
        if ((GeneralMethods.equalsEpsilonit(this.start.getX(), this.end.getX()))) {
            return;
        }
        this.slope = (this.start.getY() - this.end.getY()) /
                (this.start.getX() - this.end.getX());

    }

    private void calculationB() {
        if (this.slope != null) {
            this.b = (this.start.getY() - (double) this.slope * this.start.getX());
            return;
        }
        this.b = this.start.getX();
    }

        private boolean equals (Line other){
            return (this.start.equals(other.getStart()) && this.end.equals(other.getEnd()))
                    || (this.end.equals(other.getStart()) && this.start.equals(other.getEnd()));
        }

        private boolean itcontained (Line other){
            return this.middle().distance(other.middle()) <= GeneralMethods.average(this.length(), other.length());

        }

    /**
     * Itparallels boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean itparallels (Line other){
            return !GeneralMethods.equalsEpsilonit(this.b, other.getB());
        }


    /**
     * Point on line boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean pointOnLine (Point point){
            if (this.slope == null) {
                return (GeneralMethods.equalsEpsilonit(point.getX(), this.b)
                        && GeneralMethods.range(this.start.getY(), point.getY(), this.end.getY()));
            }
            boolean bool = GeneralMethods.equalsEpsilonit(point.getY(), this.b + (point.getX()) * (double) this.slope);
            if (bool)
                return GeneralMethods.range(this.start.getY(), point.getY(), this.end.getY()) &&
                        GeneralMethods.range(this.start.getX(), point.getX(), this.end.getX());

            return false;
        }

        private Point pointOfIntersectionOneVertical (Line other){
            double y = (double) other.getSlope() * this.b + other.getB();
            return new Point(this.b, y);

        }

        private Point pointOfIntersectionNoneVertical (Line other){
            double x = (this.b - other.getB()) / ((double) other.getSlope() - (double) this.slope);
            double y = (double) this.slope * x + this.b;
            return new Point(x, y);
        }

        private boolean equalsSlope (Line other){
            return (this.slope == null && other.getSlope() == null)
                    || (GeneralMethods.equalsEpsilonit((double) this.slope, (double) other.getSlope()));

        }


        private boolean theLineIsPoint () {
            return (this.start.equals(this.end));
        }

        private boolean isContinue (Line other){
            return GeneralMethods.equalsEpsilonit(this.middle().distance(other.middle())
                    , GeneralMethods.average(this.length(), other.length()));

        }

        private Point continuePoint (Line other){
            if (this.isContinue(other)) {
                if (this.end.equals(other.getEnd()) || this.end.equals(other.getStart())) {
                    return this.end;
                }
                if (this.start.equals(other.getStart()) || this.start.equals(other.getEnd())) {
                    return this.start;
                }
            }
            return null;

        }

    /**
     * Is vertical boolean.
     *
     * @return the boolean
     */
    public boolean isVertical () {
            return this.slope == null;
        }

    /**
     * Is slope 0 boolean.
     *
     * @return the boolean
     */
    public boolean isSlope_0 () {
            if (slope == null) return false;
            return (double) this.slope == 0;
        }

    /**
     * Closest intersection to start of line point.
     *
     * @param rect the rect
     * @return the point
     */
// If this line does not intersect with the rectangle, return null.
        // Otherwise, return the closest intersection point to the
        // start of the line.
        public Point closestIntersectionToStartOfLine (Rectangle rect){
            List<Point> pointList = rect.intersectionPoints(this);
            if (pointList == null) return null;
            double distance = Double.MAX_VALUE;
            Point closeToStart = null;

            for (Point p : pointList) {
                if (this.start.distance(p) < distance) {
                    closeToStart = p;
                    distance = this.start.distance(closeToStart);

                }
            }
            return closeToStart;
        }

    }
