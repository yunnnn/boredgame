package Game.ScriptedLevels;

import Game.CoreObjects.Coordinate;
import Game.CoreObjects.GridMap;
import Game.CoreObjects.LevelMap;
import Game.CoreObjects.Location;
import Game.CoreObjects.SquareTile;
import Game.Units.Overlord;
import Game.Units.Swordsman;

/**
 * Created by yun on 11/8/14.
 */
public class Level1 {

    public static final int rows = 5;

    // y1 x x x x x
    // y2 x x x x x
    // y3 x x x x x
    // y4 x x x x x
    // y5 x x x x x (6, 5)
    public static final int cols = 6;
    public static LevelMap MAP;//for debugging

    public static LevelMap init() {
        final Location[][] locations = new Location[cols][rows];
        final GridMap gridMap = new GridMap(locations);

        // ST Coordinates
        // (0,0) (1,0)
        // (0,1) (1,1)

        //make the tiles
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {

                //add some gaps
                if (j == 1 && i == 1) {
                    continue;
                }
                if (j == 2 && i == 2) {
                    continue;
                }
                if (j == 0 && i == 3) {
                    continue;
                }
                final SquareTile tile = new SquareTile(new Coordinate(i, j));
                gridMap.addNewLocation(tile);
            }
        }

        //add some dudes
        locations[1][0].addUnit(new Overlord());
        locations[3][3].addUnit(new Swordsman());

        final LevelMap levelMap = new LevelMap(gridMap);
        MAP = levelMap;

        System.out.println("Level1 Loaded.");
        return levelMap;
    }

}
