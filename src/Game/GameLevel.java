package Game;

import GameInfo.*;
import GameObject.Block;
import GameObject.Paddle;
import General.Consts;
import Geometry.Ball;
import Geometry.Point;
import Geometry.Rectangle;
import Geometry.Velocity;
import Interfaces.Animation;
import Interfaces.Collidable;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Animation2.*;
import biuoop.KeyboardSensor;


/**
 * The type Game level.
 */
public class GameLevel implements Animation {

    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private Counter counterOfBlocks = new Counter();
    private Counter counterOfBals = new Counter();
    private Counter score = new Counter();
    private ScoreIndicator ScoreIndicator = new ScoreIndicator(Consts.RECTANGLE_OF_SORCE, Consts.COLOR_OF_RECTANGLE_OF_SORCE, score);
    //    private final GUI gui = new GUI("Game", 800, 600);
    private AnimationRunner runner;

    private LevelInformation levelInformation;
    private KeyboardSensor ks;
    private List<Ball> ballList = new ArrayList<>();


    /**
     * Instantiates a new Game level.
     *
     * @param animationRunner the animation runner
     * @param ks2             the ks 2
     */
    public GameLevel(AnimationRunner animationRunner, KeyboardSensor ks2) {
        this.runner = animationRunner;
        this.ks = ks2;
    }

    /**
     * Sets level information.
     *
     * @param levelInformation the level information
     */
    public void setLevelInformation(LevelInformation levelInformation) {
        this.levelInformation = levelInformation;
    }

    /**
     * Add collidable.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);

    }

    /**
     * Add sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);

    }

    /**
     * Initialize.
     */
// Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.
    public void initialize() {
        initializeBeckGround();
        BlocksOFBackGround();
        initializeOtherBlocks();
        initializeBalls();
        initializeScore();
        initializePaddle();
    }

    /**
     * Run.
     */
// Run the game -- start the animation loop.
    public void run() {
//       this.initialize();
        this.runner.run(new CountdownAnimation(1000, 3, sprites));
        this.runner.run(this);

    }

    private void initializePaddle() {
        Rectangle rectangleOfPaddle = new Rectangle(new Point(200, 475), this.levelInformation.paddleWidth(), 5);
        Paddle paddle = new Paddle(rectangleOfPaddle, Color.yellow, this.levelInformation.paddleSpeed());
        paddle.addToGame(this);
        paddle.setKeyboard(this.ks);
    }

    private void initializeBeckGround() {
        addSprite(levelInformation.getBackground());
    }

    private void BlocksOFBackGround() {
        Block right = new Block(Consts.RECTANGLE_of_RIGHT, Color.gray);
        Block left = new Block(Consts.RECTANGLE_OF_LEFT, Color.gray);
        Block up = new Block(Consts.RECTANGLE_OF_UP, Color.gray);
        Block down = new Block(Consts.RECTANGLE_OF_LOWER, Color.gray);
        down.addHitListener(new BallRemover(this, counterOfBals));
        right.addToGame(this);
        left.addToGame(this);
        up.addToGame(this);
        down.addToGame(this);
    }


    private void initializeBalls() {
        List<Velocity> velocities = this.levelInformation.initialBallVelocities();
        this.ballList = new ArrayList<>();
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(Consts.CENTER_OF_BALL1, Consts.RADIOS_OF_BALL1, Color.white);
            ball.setVelocity(velocities.get(i));
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
            this.ballList.add(ball);
        }
        counterOfBals.increase(this.levelInformation.numberOfBalls());
    }

    private void initializeOtherBlocks() {
        for (Block block : this.levelInformation.blocks()) {
            block.addHitListener(new BlockRemover(this, this.counterOfBlocks));
            block.addHitListener(new ScoreTrackingListener(score));
            block.addToGame(this);
        }
        counterOfBlocks.increase(this.levelInformation.numberOfBlocksToRemove());
    }


    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        this.environment.getCollidableList().remove(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Sets score.
     *
     * @param number the number
     */
    public void setScore(int number) {
        this.score.increase(number);
    }

    private void initializeScore() {
        this.ScoreIndicator.addToGame(this);

    }

//    public void addBall() {
//        Ball ball1 = new Ball(Consts.CENTER_OF_BALL1, Consts.RADIOS_OF_BALL1, GeneralMethods.randomColor());
//        ball1.setVelocity(Consts.VELOCITY_OF_BALL1);
//        ball1.setGameEnvironment(this.environment);
//        ball1.addToGame(this);
//        counterOfBals.increase(1);
//    }

    /**
     * Do one frame.
     *
     * @param d the d
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.ks.isPressed("p")) {
            KeyPressStoppableAnimation keyPressStoppableAnimation = new KeyPressStoppableAnimation(ks, this.ks.SPACE_KEY, new PauseScreen());
            this.runner.run(keyPressStoppableAnimation);

        }
    }

    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean shouldStop() {
        return !(counterOfBlocks.getValue() > 0 && counterOfBals.getValue() > 0);
    }

    /**
     * No balls boolean.
     *
     * @return the boolean
     */
    public boolean NoBalls() {
        return counterOfBals.getValue() == 0;
    }

    /**
     * Gets counter of bals.
     *
     * @return the counter of bals
     */
    public Counter getCounterOfBals() {
        return counterOfBals;
    }

    /**
     * Gets ball list.
     *
     * @return the ball list
     */
    public List<Ball> getBallList() {
        return ballList;

    }

    /**
     * Remove ball.
     *
     * @param ball the ball
     */
    public void removeBall(Ball ball) {
        this.ballList.remove(ball);
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return this.score.getValue();
    }

    /**
     * Gets runner.
     *
     * @return the runner
     */
    public AnimationRunner getRunner() {
        return runner;
    }
}


