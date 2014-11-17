package Game.UI;

import Game.CoreObjects.Coordinate;
import Game.CoreObjects.GameObject;
import Game.CoreObjects.LevelMap;
import Game.CoreObjects.Location;
import Game.ScriptedLevels.Level1;
import Game.UI.Utils.ImageProperties;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yun on 11/8/14.
 */
public final class GridPanel extends JPanel {

    private final LevelMap map;
    private final GridLayout gridLayout;
    private final List<LocationPanel> locationPanels = new ArrayList();

    public GridPanel(final LevelMap map) {
        super();
        this.map = map;

        this.setBounds(ImageProperties.MAP_XOFFSET + ImageProperties.GRID_OFFSET,
                ImageProperties.MAP_YOFFSET + ImageProperties.GRID_OFFSET,
                ImageProperties.GRID_WIDTH,
                ImageProperties.GRID_HEIGHT);
        this.gridLayout = new GridLayout(Level1.rows, Level1.cols, 0, 0);
        this.setLayout(this.gridLayout);
    }

    public void renderChildren() {
        for (final GameObject child : this.map.getLocations()) {
            final LocationPanel locationPanel;
            if (child == null) {
                locationPanel = new LocationPanel();
            } else {
                locationPanel = new LocationPanel((Location) child);
            }
            this.add(locationPanel);
            this.locationPanels.add(locationPanel);
            locationPanel.renderChildren();
        }
    }

    public List<LocationPanel> getLocationPanels() {
        return this.locationPanels;
    }

    public LocationPanel getLocationPanel(final Coordinate coords) {
        return getLocationPanel(coords.getX(), coords.getY());
    }

    public LocationPanel getLocationPanel(final int x, final int y) {
        for (final LocationPanel child : this.locationPanels) {
            if (!child.isEmptyLocation()) {
                final Coordinate coords = child.getCoords();
                if (coords.getX() == x && coords.getY() == y) {
                    return child;
                }
            }
        }
        return null;
    }
}
