package Geometry;

import java.awt.*;

import Game.GameEnvironment;
import GameInfo.CollisionInfo;
import Interfaces.Collidable;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import Game.GameLevel;

/**
 * The type Ball.
 */
public class Ball implements Sprite {
    private Point center;
    private int radios;
    private Color color;
    private Velocity velocity;
    //    private CollisionInfo collisionInfo = new CollisionInfo();
    private GameEnvironment gameEnvironment = new GameEnvironment();

    /**
     * Instantiates a new Ball.
     *
     * @param center the center
     * @param r      the r
     * @param color  the color
     */
// constructor
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radios = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * Gets x.
     *
     * @return the x
     */
// accessors
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return this.radios;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(getX(), getY(), getSize());
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * Sets velocity.
     *
     * @param v the v
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Sets velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Sets game environment.
     *
     * @param gameEnvironment the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Move one step.
     */
    public void moveOneStep() {
        Line trjactory = new Line(this.center, pointAfter());
        CollisionInfo collisionInfo = gameEnvironment.getClosestCollision(trjactory);
        while (collisionInfo != null) {
            Point point = collisionInfo.collisionPoint();
            Collidable collidable = collisionInfo.collisionObject();
            if (collidable.getCollisionRectangle().isPointInRectangle(this.center))
               return;
            if (point.equals(pointAfter())) {
                this.center = this.velocity.applyToPoint(this.center);
            } else {
                double v = this.velocity.getSpeed() - point.distance(pointAfter()) - this.getSize();
                Velocity velocity1 = Velocity.fromAngleAndSpeed(this.velocity.getAngle(), v);

                this.center = velocity1.applyToPoint(this.center);
            }
            this.setVelocity(collidable.hit(this, point, this.velocity));
            trjactory = new Line(this.center, pointAfter());
            collisionInfo = gameEnvironment.getClosestCollision(trjactory);
        }
        this.center = this.velocity.applyToPoint(this.center);
    }


    /**
     * Point after point.
     *
     * @return the point
     */
    public Point pointAfter() {
        return new Point(this.center.getX() + this.velocity.getDx(), this.center.getY() + this.velocity.getDy());
    }

    /**
     * Remove from game.
     *
     * @param g the g
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);

    }


}


