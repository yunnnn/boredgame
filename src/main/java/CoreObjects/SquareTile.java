package CoreObjects;

import Units.Unit;

/**
 * Created by yun on 11/8/14.
 */
public class SquareTile extends Location {
    private Location topAdjacent = null;
    private Location bottomAdjacent = null;
    private Location leftAdjacent = null;
    private Location rightAdjacent = null;

    public SquareTile(){
    }

    public SquareTile(final Location topAdjacent,
                      final Location bottomAdjacent,
                      final Location leftAdjacent,
                      final Location rightAdjacent){
        this.topAdjacent = topAdjacent;
        this.bottomAdjacent = bottomAdjacent;
        this.leftAdjacent = leftAdjacent;
        this.rightAdjacent = rightAdjacent;
    }

}
