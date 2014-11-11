package UI.Render;

import CoreObjects.Coordinate;
import CoreObjects.GameObject;
import CoreObjects.LevelMap;
import CoreObjects.Location;
import UI.Textures.GameImageUtils;
import UI.Textures.GamePanel;
import UI.Textures.Layer;

/**
 * Created by yun on 11/8/14.
 */
public final class MapRenderer extends Renderer {

    final LevelMap map;

    public MapRenderer(final LevelMap map) {
        this.map = map;
    }

    public void render() {
        renderItself();
        for (final GameObject child : this.map.getChildren()) {
            new LocationRenderer((Location) child).render();
        }
    }

    void renderItself() {
        final int x = 100;
        final int y = 20;
        final Integer depth = Layer.MAP.getValue();
        GamePanel.get().loadImage(GameImageUtils.MAP_IMAGE, depth, x, y);
    }
}
