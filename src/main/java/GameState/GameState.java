package GameState;

import CoreObjects.Coordinate;
import UI.Render.LocationPanel;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * Created by yun on 11/15/14.
 */
public class GameState {
    private static LocationPanel CURRENT_LOCATION;

    public static LocationPanel getCurrentLocation() {
        return CURRENT_LOCATION;
    }

    public static void setCurrentLocation(final LocationPanel currentLocation) {
        CURRENT_LOCATION = currentLocation;
    }

    public static void setCurrentLocationBorder(final Border border) {
        CURRENT_LOCATION.setBorder(border);
    }

    public static Coordinate getCurrentLocationCoords() {
        return CURRENT_LOCATION.getLoc().getCoords();
    }
}
