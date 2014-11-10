package UI.Textures;

import CoreObjects.Coordinate;
import CoreObjects.GameObject;
import CoreObjects.LevelMap;
import CoreObjects.Location;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yun on 11/9/14.
 */
public class GamePanel extends JPanel {

    private static final ImageIcon LOCATION_IMAGE = new ImageIcon("red.png");
    private static final ImageIcon UNIT_IMAGE = new ImageIcon("blue.png");
    private static final ImageIcon BG_IMAGE = new ImageIcon("bg.png");

    private JLayeredPane layeredPane;

    public GamePanel(final int screenWidth, final int screenHeight) {
        super();
        //create LayeredPane
        this.layeredPane = new JLayeredPane();
        this.layeredPane.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.add(layeredPane);

        //Load the BG
        loadMenu();
        loadBackground(BG_IMAGE, Layer.BACKGROUND.getValue());
    }

    public static GamePanel init(final int screenWidth, final int screenHeight) {
        JFrame f = new JFrame("Bored Game");
        // By default, the window is not visible. Make it visible.
        f.setVisible(true);
        f.setSize(screenWidth, screenHeight);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final GamePanel gamePanel = new GamePanel(screenWidth, screenHeight);
        f.add(gamePanel);

        return gamePanel;
    }

    //load an image into the layeredPane
    public void loadBackground(final ImageIcon image, final Integer depth) {
        final ImageIcon scaledImage = new ImageIcon(image.getImage().getScaledInstance(800, 600, 0));
        loadImage(scaledImage, depth, 0, 0);
    }

    //load an image into the layeredPane
    public void loadMenu() {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JButton("ff"));
      //  p.setBounds(600, 600, 200, 600);
        this.layeredPane.add(p, Layer.MENU.getValue());
    }

    //load an image into the layeredPane at {x,y}
    public void loadImage(final ImageIcon image,
                          final Integer depth,
                          final int x,
                          final int y) {
        final JLabel imageContainer = new JLabel(image);
        final Dimension size = imageContainer.getPreferredSize();
        imageContainer.setBounds(x, y, size.width, size.height);
        logLoad(image.getDescription(), x, y, size, depth);
        this.layeredPane.add(imageContainer, depth);
    }

    //load an image into the layeredPane at {x,y}
    public void loadMap(final LevelMap map) {
        for (final GameObject location : map.getChildren()){
            final Coordinate coords = ((Location) location).getCoords();

            final int offset = 10;
            final int locationSize = LOCATION_IMAGE.getIconWidth();
            final int x = coords.getX() * (locationSize + offset);
            final int y = coords.getY() * (locationSize + offset);

            final Integer depth = Layer.LOCATION.getValue();

            loadImage(LOCATION_IMAGE, depth, x, y);
        }
    }

    public void logLoad(final String imageName,
                        final int x,
                        final int y,
                        final Dimension size,
                        final Integer depth) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Image: " + imageName + ", ");
        sb.append("At {" + x + "," + y + "}, ");
        sb.append("Width:" + size.getWidth() + " Height:" + size.getHeight() + " ");
        sb.append("Depth: " + depth + ". ");
        System.out.println(sb.toString());
    }

    public enum Layer{
        BACKGROUND(0),
        MENU(100),
        MAP(200),
        LOCATION(300),
        CHARACTER(400),
        ITEMS(500),
        BUFFS(600);

        private final int value;

        private Layer(final int newValue) {
            this.value = newValue;
        }

        public int getValue() { return new Integer(this.value); }
    }
}
