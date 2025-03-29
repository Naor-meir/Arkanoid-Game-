package Game;

import GameObject.Block;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 1.
 */
public class Level1 implements LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the int
     */
    @Override
    public int numberOfBalls() {
        return 1;
    }

    /**
     * Initial ball velocities list.
     *
     * @return the list
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocity = new ArrayList<>();
        velocity.add(new Velocity(0, 7));
        return velocity;
    }

    /**
     * Paddle speed int.
     *
     * @return the int
     */
    @Override
    public int paddleSpeed() {
        return 5;
    }

    /**
     * Paddle width int.
     *
     * @return the int
     */
    @Override
    public int paddleWidth() {
        return 50;
    }

    /**
     * Level name string.
     *
     * @return the string
     */
    @Override
    public String levelName() {
        return "Level1";
    }

    /**
     * Gets background.
     *
     * @return the background
     */
    @Override
    public Sprite getBackground() {
        return new BackGround1();
    }


    /**
     * Blocks list.
     *
     * @return the list
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks1 = new ArrayList<>();
        Rectangle rectangle = new Rectangle(new Point(210, 80), 30, 30);
        blocks1.add(new Block(rectangle, Color.RED));
        return blocks1;
    }

    /**
     * Number of blocks to remove int.
     *
     * @return the int
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
