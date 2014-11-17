package Game.UI.Utils;

import Game.ScriptedLevels.Level1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by yun on 11/10/14.
 */
public final class ImageProperties {

    public static final int SCREEN_WIDTH = 1000;
    public static final int SCREEN_HEIGHT = 800;
    public static final int MAP_WIDTH = 700;
    public static final int MAP_HEIGHT = 600;
    public static final int MAP_XOFFSET = 50;
    public static final int MAP_YOFFSET = 75;

    public static final int GRID_WIDTH = MAP_WIDTH - 100;
    public static final int GRID_HEIGHT = MAP_HEIGHT - 100;
    public static final int GRID_OFFSET = 50;
    public static final int LOC_HEIGHT = (MAP_WIDTH - GRID_OFFSET * 2) / Level1.rows;
    public static final int LOC_WIDTH = (MAP_WIDTH - GRID_OFFSET * 2) / Level1.cols;

    public static final int UNIT_WIDTH = LOC_WIDTH;
    public static final int UNIT_HEIGHT = LOC_HEIGHT;

    public static final Image MAP_IMAGE = scaleRead("images/lightbg.jpg", MAP_WIDTH, MAP_HEIGHT);
    public static final Image NO_LOCATION_BG = scaleRead("images/lightbg.jpg", LOC_WIDTH, LOC_HEIGHT);
    public static final Image LOCATION_BG = scaleRead("images/grass.jpg", LOC_WIDTH, LOC_HEIGHT);
    public static final Image OVERLORD_IMAGE = scaleRead("images/laharl.png", UNIT_WIDTH, UNIT_HEIGHT);
    public static final Image SWORDSMAN_IMAGE = scaleRead("images/link.png", UNIT_WIDTH, UNIT_HEIGHT);
    public static final Image BG_IMAGE = scaleRead("images/bg.jpg", SCREEN_WIDTH, SCREEN_HEIGHT);
    public static final Image DRAGON_IMAGE = read("images/dragon.png");

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
