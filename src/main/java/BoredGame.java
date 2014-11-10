import CoreObjects.LevelMap;
import ScriptedLevels.Level1;
import UI.Textures.GamePanel;

import javax.swing.*;

/**
 * Created by yun on 11/8/14.
 */
public class BoredGame {

    private static int SCREEN_WIDTH = 800;
    private static int SCREEN_HEIGHT = 600;

    public static void main(String[] argv) {
        final GamePanel gamePanel = GamePanel.init(SCREEN_WIDTH, SCREEN_HEIGHT);

        final LevelMap map = Level1.init();
        gamePanel.loadMap(map);
    }
}
