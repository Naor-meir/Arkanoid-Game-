package Animation2;

import GameInfo.SpriteCollection;
import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.Sleeper;

/**
 * The type Countdown animation.
 */
// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
public class CountdownAnimation implements Animation {
    private SpriteCollection sprites;
    private long numfSeconds;
    private int countFrom;
    private boolean stop;
    private Sleeper sleeper = new Sleeper();

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(long numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.sprites = gameScreen;
        this.numfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.stop = false;
    }


    /**
     * Do one frame.
     *
     * @param d the d
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        String string;
        if (countFrom < 0) {
            this.stop = true;
        }

        if (this.countFrom == 0) {
            string = "GO";
        } else {
            string = String.valueOf(countFrom);
        }
        d.drawText(150, d.getHeight() / 2, string, 32);
        sleeper.sleepFor(numfSeconds);
        this.countFrom = this.countFrom - 1;


    }

    /**
     * Should stop boolean.
     *
     * @return the boolean
     */
    public boolean shouldStop() {
        return this.stop;
    }
}

