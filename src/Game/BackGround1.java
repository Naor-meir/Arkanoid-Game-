package Game;

import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.*;

/**
 * The type Back ground 1.
 */
public class BackGround1 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 500, 500);
        d.setColor(Color.blue);
        for (int i = 60; i >= 30; i = i - 15) {
            d.drawCircle(225, 95, i);
        }
        d.drawLine(206, 95, 155, 95);
        d.drawLine(246, 95, 296, 95);
        d.drawLine(225, 75, 226, 25);
        d.drawLine(225, 115, 226, 170);

    }

    @Override
    public void timePassed() {
        return;
    }
}
