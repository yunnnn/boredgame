package UI;

import CoreObjects.LevelMap;
import UI.Utils.GameImageUtils;
import UI.Utils.KeyboardListener;
import UI.Utils.Layer;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yun on 11/9/14.
 */
public class GamePanel extends JPanel {

    private MapPanel mapPanel;
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
        g.drawImage(GameImageUtils.BG_IMAGE, 0, 0, null);
    }

    //Create the main JFrame, and attach the GamePanel to it.
    public static void init(final int screenWidth, final int screenHeight) {
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
        menu.setBounds(600, 600, 0, 0);
        menu.add(new JButton("ff"));
        menu.add(new JLabel("ffss"));

        this.layeredPane.add(menu, Layer.BUFFS.getValue());
    }

    public void renderChildren(final LevelMap map) {
        final MapPanel mapPanel = new MapPanel(map);
        mapPanel.renderChildren();

        this.mapPanel = mapPanel;
        this.layeredPane.add(mapPanel, Layer.MAP.getValue());
    }

    public MapPanel getMapPanel() {
        return this.mapPanel;
    }
}
