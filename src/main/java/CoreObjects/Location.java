package CoreObjects;

import Units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yun on 11/8/14.
 */
public abstract class Location extends GameObject {
    private Unit occupyingUnit;
    private final Coordinate coord;

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
        return occupyingUnit;
    }

    public void setOccupyingUnit(final Unit occupyingUnit) {
        this.occupyingUnit = occupyingUnit;
    }

    public boolean addUnit(final Unit unit) {
        if (this.occupyingUnit != null){
            return false;
        }
        this.occupyingUnit = unit;
        unit.setLocation(this);
        return true;
    }

    @Override
    public List<GameObject> getChildren() {
        final List<GameObject> l = new ArrayList();
        if (this.occupyingUnit != null){
            l.add(this.occupyingUnit);
        }
        return l;
    }
}
