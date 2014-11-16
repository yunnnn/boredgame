import CoreObjects.LevelMap;
import GameState.GameState;
import ScriptedLevels.Level1;
import UI.Render.LocationPanel;
import UI.Textures.GamePanel;

/**
 * Created by yun on 11/8/14.
 */
public class BoredGame {

    private static int SCREEN_WIDTH = 800;
    private static int SCREEN_HEIGHT = 600;

    private static boolean gameOver = false;

    public static void main(String[] argv) {
        GamePanel.init(SCREEN_WIDTH, SCREEN_HEIGHT); //create jframe
        final LevelMap map = Level1.init(); //load the hardcoded map
        GamePanel.get().renderChildren(map); //load child ui
        GamePanel.get().revalidate(); //build the ui

        final LocationPanel startLocation = GamePanel.get().getMapPanel().getLocationPanel(0, 0);
        GameState.setCurrentLocation(startLocation);

        execute(); //start the game
    }

    private static void execute() {
        while (!BoredGame.gameOver){
            //poll user
        }
    }
}
