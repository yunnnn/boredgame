package UI.Render;

import CoreObjects.Coordinate;
import CoreObjects.GameObject;
import CoreObjects.Location;
import UI.Textures.GameImageUtils;
import UI.Textures.Layer;
import Units.Unit;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yun on 11/8/14.
 */
public class LocationPanel extends JPanel {

    final Location location;

    public LocationPanel(final Location location) {
        super();
        this.location = location;
        //load an image into the layeredPane at {x,y}
        final Coordinate coords = location.getCoords();
        final JLabel label = new JLabel("{" + coords.getX() + "," + coords.getY() + "}");
        this.add(label);
    }

    public Location getLoc(){
        return this.location;
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(GameImageUtils.LOCATION_IMAGE, 0, 0, null);

        // hard code the children into the Locationpanel,
        // because I can't get it to work in the UnitPanel
        final Unit unit = this.location.getOccupyingUnit();
        if (unit != null) {
            final String unitName = unit.getClass().getSimpleName();
            final int locationOffset = 12; //character offset
            Image image = null;
            if (unitName.equals("Swordsman")) {
                image = GameImageUtils.SWORDSMAN_IMAGE;
            } else if (unitName.equals("Overlord")) {
                image = GameImageUtils.OVERLORD_IMAGE;
            } else {
                image = GameImageUtils.DRAGON_IMAGE;
            }
            g.drawImage(image, locationOffset, locationOffset, null);
        }
    }

    public void renderChildren() {
        //dont do this for now since ive hardcoded it above
//        for (final GameObject child : location.getChildren()) {
//            final UnitPanel unitPanel = new UnitPanel((Unit) child);
//            this.add(unitPanel);
//            unitPanel.renderChildren();
//        }
    }
}
