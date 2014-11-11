package UI.Textures;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yun on 11/9/14.
 */
public class GamePanel extends JPanel {

    private static GamePanel gamePanel; //Singleton
    public static GamePanel get() {
        return gamePanel;
    }

    private JLayeredPane layeredPane;

    private GamePanel(final int screenWidth, final int screenHeight) {
        super();
        //create LayeredPane
        this.layeredPane = new JLayeredPane();
        this.layeredPane.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.add(layeredPane);

        //Load the static BG and Menu
        loadMenu();
        loadBackground(GameImageUtils.BG_IMAGE, Layer.BACKGROUND.getValue());
    }

    //Create the main JFrame, and attach the GamePanel to it.
    public static void init(final int screenWidth, final int screenHeight) {
        JFrame f = new JFrame("Bored Game");
        // By default, the window is not visible. Make it visible.
        f.setVisible(true);
        f.setSize(screenWidth, screenHeight);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel.gamePanel = new GamePanel(screenWidth, screenHeight);
        f.add(gamePanel);
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

    //logging
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
}
