package UI.Utils;

import CoreObjects.Coordinate;
import CoreObjects.Direction;
import GameState.GameState;
import UI.GamePanel;
import UI.LocationPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by yun on 11/15/14.
 */
public class KeyboardListener implements KeyListener{

    private static final EmptyBorder EMPTY_BORDER = (EmptyBorder) BorderFactory.createEmptyBorder();
    private static final Border HIGHLIGHTED_BORDER = BorderFactory.createLineBorder(Color.RED, 2);

    public KeyboardListener(){
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
        switch (keyCode){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                highlightTarget = getAdjacent(Direction.UP);
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                highlightTarget = getAdjacent(Direction.LEFT);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                highlightTarget = getAdjacent(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                highlightTarget = getAdjacent(Direction.RIGHT);
                break;
            case KeyEvent.VK_SPACE:
            case KeyEvent.VK_ENTER:
                System.out.println("Submit request.");
                processSubmit();
                return;
            default:
                System.out.println("Pressed Non-action: " + keyCode);
        }
        highlight(highlightTarget);
    }

    private void processSubmit() {
        return;
    }

    private void highlight(final LocationPanel jPanel) {
        if (jPanel != null) {
            unHighlight();
            jPanel.setBorder(HIGHLIGHTED_BORDER);
            GameState.get().setCurrentLocationFocus(jPanel.getCoords());
        }
    }

    private void unHighlight() {
        if (GameState.get().getCurrentLocationFocus() != null) {
            GameState.get().setCurrentLocationBorder(EMPTY_BORDER);
        }
    }

    private LocationPanel getAdjacent(final Direction direction) {
        final Coordinate coords = GameState.get().getCurrentLocationFocus();
        final Coordinate adjacentCoords = Coordinate.getAdjacent(coords, direction);
        return GamePanel.get().getMapPanel().getLocationPanel(adjacentCoords);
    }

}
