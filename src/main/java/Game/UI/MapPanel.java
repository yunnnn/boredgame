package Game.UI;

import Game.UI.Utils.GameImageUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Only used to render the Map BG
 */
public class MapPanel extends JPanel {

    public MapPanel() {
        super();
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        this.setBounds(GameImageUtils.MAP_XOFFSET,
                GameImageUtils.MAP_YOFFSET,
                GameImageUtils.MAP_WIDTH,
                GameImageUtils.MAP_HEIGHT);
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(GameImageUtils.MAP_IMAGE, 0, 0, getWidth(), getHeight(), null);
    }
}
