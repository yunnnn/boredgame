package UI.Render;

import CoreObjects.Coordinate;
import CoreObjects.GameObject;
import CoreObjects.LevelMap;
import CoreObjects.Location;
import UI.Textures.GameImageUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yun on 11/8/14.
 */
public final class MapPanel extends JPanel {

    private final LevelMap map;
    private final GridLayout gridLayout;
    private final List<LocationPanel> locationPanels = new ArrayList();

    public MapPanel(final LevelMap map) {
        super();
        this.map = map;
        this.setBounds(100, 35, 500, 500);
        this.gridLayout = new GridLayout(4, 4, 0, 0);
        this.setLayout(this.gridLayout);
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(GameImageUtils.MAP_IMAGE, 0, 0, null);
    }

    public void renderChildren() {
        for (final GameObject child : this.map.getLocations()) {
            if (child == null) {
                this.add(new JLabel(""));
            } else {
                final LocationPanel locationPanel = new LocationPanel((Location) child);
                locationPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(locationPanel);
                this.locationPanels.add(locationPanel);
                locationPanel.renderChildren();
            }
        }
    }

    public LocationPanel getLocationPanel(final int x, final int y){
        for (final LocationPanel child : this.locationPanels) {
            final Coordinate coords = child.getLoc().getCoords();
            if (coords.getX() == x && coords.getY() == y){
                return child;
            }
        }
        return null;
    }
}
