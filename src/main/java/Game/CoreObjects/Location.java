package Game.CoreObjects;

import Game.Units.Unit;

/**
 * Created by yun on 11/8/14.
 */
public abstract class Location extends GameObject {
    private final Coordinate coord;
    private Unit unit;

    protected Location(Coordinate coord) {
        this.coord = coord;
    }

    public Coordinate getCoords() {
        return this.coord;
    }

    public boolean hasUnit() {
        return this.unit != null;
    }

    public Unit getUnit() {
        return this.unit;
    }

    public void setUnit(final Unit unit) {
        this.unit = unit;
    }

    public boolean addUnit(final Unit unit) {
        if (this.unit != null) {
            return false;
        }
        this.unit = unit;
        unit.setLocation(this);
        return true;
    }
}
