package Game.CoreObjects;

import Game.Units.Unit;

/**
 * Created by yun on 11/8/14.
 */
public abstract class Location extends GameObject {
    private final Coordinate coord;
    private Unit occupyingUnit;

    protected Location(Coordinate coord) {
        this.coord = coord;
    }

    public Coordinate getCoords() {
        return this.coord;
    }

    public boolean hasOccupyingUnit() {
        return occupyingUnit != null;
    }

    public Unit getOccupyingUnit() {
        return this.occupyingUnit;
    }

    public void setOccupyingUnit(final Unit occupyingUnit) {
        this.occupyingUnit = occupyingUnit;
    }

    public boolean addUnit(final Unit unit) {
        if (this.occupyingUnit != null) {
            return false;
        }
        this.occupyingUnit = unit;
        unit.setLocation(this);
        return true;
    }
}
