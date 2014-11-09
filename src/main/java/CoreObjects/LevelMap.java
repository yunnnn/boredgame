package CoreObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yun on 11/8/14.
 */
public class LevelMap extends GameObject {
    final List<Location> locations;

    public LevelMap(final List<Location> locations){
        this.locations = locations;
    }
}
