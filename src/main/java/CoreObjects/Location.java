package CoreObjects;

import Units.Unit;

/**
 * Created by yun on 11/8/14.
 */
public abstract class Location extends GameObject {

    private Unit occupyingUnit;

    public boolean hasOccupyingUnit() {
        return occupyingUnit != null;
    }

    public Unit getOccupyingUnit() {
        return occupyingUnit;
    }

    public void setOccupyingUnit(final Unit occupyingUnit) {
        this.occupyingUnit = occupyingUnit;
    }
}
