package UI.Render;

import CoreObjects.Coordinate;
import CoreObjects.Direction;
import GameState.GameState;
import UI.Textures.GamePanel;

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
        processAction(e.getKeyChar());
    }

    @Override
    public void keyPressed(final KeyEvent e) {
    }

    @Override
    public void keyReleased(final KeyEvent e) {
    }


    private void processAction(final char c) {
        LocationPanel highlightTarget = null;
        switch (c){
            case 'w':
                highlightTarget = getAdjacent(Direction.UP);
                break;
            case 'a':
                highlightTarget = getAdjacent(Direction.LEFT);
                break;
            case 's':
                highlightTarget = getAdjacent(Direction.DOWN);
                break;
            case 'd':
                highlightTarget = getAdjacent(Direction.RIGHT);
                break;
            case '\n':
                processSubmit();
                return;
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
            GameState.setCurrentLocation(jPanel);
        }
    }

    private void unHighlight() {
        if (GameState.getCurrentLocation() != null) {
            GameState.setCurrentLocationBorder(EMPTY_BORDER);
        }
    }

    //todo: refactor this into a better location/static util method
    private LocationPanel getAdjacent(final Direction direction) {
        final Coordinate coords = GameState.getCurrentLocationCoords();
        int x = coords.getX();
        int y = coords.getY();
        switch (direction){
            case UP:
                y -= 1;
                break;
            case DOWN:
                y += 1;
                break;
            case LEFT:
                x -= 1;
                break;
            case RIGHT:
                x += 1;
                break;
        }
        return getLocationPanel(x, y);
    }
    private LocationPanel getLocationPanel(final int x, final int y){
        return GamePanel.get().getMapPanel().getLocationPanel(x, y);
    }

}
