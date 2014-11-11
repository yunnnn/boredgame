import CoreObjects.LevelMap;
import ScriptedLevels.Level1;
import UI.Textures.GamePanel;

/**
 * Created by yun on 11/8/14.
 */
public class BoredGame {

    private static int SCREEN_WIDTH = 800;
    private static int SCREEN_HEIGHT = 600;

    public static void main(String[] argv) {
        GamePanel.init(SCREEN_WIDTH, SCREEN_HEIGHT); //create jframe
        final LevelMap map = Level1.init(); //load the hardcoded map
        GamePanel.get().renderChildren(map); //load child ui

        GamePanel.get().revalidate(); //build the ui
    }
}
