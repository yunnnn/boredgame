package Game.Units;

import Game.CoreObjects.GameObject;
import Game.CoreObjects.Location;

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
