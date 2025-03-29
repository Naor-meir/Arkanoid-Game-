package Game;

import GameObject.Block;
import General.GeneralMethods;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import Interfaces.LevelInformation;
import Interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 2.
 */
public class Level2 implements LevelInformation {


    /**
     * Number of balls int.
     *
     * @return the int
     */
    @Override
    public int numberOfBalls() {
        return 10;
    }

    /**
     * Initial ball velocities list.
     *
     * @return the list
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            velocityList.add(Velocity.fromAngleAndSpeed(12 * i + 210, 7));
        }
        return velocityList;
    }

    /**
     * Paddle speed int.
     *
     * @return the int
     */
    @Override
    public int paddleSpeed() {
        return 9;
    }

    /**
     * Paddle width int.
     *
     * @return the int
     */
    @Override
    public int paddleWidth() {
        return 90;
    }

    /**
     * Level name string.
     *
     * @return the string
     */
    @Override
    public String levelName() {
        return "Level 2";
    }

    /**
     * Gets background.
     *
     * @return the background
     */
    @Override
    public Sprite getBackground() {
        return new BackGround2();
    }

    /**
     * Blocks list.
     *
     * @return the list
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 20; i < 480; i = i + 23) {
            blocks.add(new Block(new Rectangle(new Point(i, 200), 23, 20), GeneralMethods.randomColor()));
        }
        return blocks;
    }


    /**
     * Number of blocks to remove int.
     *
     * @return the int
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 20;
    }
}
