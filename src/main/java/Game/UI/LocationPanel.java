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
    private UnitPanel unit;

    public LocationPanel() {
        super();
        this.setBounds(0, 0, ImageProperties.LOC_WIDTH, ImageProperties.LOC_HEIGHT);
    }

    public LocationPanel(final Location location) {
        super();
        this.location = location;
        this.setLayout(null);
        this.setBounds(0, 0, ImageProperties.LOC_WIDTH, ImageProperties.LOC_HEIGHT);
        //load an image into the layeredPane at {x,y}
        final Coordinate coords = location.getCoords();

        //todo: this doesnt show anymore after I put the unitPanel in
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
    }

    public void renderChildren() {
        if (this.location != null && this.location.getUnit() != null) {
            final Unit unit = this.location.getUnit();
            final UnitPanel unitPanel = new UnitPanel(unit);
            this.add(unitPanel);
            this.unit = unitPanel;
            unitPanel.renderChildren();
        }
    }

    public boolean isEmptyLocation() {
        return this.location == null;
    }
}
