package Game;

import GameObject.Block;
import General.GeneralMethods;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import Interfaces.LevelInformation;
import Interfaces.Sprite;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 3.
 */
public class Level3 implements LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the int
     */
    @Override
    public int numberOfBalls() {
        return 5;
    }

    /**
     * Initial ball velocities list.
     *
     * @return the list
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            velocities.add(Velocity.fromAngleAndSpeed(180 * i + 90, 7));
        }
        return velocities;
    }

    /**
     * Paddle speed int.
     *
     * @return the int
     */
    @Override
    public int paddleSpeed() {
        return 7;
    }

    /**
     * Paddle width int.
     *
     * @return the int
     */
    @Override
    public int paddleWidth() {
        return 80;
    }

    /**
     * Level name string.
     *
     * @return the string
     */
    @Override
    public String levelName() {
        return "level3";
    }

    /**
     * Gets background.
     *
     * @return the background
     */
    @Override
    public Sprite getBackground() {
        return new BackGround3();
    }

    /**
     * Blocks list.
     *
     * @return the list
     */
    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                blockList.add(new Block(new Rectangle(new Point(20 + i * 30.5, 100 + j * 30), 30, 30), GeneralMethods.randomColor()));
            }
        }
        return blockList;
    }


    /**
     * Number of blocks to remove int.
     *
     * @return the int
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 150;
    }
}
