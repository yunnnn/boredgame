package UI;

import CoreObjects.GameObject;
import Units.Unit;

/**
 * Created by yun on 11/8/14.
 */
public class UnitRenderer {

    public static void render(final Unit unit) {
        renderItself(unit);
       // for (final GameObject child : unit.getChildren()) {
            //MoreRenderer.render(child);
        //}
    }

    private static void renderItself(final GameObject gameObject) {
    }
}
