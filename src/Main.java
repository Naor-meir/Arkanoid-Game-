import Animation2.AnimationRunner;
import Game.GameFlow;
import Game.Level1;
import Game.Level2;
import Game.Level3;
import Interfaces.LevelInformation;
import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

public class ass3 {
    public static void main(String[] args) {
        List<LevelInformation> levelInformations = new ArrayList<>();
        try {
            for (String arg : args) {
                if (Integer.parseInt(arg) == 1) {
                    Level1 level1 = new Level1();
                    levelInformations.add(level1);
                } else if (Integer.parseInt(arg) == 2) {
                    Level2 level2 = new Level2();
                    levelInformations.add(level2);
                } else if (Integer.parseInt(arg) == 3) {
                    Level3 level3 = new Level3();
                    levelInformations.add(level3);

                }
            }
        } catch (Exception e) {
            Level1 level1 = new Level1();
            levelInformations.add(level1);
            Level2 level2 = new Level2();
            levelInformations.add(level2);
            Level3 level3 = new Level3();
            levelInformations.add(level3);
        }
        GUI gui = new GUI("Game", 500, 500);
        AnimationRunner animationRunner = new AnimationRunner(gui, 60);
        GameFlow gameFlow = new GameFlow(animationRunner, gui.getKeyboardSensor(), gui.getDrawSurface());
        gameFlow.runLevels(levelInformations);

        gui.close();

    }
}
