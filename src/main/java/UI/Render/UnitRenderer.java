package UI.Render;

import CoreObjects.Coordinate;
import CoreObjects.GameObject;
import UI.Textures.GameImageUtils;
import UI.Textures.GamePanel;
import UI.Textures.Layer;
import Units.Unit;

/**
 * Created by yun on 11/8/14.
 */
public class UnitRenderer extends Renderer{

    final Unit unit;

    public UnitRenderer(final Unit unit){
        this.unit = unit;
    }

    public void render() {
        renderItself();

        for (final GameObject child : this.unit.getChildren()) {
        //MoreRenderer.render(child);
        }
    }

    void renderItself() {
        //load an image into the layeredPane at {x,y}
        final Coordinate coords = this.unit.getLocation().getCoords();



        final int offset = 10;
        final int locationSize = GameImageUtils.SWORDSMAN_IMAGE.getIconWidth();
        final int x = coords.getX() * (locationSize + offset);
        final int y = coords.getY() * (locationSize + offset);

        final Integer depth = Layer.UNIT.getValue();

        GamePanel.get().loadImage(GameImageUtils.SWORDSMAN_IMAGE, depth, x, y);

    }
}
