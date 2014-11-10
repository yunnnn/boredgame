package UI.Render;

import CoreObjects.GameObject;
import CoreObjects.Location;
import Units.Unit;
import org.lwjgl.opengl.GL11;

/**
 * Created by yun on 11/8/14.
 */
public class LocationRenderer {

    static int counter = 0;
    static float colorcounter = 0;

    public static void render(final Location location) {

        counter += 30;
        colorcounter += .2f;
        renderItself(location);

        for (final GameObject child : location.getChildren()) {
            UnitRenderer.render((Unit) child);
        }
    }

    private static void renderItself(final GameObject gameObject) {
        // set the color of the quad (R,G,B,A)
        GL11.glColor3f(0.5f + colorcounter, 0.1f + colorcounter, 0.0f + colorcounter);

        // draw quad
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(100 + counter, 100 + counter);
        GL11.glVertex2f(100 + counter + 200, 100 + counter);
        GL11.glVertex2f(100 + counter + 200, 100 + 200 + counter);
        GL11.glVertex2f(100 + counter, 100 + 200 + counter);
        GL11.glEnd();
    }
}
