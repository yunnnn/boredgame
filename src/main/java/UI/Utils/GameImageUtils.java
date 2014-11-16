package UI.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by yun on 11/10/14.
 */
public final class GameImageUtils {

    public static final Image MAP_IMAGE = read("images/lightbg.jpg");
    public static final Image LOCATION_IMAGE = scaleRead("images/grass.jpg", 125, 125);
    public static final Image OVERLORD_IMAGE = scaleRead("images/laharl.png", 100, 100);
    public static final Image SWORDSMAN_IMAGE = scaleRead("images/link.png", 100, 100);
    public static final Image BG_IMAGE = scaleRead("images/bg.jpg", 800, 600);
    public static final Image DRAGON_IMAGE = scaleRead("images/dragon.png", 125, 125);

    private static Image read(final String source) {
        try {
            return ImageIO.read(new File(source));
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Image scaleRead(final String source, final int x, final int y) {
        try {
            final BufferedImage image = ImageIO.read(new File(source));
            return image.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
