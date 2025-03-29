package GameObject;

import General.Consts;
import General.GeneralMethods;
import Geometry.Ball;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import Interfaces.Collidable;
import Interfaces.Sprite;
import biuoop.KeyboardSensor;
import Game.GameLevel;

import java.awt.*;

/**
 * The type Paddle.
 */
public class Paddle extends Block implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Velocity velocity;
    private int speed;

    /**
     * Instantiates a new Paddle.
     *
     * @param rectangle the rectangle
     * @param color     the color
     * @param speed     the speed
     */
    public Paddle(Rectangle rectangle, Color color, int speed) {
        super(rectangle, color);
        this.velocity = new Velocity(0, 0);
        this.speed = speed;
    }

    /**
     * Sets keyboard.
     *
     * @param keyboard the keyboard
     */
    public void setKeyboard(KeyboardSensor keyboard) {
        this.keyboard = keyboard;
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            setVelocity(new Velocity(-this.speed, 0));
            this.getCollisionRectangle().setUpperLeft(velocity.applyToPoint(this.getCollisionRectangle().getUpperLeft()));
            if (paddlePassLeftLimit(this.getCollisionRectangle().getUpperLeft())) {
                initializationPaddleInLeft();
            }
        }
    }

    /**
     * Move right.
     */
    public void moveRight() {
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            setVelocity(new Velocity(this.speed, 0));
            this.getCollisionRectangle().setUpperLeft(velocity.applyToPoint(this.getCollisionRectangle().getUpperLeft()));
            if (paddlePassRightLimit(this.getCollisionRectangle().getUpperRight())) {
                initializationPaddleInRight();

            }


        }

    }

    private void setVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
// Add this paddle to the game.
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);

    }


    @Override
    public void timePassed() {
        moveLeft();
        moveRight();
    }

    private boolean paddlePassRightLimit(Point point) {
        return Consts.RECTANGLE_of_RIGHT.isPointInRectangle(point);


    }

    private boolean paddlePassLeftLimit(Point point) {
        return Consts.RECTANGLE_OF_LEFT.isPointInRectangle(point);

    }

    private void initializationPaddleInRight() {
        this.getCollisionRectangle().setUpperLeft(new Point(480 - this.getRectangle().getWidth(), getCollisionRectangle().getUpperLeft().getY()));

    }

    private void initializationPaddleInLeft() {
        this.getCollisionRectangle().setUpperLeft(new Point(20, getCollisionRectangle().getUpperLeft().getY()));

    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        return switch (inRangeOf(collisionPoint.getX())) {
            case 1 ->
                    Velocity.fromAngleAndSpeed(210, currentVelocity.getSpeed());
            case 2 ->
                    Velocity.fromAngleAndSpeed(240, currentVelocity.getSpeed());
            case 3 ->
                    Velocity.fromAngleAndSpeed(270, currentVelocity.getSpeed());
            case 4 ->
                    Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
            case 5 ->
                    Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());

            default -> currentVelocity;
        };

    }

    private int inRangeOf(double x) {
        double range = this.getCollisionRectangle().getUpperLeft().distance(this.getCollisionRectangle().getUpperRight());
        range = range / 5;
        double xStart = this.getCollisionRectangle().getUpperLeft().getX();
        if (GeneralMethods.range(xStart, x, xStart + range)) return 1;
        if (GeneralMethods.range(xStart + range, x, xStart + (2 * range)))
            return 2;
        if (GeneralMethods.range(xStart + (2 * range), x, xStart + (3 * range)))
            return 3;
        if (GeneralMethods.range(xStart + (3 * range), x, xStart + (4 * range)))
            return 4;
        if (GeneralMethods.range(xStart + (4 * range), x, xStart + (5 * range)))
            return 5;
        return 0;

    }
}