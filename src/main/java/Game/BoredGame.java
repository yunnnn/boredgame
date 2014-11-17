package Game;

import Game.CoreObjects.Coordinate;
import Game.CoreObjects.LevelMap;
import Game.GameState.GameState;
import Game.ScriptedLevels.Level1;
import Game.UI.GamePanel;
import Game.UI.UnitPanel;
import Game.UI.Utils.ImageProperties;

/**
 * Created by yun on 11/8/14.
 */
public class BoredGame {

    public static void main(String[] argv) {
        System.out.println("Loading Players... Size: " + Level1.cols + "," + Level1.rows);

        System.out.println("Loading LevelMap... Size: " + Level1.cols + "," + Level1.rows);
        final LevelMap map = Level1.init(); //load the hardcoded map

        System.out.println("Loading Game.UI elements...");
        GamePanel.init(ImageProperties.SCREEN_WIDTH, ImageProperties.SCREEN_HEIGHT); //create jframe
        GamePanel.get().renderChildren(map); //load child ui
        GamePanel.get().revalidate(); //build the ui

        GameState.get().setCurrentLocationFocus(new Coordinate(0, 0));

        System.out.println("Starting game...");
        execute(); //start the game
    }

    private static void execute() {

        //todo: add more stuff?
        GameState.get().startTurn();

    }
}

