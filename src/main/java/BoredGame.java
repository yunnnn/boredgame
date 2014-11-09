import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Created by yun on 11/8/14.
 */
public class BoredGame {

    public BoredGame(){
        try {
            System.out.println("i hope");
            Display.setDisplayMode(new DisplayMode(800, 600));
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new BoredGame();
    }
}

