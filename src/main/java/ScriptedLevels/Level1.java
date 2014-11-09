package ScriptedLevels;

import CoreObjects.LevelMap;
import CoreObjects.Location;
import CoreObjects.SquareTile;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yun on 11/8/14.
 */
public class Level1 {

    public void exec(){
        
        final SquareTile tile1 = new SquareTile();
        final SquareTile tile2 = new SquareTile();
        final SquareTile tile3 = new SquareTile();
        final SquareTile tile4 = new SquareTile();
        final List<Location> tiles = new ArrayList();

        final LevelMap map = new LevelMap(tiles);
    }

}
