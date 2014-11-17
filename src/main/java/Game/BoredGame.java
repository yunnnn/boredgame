package Game;

import Game.CoreObjects.Coordinate;
import Game.CoreObjects.LevelMap;
import Game.GameState.GameState;
import Game.ScriptedLevels.Level1;
import Game.UI.GamePanel;
import Game.UI.Utils.GameImageUtils;

/**
 * Created by yun on 11/8/14.
 */
public class BoredGame {

    private static boolean gameOver = false;

    public static void main(String[] argv) {
        System.out.println("Loading LevelMap... Size: " + Level1.cols + "," + Level1.rows);
        final LevelMap map = Level1.init(); //load the hardcoded map

        System.out.println("Loading Game.UI elements...");
        GamePanel.init(GameImageUtils.SCREEN_WIDTH, GameImageUtils.SCREEN_HEIGHT); //create jframe
        GamePanel.get().renderChildren(map); //load child ui
        GamePanel.get().revalidate(); //build the ui

        GameState.get().setCurrentLocationFocus(new Coordinate(0, 0));

        System.out.println("Starting game...");
        execute(); //start the game
    }

    private static void execute() {
        while (!BoredGame.gameOver) {
            //poll user
        }
    }
}
