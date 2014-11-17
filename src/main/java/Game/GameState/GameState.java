package Game.GameState;

import Game.CoreObjects.Coordinate;
import Game.CoreObjects.Player;
import Game.UI.GamePanel;
import Game.UI.LocationPanel;
import Game.Units.Unit;

import javax.swing.border.Border;

/**
 * Created by yun on 11/15/14.
 */
public class GameState {

    private static GameState GAMESTATE; //Singleton
    private Player p1;
    private Player p2;
    private Player activePlayer;
    private Coordinate currentLocationFocus;

    private GameState() {
        this.p1 = new Player("Yun");
        this.p2 = new Player("Lobster");
        this.activePlayer = p1;
    }

    public static GameState get() {
        if (GAMESTATE == null) {
            GAMESTATE = new GameState();
        }
        return GAMESTATE;
    }

    public Coordinate getCurrentLocationFocus() {
        return this.currentLocationFocus;
    }

    public void setCurrentLocationFocus(final Coordinate currentLocation) {
        this.currentLocationFocus = currentLocation;
    }

    public Player getActivePlayer() {
        return this.activePlayer;
    }

    public void switchTurns() {
        if (this.activePlayer == this.p1) {
            this.activePlayer = this.p2;
        } else {
            this.activePlayer = this.p1;
        }
    }

    public void startTurn() {
        System.out.println(this.activePlayer.toString() + "'s turn");
        GamePanel.get().setPlayerTurn(this.activePlayer.toString());

        if (!this.activePlayer.hasOwnedUnits()) {

            //gameover
        } else {
            final Unit firstUnit = this.activePlayer.getOwnedUnits().get(0);

            //setFocus
        }

        switchTurns();
    }
}
