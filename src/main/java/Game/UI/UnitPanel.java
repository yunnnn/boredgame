package Game.UI;

import Game.BoredGame;
import Game.UI.Utils.ImageProperties;
import Game.UI.Utils.KeyboardListener;
import Game.Units.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by yun on 11/8/14.
 */
public class UnitPanel extends JPanel {

    private Unit unit;

    public UnitPanel(final Unit unit) {
        super();

        KeyboardListener.testPanel = this;

        this.unit = unit;
        this.setOpaque(false);
        this.setBounds(0, 0, ImageProperties.LOC_WIDTH, ImageProperties.LOC_HEIGHT);
    }

    @Override
    protected void paintComponent(final Graphics g) {
        if (KeyboardListener.hideUnitPanel || this.unit == null){
            //test code to hide units
            return;
        }

        final String unitName = this.unit.getClass().getSimpleName();
        final Image image;
        switch (unitName) {
            case "Swordsman":
                image = ImageProperties.SWORDSMAN_IMAGE;
                break;
            case "Overlord":
                image = ImageProperties.OVERLORD_IMAGE;
                break;
            default:
                image = ImageProperties.DRAGON_IMAGE;
        }
        g.drawImage(image, 10, 0, getWidth()-20, getHeight()-20, null);
    }

    public void renderChildren() {
    }

    public Unit getUnit(){
        return this.unit;
    }

    public void setUnit(final Unit unit){
        this.unit = unit;
    }
}
