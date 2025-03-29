package Animation2;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private Animation animation;
    private String key;
    private boolean stop = false;


    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboardSensor = sensor;
        this.key = key;
        this.animation = animation;
    }

    /**
     * Do one frame.
     *
     * @param drawSurface the draw surface
     */
    @Override
    public void doOneFrame(DrawSurface drawSurface) {
        animation.doOneFrame(drawSurface);
        if (this.keyboardSensor.isPressed(key)) {
            this.stop = true;
        }

    }

    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
