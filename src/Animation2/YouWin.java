package Animation2;

import Interfaces.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;


/**
 * The type You win.
 */
public class YouWin implements Animation {

    private boolean stop = false;
    private int score;

    /**
     * Instantiates a new You win.
     *
     * @param socer the socer
     */
    public YouWin(int socer) {
        this.score = socer;
    }


    /**
     * Do one frame.
     *
     * @param d the d
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score, 32);
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
