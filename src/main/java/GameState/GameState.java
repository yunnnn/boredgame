package GameState;

import CoreObjects.Coordinate;
import UI.GamePanel;
import UI.LocationPanel;

import javax.swing.border.Border;

/**
 * Created by yun on 11/15/14.
 */
public class GameState {

    private Coordinate currentLocationFocus;

    private static GameState GAMESTATE; //Singleton
    public static GameState get() {
        if (GAMESTATE == null) {
            GAMESTATE = new GameState();
        }
        return GAMESTATE;
    }
    private GameState(){
    }

    public Coordinate getCurrentLocationFocus() {
        return this.currentLocationFocus;
    }

    public void setCurrentLocationFocus(final Coordinate currentLocation) {
        this.currentLocationFocus = currentLocation;
    }

    public void setCurrentLocationBorder(final Border border) {
        getCurrentLocationPanel().setBorder(border);
    }

    private LocationPanel getCurrentLocationPanel(){
        return GamePanel.get().getMapPanel().getLocationPanel(currentLocationFocus);
    }

}
