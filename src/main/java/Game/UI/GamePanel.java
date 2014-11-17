package Game.UI;

import Game.CoreObjects.Coordinate;
import Game.CoreObjects.LevelMap;
import Game.GameState.GameState;
import Game.UI.Utils.ImageProperties;
import Game.UI.Utils.KeyboardListener;
import Game.UI.Utils.Layer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by yun on 11/9/14.
 */
public class GamePanel extends JPanel {

    private static GamePanel GAMEPANEL; //Singleton
    private GridPanel gridPanel;
    private JLayeredPane layeredPane;
    private MenuPanel menuPanel;

    private GamePanel() {
        super();
    }

    public static GamePanel get() {
        if (GAMEPANEL == null) {
            GAMEPANEL = new GamePanel();
        }
        return GAMEPANEL;
    }

    //Create the main JFrame, and attach the GamePanel to it.
    public static void init(final int screenWidth,
                            final int screenHeight) {
        JFrame f = new JFrame("Bored Game");
        // By default, the window is not visible. Make it visible.
        f.setVisible(true);
        f.setSize(screenWidth, screenHeight);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(screenWidth, screenHeight));

        final GamePanel gamePanel = GamePanel.get();
        gamePanel.layeredPane = layeredPane;
        gamePanel.add(layeredPane);

        f.add(gamePanel);
        f.addKeyListener(new KeyboardListener()); //gamePanel is both a listener
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageProperties.BG_IMAGE, 0, 0, getWidth(), getHeight(), null);
    }

    public void renderChildren(final LevelMap map) {
        final MenuPanel menuPanel = new MenuPanel();
        this.menuPanel = menuPanel;
        this.layeredPane.add(menuPanel, Layer.BUFFS.getValue());
        

        //todo: must load this first, not sure why resizing the screen makes this on top
        final MapPanel mapPanel = new MapPanel();
        this.layeredPane.add(mapPanel, Layer.MAP.getValue());

        final GridPanel gridPanel = new GridPanel(map);
        gridPanel.renderChildren();
        this.gridPanel = gridPanel;
        this.layeredPane.add(gridPanel, Layer.GRID.getValue());
    }

    public void setPlayerTurn(final String player) {
        //set the turn on the ui

    }

    public LocationPanel getLocationPanel(final Coordinate coords) {
        return this.gridPanel.getLocationPanel(coords);
    }

    public void setCurrentLocationBorder(final Border border) {
        final Coordinate currentLocation = GameState.get().getCurrentLocationFocus();
        getLocationPanel(currentLocation).setBorder(border);
    }
}
