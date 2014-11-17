package Game.UI.Utils;

import Game.BoredGame;
import Game.CoreObjects.Coordinate;
import Game.CoreObjects.Direction;
import Game.GameState.GameState;
import Game.UI.GamePanel;
import Game.UI.LocationPanel;
import Game.UI.UnitPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by yun on 11/15/14.
 */
public class KeyboardListener implements KeyListener {

    private static final EmptyBorder EMPTY_BORDER = (EmptyBorder) BorderFactory.createEmptyBorder();
    private static final Border HIGHLIGHTED_BORDER = BorderFactory.createLineBorder(Color.RED, 2);

    public KeyboardListener() {
    }

    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        processAction(e.getKeyCode());
    }

    @Override
    public void keyReleased(final KeyEvent e) {
    }

    private void processAction(final int keyCode) {
        LocationPanel highlightTarget = null;
        switch (keyCode) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                highlightTarget = getAdjacentPanel(Direction.UP);
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                highlightTarget = getAdjacentPanel(Direction.LEFT);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                highlightTarget = getAdjacentPanel(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                highlightTarget = getAdjacentPanel(Direction.RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Space request.");
                processSpace();
                return;
            case KeyEvent.VK_ENTER:
                System.out.println("Submit request.");
                processSubmit();
                return;
            case KeyEvent.VK_Z:
                System.out.println("Repainting Page...");
                for (final LocationPanel lp: GamePanel.get().getGridPanel().getLocationPanels()){
                    lp.repaint();
                }
            default:
                System.out.println("Pressed Non-action: " + keyCode);
        }
        highlight(highlightTarget);
    }

    //test code
    public static UnitPanel testPanel;
    public static boolean hideUnitPanel = false;
    private void processSubmit() {
        hideUnitPanel = true;
        testPanel.repaint();
    }
    private void processSpace() {
        hideUnitPanel = false;
        testPanel.repaint();
    }

    //create a border around the panel to indicate that it is highlighted
    public static void highlight(final LocationPanel jPanel) {
        if (jPanel != null) {
            unHighlight();
            jPanel.setBorder(HIGHLIGHTED_BORDER);
            GameState.get().setCurrentLocationFocus(jPanel.getCoords());
        }
    }

    //unhighlight the previous location by removing the border
    private static void unHighlight() {
        if (GameState.get().getCurrentLocationFocus() != null) {
            GamePanel.get().setCurrentLocationBorder(EMPTY_BORDER);
        }
    }

    private LocationPanel getAdjacentPanel(final Direction direction) {
        final Coordinate coords = GameState.get().getCurrentLocationFocus();
        final Coordinate adjacentCoords = Coordinate.getAdjacent(coords, direction);
        return GamePanel.get().getLocationPanel(adjacentCoords);
    }
}
