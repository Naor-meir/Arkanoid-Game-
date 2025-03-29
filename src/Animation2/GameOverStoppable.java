package Animation2;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Wraps a GameOver animation and waits for 'r' (restart) or 'q' (quit).
 */
public class GameOverStoppable implements Animation {
    private final Animation innerAnimation; // The GameOver animation
    private final KeyboardSensor keyboard;
    private boolean stop = false;
    private boolean restart = false;

    public GameOverStoppable(KeyboardSensor keyboard, Animation innerAnimation) {
        this.keyboard = keyboard;
        this.innerAnimation = innerAnimation;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        innerAnimation.doOneFrame(d); // Draw the GameOver screen

        // Listen for user input
        if (keyboard.isPressed("r")) {
            restart = true;
            stop = true;
        } else if (keyboard.isPressed("q")) {
            stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return stop;
    }

    public boolean shouldRestart() {
        return restart;
    }
}
