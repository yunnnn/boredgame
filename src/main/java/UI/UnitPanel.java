package UI;

import UI.Utils.GameImageUtils;
import Units.Unit;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yun on 11/8/14.
 */
public class UnitPanel extends JPanel {

    final Unit unit;

    public UnitPanel(final Unit unit) {
        this.unit = unit;
        this.setBounds(0, 0, 100, 100);

//        final String unitName = this.unit.getClass().getSimpleName();
//        final int locationOffset = 12; //character offset
//        Image image;
//        if (unitName.equals("Swordsman")) {
//            image = GameImageUtils.SWORDSMAN_IMAGE;
//        } else if (unitName.equals("Overlord")) {
//            image = GameImageUtils.OVERLORD_IMAGE;
//        } else {
//            image = GameImageUtils.DRAGON_IMAGE;
//        }
//
//        ImageIcon imageIcon = new ImageIcon(image);
//        final JLabel jLabel = new JLabel(imageIcon);



    }


    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final String unitName = this.unit.getClass().getSimpleName();
        final int locationOffset = 12; //character offset
        Image image = null;
        if (unitName.equals("Swordsman")) {
            image = GameImageUtils.SWORDSMAN_IMAGE;
        } else if (unitName.equals("Overlord")) {
            image = GameImageUtils.OVERLORD_IMAGE;
        } else {
            image = GameImageUtils.DRAGON_IMAGE;
        }
        g.drawImage(image, locationOffset, locationOffset, null);
    }

    public void renderChildren() {
    }

}
