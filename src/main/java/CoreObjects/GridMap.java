package CoreObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * The coordinate representation of the map
 *
 * @author yun
 */
public class GridMap {

    // first array represents x, second one represents -y
    // ie, top left is 0,0
    final private Location[][] locations;

    public GridMap(final Location[][] locations) {
        this.locations = locations;
    }

    public GameObject getLocation(final int x, final int y) {
        return this.locations[x][y];
    }

    public boolean setLocation(final Location loc, final int x, final int y) {
        try {
            this.locations[x][y] = loc;
        } catch (final IndexOutOfBoundsException e) {
            System.out.println("IOOB1 GridMap.java");
            return false;
        }
        return true;
    }

    public List<GameObject> getLocationsAsList() {
        final List<GameObject> childLocations = new ArrayList();
        for (final Location[] locationColumn : this.locations) {
            for (final Location location : locationColumn) {
                childLocations.add(location);
            }
        }
        return childLocations;
    }

    public boolean addNewLocation(final Location loc) {
        try {
            final int x = loc.getCoords().getX();
            final int y = loc.getCoords().getY();
            this.locations[x][y] = loc;

        } catch (final IndexOutOfBoundsException e) {
            System.out.println("IOOB2 GridMap.java");
            return false;
        }
        return true;
    }
}
