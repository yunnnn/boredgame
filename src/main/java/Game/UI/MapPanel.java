package Game.UI;

import Game.UI.Utils.ImageProperties;

import javax.swing.*;
import java.awt.*;

/**
 * Only used to render the Map BG
 */
public class MapPanel extends JPanel {

    public MapPanel() {
        super();
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        this.setBounds(ImageProperties.MAP_XOFFSET,
                ImageProperties.MAP_YOFFSET,
                ImageProperties.MAP_WIDTH,
                ImageProperties.MAP_HEIGHT);
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(ImageProperties.MAP_IMAGE, 0, 0, getWidth(), getHeight(), null);
    }
}
