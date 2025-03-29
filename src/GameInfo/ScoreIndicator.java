package GameInfo;

import Game.GameLevel;
import General.Consts;
import Geometry.Rectangle;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.*;

/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    private final Rectangle rectangle;
    private final Color color;
    private Counter sorce;

    /**
     * Instantiates a new Score indicator.
     *
     * @param rectangle the rectangle
     * @param color     the color
     * @param sorce     the sorce
     */
    public ScoreIndicator(Rectangle rectangle, Color color, Counter sorce) {
        this.rectangle = rectangle;
        this.color = color;
        this.sorce = sorce;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        int middleX = (int) (this.rectangle.getUpperLeft().getX() + rectangle.getWidth() * Consts.Half);
        int middleY = (int) (this.rectangle.getUpperLeft().getY() + rectangle.getHeight() * Consts.Half);
        d.setColor(Color.black);
        d.drawText(250, 10, "score :" + sorce.getValue(), 10);
    }

    @Override
    public void timePassed() {
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
