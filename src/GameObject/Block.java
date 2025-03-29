package GameObject;

import Geometry.*;
import Geometry.Point;
import Geometry.Rectangle;
import Interfaces.Collidable;
import Interfaces.HitListener;
import Interfaces.HitNotifier;
import Interfaces.Sprite;
import biuoop.DrawSurface;
import Game.GameLevel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private final Rectangle rectangle;
    private Color color;
    private List<HitListener> hitListeners = new ArrayList<>();

    /**
     * Instantiates a new Block.
     *
     * @param rectangle the rectangle
     * @param color     the color
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
    }

    /**
     * Sets color.
     *
     * @param color1 the color 1
     */
    public void setColor(Color color1) {
        this.color = color1;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (collisionPoint == null || currentVelocity == null)
            return currentVelocity;
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        List<Line> lineList = rectangle.getLineList();
        for (Line line : lineList) {
            if (line.pointOnLine(collisionPoint)) {
                if (line.isVertical()) {
                    dx = -dx;
                }
                if (line.isSlope_0()) {
                    dy = -dy;
                }
            }
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX()
                , (int) this.rectangle.getUpperLeft().getY()
                , (int) this.rectangle.getWidth()
                , (int) this.rectangle.getHeight());
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX()
                , (int) this.rectangle.getUpperLeft().getY()
                , (int) this.rectangle.getWidth()
                , (int) this.rectangle.getHeight());

    }


    @Override
    public void timePassed() {
        return;
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Remove from game.
     *
     * @param gameLevel the game level
     */
    public void removeFromGame(GameLevel gameLevel) {

    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);

    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);

    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Gets rectangle.
     *
     * @return the rectangle
     */
    protected Rectangle getRectangle() {
        return this.rectangle;
    }
}
