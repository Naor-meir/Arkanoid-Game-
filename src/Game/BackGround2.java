package Game;

import Geometry.Rectangle;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.*;

/**
 * The type Back ground 2.
 */
public class BackGround2 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        drawBlendBlock(d);
        Color color = new Color(255, 241, 0);
        for (int i = 0; i < 60; i++) {
            d.setColor(color);
            d.drawLine(100, 100, -100 + 10 * i, 200);
        }

        for (int i = 45; i > 15; i = i - 10) {
            d.setColor(color);
            d.fillCircle(100, 100, i);
            color = color.brighter();
        }

    }

    private void drawBlendBlock(DrawSurface d) {
        int width = d.getWidth();
        int height = d.getHeight();
        Color startColor = new Color(17, 31, 75);
        Color endColor = new Color(168, 243, 216);

        for (int i = 0; i < height; i++) {
            float ratio = (float) i / height;
            int r = (int) (startColor.getRed() * (1 - ratio) + endColor.getRed() * ratio);
            int g = (int) (startColor.getGreen() * (1 - ratio) + endColor.getGreen() * ratio);
            int b = (int) (startColor.getBlue() * (1 - ratio) + endColor.getBlue() * ratio);
            Color color = new Color(r, g, b);
            d.setColor(color);
            d.fillRectangle(0, i, width, i);

        }
    }


    @Override
    public void timePassed() {
        return;

    }
}
