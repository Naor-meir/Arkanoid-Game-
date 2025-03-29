package Game;

import Animation2.*;
import Geometry.Ball;
import Interfaces.Animation;
import Interfaces.LevelInformation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * The type GameFlow.
 */
public class GameFlow {
    private final AnimationRunner animationRunner;
    private final KeyboardSensor keyboardSensor;
    private final DrawSurface drawSurface;
    private int myScore;

    /**
     * Instantiates a new GameFlow.
     *
     * @param ar          the animation runner
     * @param ks          the keyboard sensor
     * @param drawSurface the draw surface
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, DrawSurface drawSurface) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.drawSurface = drawSurface;
    }

    /**
     * Runs all levels, and handles game over / win states.
     *
     * @param levels the levels to run
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean playAgain = true;

        while (playAgain) {
            GameLevel level = new GameLevel(this.animationRunner, this.keyboardSensor);

            for (LevelInformation levelInfo : levels) {
                level.setLevelInformation(levelInfo);
                level.initialize();

                while (!level.shouldStop()) {
                    level.run();
                }

                if (level.NoBalls()) {
                    // Show GameOver screen with score
                    GameOver gameOverScreen = new GameOver(level.getScore());

                    // Wrap it to listen for R/Q keys
                    GameOverStoppable wrapper = new GameOverStoppable(this.keyboardSensor, gameOverScreen);

                    // Run the wrapped animation
                    this.animationRunner.run(wrapper);

                    // If player pressed 'r' – restart from beginning
                    if (wrapper.shouldRestart()) {
                        runLevels(levels);
                    }

                    return; // Otherwise quit
                }


                // Clean up balls
                for (Ball ball : level.getBallList()) {
                    ball.removeFromGame(level);
                }
                level.getCounterOfBals().setCounter(0);
                this.myScore = level.getScore();
            }

            // If player didn't lose → show win screen
            if (!level.NoBalls()) {
                Animation youWinScreen = new YouWin(level.getScore());
                Animation stoppableWin = new KeyPressStoppableAnimation(
                        this.keyboardSensor, KeyboardSensor.SPACE_KEY, youWinScreen);
                this.animationRunner.run(stoppableWin);
                playAgain = false;
            }
        }
    }
}
