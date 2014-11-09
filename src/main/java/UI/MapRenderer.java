package UI;

import CoreObjects.GameObject;
import CoreObjects.LevelMap;
import CoreObjects.Location;
import org.lwjgl.opengl.GL11;

/**
 * Created by yun on 11/8/14.
 */
public final class MapRenderer extends Renderer {
    MapRenderer() {
    }

    public static void render(final LevelMap map) {
        renderItself(map);
        LocationRenderer.counter = 0;
        LocationRenderer.colorcounter = 0;
        for (final GameObject child : map.getChildren()) {
            LocationRenderer.render((Location) child);
        }
    }

    private static void renderItself(final GameObject gameObject) {
        // set the color of the quad (R,G,B,A)
        GL11.glColor3f(0.5f, 0.5f, 1.0f);

        // draw quad
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(100, 100);
        GL11.glVertex2f(100 + 200, 100);
        GL11.glVertex2f(100 + 200, 100 + 200);
        GL11.glVertex2f(100, 100 + 200);
        GL11.glEnd();
    }
}
