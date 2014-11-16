package Units;

import CoreObjects.GameObject;
import CoreObjects.Location;

import java.util.Collections;
import java.util.List;

/**
 * Created by yun on 11/8/14.
 */
public class Unit extends GameObject {

    Location location;

    public Unit() {
    }

    public Unit(final Location location) {
        this.location = location;

    }

    public Location getLocation() {
        return this.location;
    }
    public void setLocation(final Location location) {
        this.location = location;
    }
}
