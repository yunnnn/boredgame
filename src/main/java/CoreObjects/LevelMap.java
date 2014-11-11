package CoreObjects;

import Units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * The map of the level
 *
 * @author yun
 */
public class LevelMap extends GameObject {

    final private List<Unit> units = new ArrayList();
    final GridMap gridMap;

    public LevelMap(final GridMap gridMap) {
        this.gridMap = gridMap;
    }

    @Override
    public List<GameObject> getChildren() {
        return gridMap.getLocationsAsList();
    }

    public GameObject getLocationObject(final int x, final int y) {
        return this.gridMap.getLocation(x, y);
    }
}
