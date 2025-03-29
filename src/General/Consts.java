package General;

import Geometry.Line;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;

import java.awt.*;

/**
 * The type Consts.
 */
public class Consts {
    /**
     * The constant Epsilon.
     */
    public final static double Epsilon = 0.0001,
    /**
     * The Half.
     */
    Half = 0.5;
    /**
     * The constant VELOCITY_OF_PADDLE_LEFT.
     */
    public static final Velocity VELOCITY_OF_PADDLE_LEFT = Velocity.fromAngleAndSpeed(0, -10);
    /**
     * The constant VELOCITY_OF_PADDLE_RIGHT.
     */
    public static final Velocity VELOCITY_OF_PADDLE_RIGHT = Velocity.fromAngleAndSpeed(0, 10);
    /**
     * The constant VELOCITY_OF_PADDLE_INITIALIZATION.
     */
    public static final Velocity VELOCITY_OF_PADDLE_INITIALIZATION = new Velocity(0, 0);
    /**
     * The constant RECTANGLE_of_RIGHT.
     */
    public static final Rectangle RECTANGLE_of_RIGHT = new Rectangle(new Point(480, 0), 20, 500);
    /**
     * The constant RECTANGLE_OF_LEFT.
     */
    public static final Rectangle RECTANGLE_OF_LEFT = new Rectangle(new Point(0, 0), 20, 500);
    /**
     * The constant RECTANGLE_OF_UP.
     */
    public static final Rectangle RECTANGLE_OF_UP = new Rectangle(new Point(20, 0), 460, 20);
    /**
     * The constant RECTANGLE_OF_LOWER.
     */
    public static final Rectangle RECTANGLE_OF_LOWER = new Rectangle(new Point(20, 510), 460, 20);
    /**
     * The constant RECTANGLE_OF_SORCE.
     */
    public static final Rectangle RECTANGLE_OF_SORCE = new Rectangle(new Point(0, 0), 500, 10);
    /**
     * The constant RECTANGLE_of_PADDLE.
     */
    public static final Rectangle RECTANGLE_of_PADDLE = new Rectangle(new Point(199, 475), 60, 5);
    /**
     * The constant COLOR_OF_RECTANGLE_OF_SORCE.
     */
    public static final Color COLOR_OF_RECTANGLE_OF_SORCE = Color.GRAY;
    /**
     * The constant BLOCKS_WIDTH.
     */
    public static final double BLOCKS_WIDTH = 30, /**
     * The Block height.
     */
    BLOCK_HEIGHT = 20, /**
     * The First height.
     */
    FIRST_HEIGHT = 50;
    /**
     * The constant COLOR_OF_PADDLE.
     */
    public static final Color COLOR_OF_PADDLE = Color.BLACK;
    /**
     * The constant VELOCITY_OF_BALL1.
     */
    public static final Velocity VELOCITY_OF_BALL1 = new Velocity(-3, 2);
    /**
     * The constant VELOCITY_OF_BALL2.
     */
    public static final Velocity VELOCITY_OF_BALL2 = new Velocity(4, 1);
    /**
     * The constant CENTER_OF_BALL1.
     */
    public static final Point CENTER_OF_BALL1 = new Point(218, 470);
    /**
     * The constant CENTER_OF_BALL2.
     */
    public static final Point CENTER_OF_BALL2 = new Point(38, 50);
    /**
     * The constant CENTER_OF_BALL3.
     */
    public static final Point CENTER_OF_BALL3 = new Point(60, 120);
    /**
     * The constant RADIOS_OF_BALL1.
     */
    public static final int RADIOS_OF_BALL1 = 5;
    /**
     * The constant RADIOS_OF_BALL2.
     */
    public static final int RADIOS_OF_BALL2 = 4;
    /**
     * The constant RADIOS_OF_BALL3.
     */
    public static final int RADIOS_OF_BALL3 = 6;
    /**
     * The constant VELOCITY_OF_BALL3.
     */
    public static final Velocity VELOCITY_OF_BALL3 = new Velocity(4, 4);




}
