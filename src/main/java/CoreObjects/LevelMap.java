package CoreObjects;

import UI.MapRenderer;
import Units.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yun on 11/8/14.
 */
public class LevelMap extends GameObject {

    final Location[][] locations;
    final List<Unit> units = new ArrayList();

    public LevelMap(final Location[][] locations) {
        this.locations = locations;
    }

    public void render() {
        MapRenderer.render(this);
    }

    @Override
    public List<GameObject> getChildren() {
        final List<GameObject> childTiles = new ArrayList();
        for (final Location[] locationColumn : locations) {
            for (final Location location : locationColumn) {
                childTiles.add(location);
            }
        }
        return childTiles;
    }
}
