package Game.UI;

import Game.CoreObjects.Coordinate;
import Game.CoreObjects.LevelMap;
import Game.UI.Utils.GameImageUtils;
import Game.UI.Utils.KeyboardListener;
import Game.UI.Utils.Layer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yun on 11/9/14.
 */
public class GamePanel extends JPanel {

    private GridPanel gridPanel;
    private JLayeredPane layeredPane;

    private static GamePanel GAMEPANEL; //Singleton

    public static GamePanel get() {
        if (GAMEPANEL == null) {
            GAMEPANEL = new GamePanel();
        }
        return GAMEPANEL;
    }

    private GamePanel() {
        super();
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(GameImageUtils.BG_IMAGE, 0, 0, getWidth(), getHeight(), null);
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

        //Load the static BG and Menu
        gamePanel.loadMenu();

        f.add(gamePanel);
        f.addKeyListener(new KeyboardListener()); //gamePanel is both a listener
    }

    //load an image into the layeredPane
    public void loadMenu() {
        JPanel menu = new JPanel(new BorderLayout());
        menu.setBounds(
                GameImageUtils.MAP_WIDTH + GameImageUtils.MAP_XOFFSET + 20,
                GameImageUtils.MAP_YOFFSET,
                180,
                GameImageUtils.MAP_HEIGHT);

        menu.add(new JButton("ff"));
        menu.add(new JLabel("Attack"));
        menu.add(new JLabel("Menu goes here"));
        this.layeredPane.add(menu, Layer.BUFFS.getValue());
    }

    public void renderChildren(final LevelMap map) {
        //todo: must load this first, not sure why resizing the screen makes this on top
        final MapPanel mapPanel = new MapPanel();
        this.layeredPane.add(mapPanel, Layer.MAP.getValue());

        final GridPanel gridPanel = new GridPanel(map);
        gridPanel.renderChildren();
        this.gridPanel = gridPanel;
        this.layeredPane.add(gridPanel, Layer.GRID.getValue());
    }

    public GridPanel getGridPanel() {
        return this.gridPanel;
    }

    public static LocationPanel getLocationPanel(final Coordinate coords) {
        return GamePanel.get().getGridPanel().getLocationPanel(coords);
    }
}
