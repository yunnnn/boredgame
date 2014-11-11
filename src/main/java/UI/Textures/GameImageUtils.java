package UI.Textures;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by yun on 11/10/14.
 */
public final class GameImageUtils {

    public static final ImageIcon LOCATION_IMAGE = scale("images/grass.jpg", 100, 100);
    public static final ImageIcon OVERLORD_IMAGE = scale("images/laharl.png", 80, 80);
    public static final ImageIcon SWORDSMAN_IMAGE = scale("images/link.png", 80, 80);
    public static final ImageIcon BG_IMAGE = scale("images/bg.jpg", 800, 600);
    public static final ImageIcon MAP_IMAGE = scale("images/lightbg.jpg", 500, 500);


    private static ImageIcon scale(final String source, final int x, final int y) {
        try {
            Image image = ImageIO.read(new File(source));
            final Image scaledImage = image.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage, source);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
