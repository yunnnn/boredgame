import CoreObjects.Coordinate;
import CoreObjects.LevelMap;
import GameState.GameState;
import ScriptedLevels.Level1;
import UI.LocationPanel;
import UI.GamePanel;

/**
 * Created by yun on 11/8/14.
 */
public class BoredGame {

    private static int SCREEN_WIDTH = 800;
    private static int SCREEN_HEIGHT = 600;

    private static boolean gameOver = false;

    public static void main(String[] argv) {
        System.out.println("Loading LevelMap... Size: " + Level1.cols  + "," + Level1.rows);
        final LevelMap map = Level1.init(); //load the hardcoded map

        System.out.println("Loading UI elements...");
        GamePanel.init(SCREEN_WIDTH, SCREEN_HEIGHT); //create jframe
        GamePanel.get().renderChildren(map); //load child ui
        GamePanel.get().revalidate(); //build the ui

        GameState.get().setCurrentLocationFocus(new Coordinate(0, 0));

        System.out.println("Starting game...");
        execute(); //start the game
    }

    private static void execute() {
        while (!BoredGame.gameOver){
            //poll user
        }
    }
}
