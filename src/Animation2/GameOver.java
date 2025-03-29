package Animation2;

import Interfaces.Animation;
import biuoop.DrawSurface;

public class GameOver implements Animation {
    private final int score;

    public GameOver(int score) {
        this.score = score;
    }



    @Override
    public boolean shouldStop() {
        return false; // Never stops on its own — needs to be wrapped
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        int centerX = d.getWidth() / 2;

        // שורות ההודעה
        String mainText = "Game Over. Your score is " + score;
        String subText = "Press R to restart or Q to quit";

        // צייר טקסט במרכז המסך (בערך)
        d.drawText(centerX - 200, d.getHeight() / 2 - 40, mainText, 32);
        d.drawText(centerX - 150, d.getHeight() / 2 + 10, subText, 24);
    }

}
