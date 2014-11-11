package ScriptedLevels;

import CoreObjects.Coordinate;
import CoreObjects.GridMap;
import CoreObjects.LevelMap;
import CoreObjects.Location;
import CoreObjects.SquareTile;
import Units.Overlord;
import Units.Swordsman;

/**
 * Created by yun on 11/8/14.
 */
public class Level1 {

    public static LevelMap init() {
        final Location[][] locations = new Location[4][4];
        final GridMap gridMap = new GridMap(locations);

        // ST Coordinates
        // (0,0) (1,0)
        // (0,1) (1,1)

        //make the tiles
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final SquareTile tile = new SquareTile(new Coordinate(i, j));
                gridMap.addNewLocation(tile);
            }
        }

        //add some dudes
        locations[1][0].addUnit(new Overlord());
        locations[3][3].addUnit(new Swordsman());

        return new LevelMap(gridMap);
    }

}
