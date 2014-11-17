package Game.CoreObjects;

import Game.Units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yun on 11/16/14.
 */
public class Player {

    private final List<Unit> ownedUnits = new ArrayList<Unit>();
    private final String playerName;

    public Player(final String name) {
        this.playerName = name;
    }

    @Override
    public final String toString() {
        return this.playerName;
    }

    public boolean hasOwnedUnits() {
        return this.ownedUnits != null && !this.ownedUnits.isEmpty();
    }

    public List<Unit> getOwnedUnits() {
        return this.ownedUnits;
    }
}
