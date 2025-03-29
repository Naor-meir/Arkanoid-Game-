package Game;

import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.*;

/**
 * The type Back ground 3.
 */
public class BackGround3 implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 500, 500);
        Color color = new Color(255, 196, 0, 255);
        d.setColor(color);
        d.fillCircle(150, 150, 40);
        d.setColor(Color.white);
        d.drawOval(20, 100, 450, 100);
        d.drawOval(30, 100, 400, 100);
        d.drawOval(40, 100, 350, 100);
        d.drawOval(50, 100, 300, 100);
        d.drawOval(60, 100, 250, 100);
        d.drawOval(70, 100, 200, 100);
        d.setColor(Color.gray);
        d.fillCircle(220, 185, 17);
        d.setColor(new Color(140, 81, 92, 255));
        d.fillCircle(300, 150, 15);
        d.setColor(Color.blue);
        d.fillCircle(350, 150, 10);
        d.setColor(new Color(94, 2, 2));
        d.fillCircle(390, 150, 13);
        d.setColor(new Color(255, 115, 0));
        d.fillCircle(430, 150, 15);
        d.drawOval(410, 144, 45, 20);
        d.setColor(new Color(109, 199, 195));
        d.fillCircle(460, 130, 13);


    }


    @Override
    public void timePassed() {

    }
}
