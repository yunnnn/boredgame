package ScriptedLevels;

import CoreObjects.LevelMap;
import CoreObjects.Location;
import CoreObjects.SquareTile;


/**
 * Created by yun on 11/8/14.
 */
public class Level1 {

    public static LevelMap init() {
        final Location[][] locations = new Location[2][2];
        final SquareTile tile1 = new SquareTile();
        final SquareTile tile2 = new SquareTile();
        final SquareTile tile3 = new SquareTile();
        final SquareTile tile4 = new SquareTile();
        locations[0][0] = tile1;
        locations[1][0] = tile2;
        locations[0][1] = tile3;
        locations[1][1] = tile4;

        return new LevelMap(locations);
    }

}
