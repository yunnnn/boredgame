package UI.Render;

import CoreObjects.Coordinate;
import CoreObjects.GameObject;
import CoreObjects.LevelMap;
import CoreObjects.Location;
import UI.Textures.GameImageUtils;
import UI.Textures.GamePanel;
import UI.Textures.Layer;
import Units.Unit;

import javax.swing.*;

/**
 * Created by yun on 11/8/14.
 */
public class LocationRenderer extends Renderer {

    final Location l;
    public LocationRenderer(final Location location){
        this.l = location;
    }

    public void render() {
        renderItself();

//        for (final GameObject child : l.getChildren()) {
//            new UnitRenderer((Unit) child).render();
//        }
    }

    void renderItself() {
        //load an image into the layeredPane at {x,y}
        final Coordinate coords = l.getCoords();

        final int xEdgeSpacing = 135;
        final int yEdgeSpacing = 52;

        final int offset = 10;
        final int locationSize = GameImageUtils.LOCATION_IMAGE.getIconWidth();
        int x = coords.getX() * (locationSize + offset) + xEdgeSpacing;
        int y = coords.getY() * (locationSize + offset) + yEdgeSpacing;

        Integer depth = Layer.LOCATION.getValue();

        GamePanel.get().loadImage(GameImageUtils.LOCATION_IMAGE, depth, x, y);

        if (this.l.hasOccupyingUnit()){
            depth = Layer.UNIT.getValue();
            final String unitName = l.getOccupyingUnit().getClass().getSimpleName();
            ImageIcon image = null;
            if (unitName.equals("Swordsman")){
                image = GameImageUtils.SWORDSMAN_IMAGE;
            } else if (unitName.equals("Overlord")){
                image = GameImageUtils.OVERLORD_IMAGE;
            }
            x += 10; //character offset
            y += 10;

            GamePanel.get().loadImage(image, depth, x, y);
        }
    }
}
