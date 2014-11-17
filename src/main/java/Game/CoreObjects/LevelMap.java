package Game.CoreObjects;

import Game.Units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * The map of the level
 *
 * @author yun
 */
public class LevelMap extends GameObject {

    final GridMap gridMap;
    final private List<Unit> units = new ArrayList();

    public LevelMap(final GridMap gridMap) {
        this.gridMap = gridMap;
    }

    public List<GameObject> getLocations() {
        return this.gridMap.getLocationsAsList();
    }

    public GameObject getLocationObject(final int x, final int y) {
        return this.gridMap.getLocation(x, y);
    }
}
