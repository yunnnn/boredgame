package CoreObjects;

import Units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yun on 11/8/14.
 */
public class SquareTile extends Location {
    private Location topAdjacent = null;
    private Location bottomAdjacent = null;
    private Location leftAdjacent = null;
    private Location rightAdjacent = null;

    private Unit occupyingUnit;

    public SquareTile() {
    }

    public SquareTile(final Location topAdjacent,
                      final Location bottomAdjacent,
                      final Location leftAdjacent,
                      final Location rightAdjacent) {
        this.topAdjacent = topAdjacent;
        this.bottomAdjacent = bottomAdjacent;
        this.leftAdjacent = leftAdjacent;
        this.rightAdjacent = rightAdjacent;
    }

    @Override
    public List<GameObject> getChildren() {
        final List<GameObject> childTiles = new ArrayList();
        childTiles.add(occupyingUnit);
        return childTiles;
    }
}
