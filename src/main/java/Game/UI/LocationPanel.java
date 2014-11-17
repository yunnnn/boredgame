package Game.UI;

import Game.CoreObjects.Coordinate;
import Game.CoreObjects.Location;
import Game.UI.Utils.ImageProperties;
import Game.Units.Unit;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yun on 11/8/14.
 */
public class LocationPanel extends JPanel {

    private Location location;

    public LocationPanel() {
        super();
        this.setBounds(0, 0, ImageProperties.LOC_WIDTH, ImageProperties.LOC_HEIGHT);
    }

    public LocationPanel(final Location location) {
        super();
        this.location = location;
        this.setBounds(0, 0, ImageProperties.LOC_WIDTH, ImageProperties.LOC_HEIGHT);
        //load an image into the layeredPane at {x,y}
        final Coordinate coords = location.getCoords();
        final JLabel label = new JLabel("{" + coords.getX() + "," + coords.getY() + "}");
        this.add(label);
    }

    public Coordinate getCoords() {
        return this.location == null ? null : this.location.getCoords();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        if (this.location == null) {
            g.drawImage(ImageProperties.NO_LOCATION_BG, 0, 0, getWidth(), getHeight(), null);
            return;
        }

        g.drawImage(ImageProperties.LOCATION_BG, 0, 0, getWidth(), getHeight(), null);

        // hard code the children into the Locationpanel,
        // because I can't get it to work in the UnitPanel
        final Unit unit = this.location.getOccupyingUnit();
        if (unit != null) {
            final String unitName = unit.getClass().getSimpleName();
            final int locationOffset = 10; //character offset
            final Image image;
            if (unitName.equals("Swordsman")) {
                image = ImageProperties.SWORDSMAN_IMAGE;
            } else if (unitName.equals("Overlord")) {
                image = ImageProperties.OVERLORD_IMAGE;
            } else {
                image = ImageProperties.DRAGON_IMAGE;
            }
            g.drawImage(image,
                    locationOffset,
                    locationOffset,
                    getWidth() - 2 * locationOffset,
                    getHeight() - 2 * locationOffset,
                    null);
        }
    }

    public void renderChildren() {
        if (this.location != null) {
            //make sure location exists
        }
        //dont do this for now since ive hardcoded it above
//        for (final GameObject child : location.getChildren()) {
//            final UnitPanel unitPanel = new UnitPanel((Unit) child);
//            this.add(unitPanel);
//            unitPanel.renderChildren();
//        }
    }

    public boolean isEmptyLocation() {
        return this.location == null;
    }
}
