package CoreObjects;

/**
 * Created by yun on 11/8/14.
 */
public class SquareTile extends Location {
    private Location topAdjacent = null;
    private Location bottomAdjacent = null;
    private Location leftAdjacent = null;
    private Location rightAdjacent = null;

    public SquareTile(final Coordinate coord) {
        super(coord);
    }

    public SquareTile(final Coordinate coord,
                      final Location topAdjacent,
                      final Location bottomAdjacent,
                      final Location leftAdjacent,
                      final Location rightAdjacent) {
        super(coord);
        this.topAdjacent = topAdjacent;
        this.bottomAdjacent = bottomAdjacent;
        this.leftAdjacent = leftAdjacent;
        this.rightAdjacent = rightAdjacent;
    }

}
