package Game.UI;

import Game.UI.Utils.ImageProperties;

import javax.swing.*;

/**
 * Created by yun on 11/16/14.
 */
public class MenuPanel extends JPanel {

    public MenuPanel() {

        //JPanel menu = new JPanel(new BorderLayout());
        this.setBounds(
                ImageProperties.MAP_WIDTH + ImageProperties.MAP_XOFFSET + 20,
                ImageProperties.MAP_YOFFSET,
                180,
                ImageProperties.MAP_HEIGHT);

        this.add(new JButton("ff"));
        this.add(new JLabel("Attack"));
        this.add(new JLabel("Menu goes here"));
    }
}
