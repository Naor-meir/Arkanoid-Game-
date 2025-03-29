package Geometry;

import General.GeneralMethods;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Rectangle.
 */
public class Rectangle {
    private Point upperLeft;
    private double width, height;
    private Point lowerLeft, upperRight, lowerRight;
    private List<Line> lineList = new ArrayList<>();

    /**
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        pointsOfCorners();
        this.lineList = lineList();

    }


    /**
     * Gets upper left.
     *
     * @return the upper left
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets lower left.
     *
     * @return the lower left
     */
    public Point getLowerLeft() {
        return this.lowerLeft;
    }

    /**
     * Gets upper right.
     *
     * @return the upper right
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     * Gets lower right.
     *
     * @return the lower right
     */
    public Point getLowerRight() {
        return this.lowerRight;
    }

    /**
     * Gets line list.
     *
     * @return the line list
     */
    public List<Line> getLineList() {
        return this.lineList;
    }

    /**
     * Intersection points list.
     *
     * @param line the line
     * @return the list
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> pointList = new ArrayList<>();
        for (Line line1 : lineList()) {
            if (line1.intersectionWith(line) != null)
                pointList.add(line1.intersectionWith(line));
        }
        return GeneralMethods.listToSet(pointList);

    }

    private void pointsOfCorners() {
        this.upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        this.lowerRight = new Point(this.upperRight.getX(), this.upperRight.getY() + this.height);
        this.lowerLeft = new Point(this.upperLeft.getX(), this.lowerRight.getY());
    }

    private List<Line> lineList() {
        List<Line> lineList = new ArrayList<>();
        lineList.add(new Line(this.upperLeft, this.upperRight));
        lineList.add(new Line(this.lowerLeft, this.lowerRight));
        lineList.add(new Line(this.upperLeft, this.lowerLeft));
        lineList.add(new Line(this.upperRight, this.lowerRight));
        return lineList;
    }

    /**
     * Is point on rectangle boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean isPointOnRectangle(Point point) {
        List<Line> lineList1 = lineList();
        for (Line line : lineList1) {
            if (line.pointOnLine(point)) return true;
        }
        return false;

    }

    /**
     * Is point in rectangle boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean isPointInRectangle(Point point) {
        return GeneralMethods.range(this.upperLeft.getX(), point.getX(), this.upperRight.getX())
                &&
                GeneralMethods.range(this.upperLeft.getY(), point.getY(), this.lowerLeft.getY());

    }


    /**
     * Sets upper left.
     *
     * @param upperLeft the upper left
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
        pointsOfCorners();

    }

    /**
     * Is intersection right boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean isIntersectionRight(Point point) {
        Line right = (new Line(this.upperRight, this.lowerRight));
        return right.pointOnLine(point);

    }

    /**
     * Is intersection left boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean isIntersectionLeft(Point point) {
        Line left = new Line(this.upperLeft, this.lowerLeft);
        return left.pointOnLine(point);
    }

    /**
     * Is intersection up boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean isIntersectionUp(Point point) {
        Line up = new Line(this.upperLeft, this.upperRight);
        return up.pointOnLine(point);
    }

    /**
     * Is intersection down boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean isIntersectionDown(Point point) {
        Line dwon = new Line(this.lowerLeft, this.lowerRight);
        return dwon.pointOnLine(point);
    }

}
