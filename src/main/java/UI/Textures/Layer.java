package UI.Textures;

/**
 * Created by yun on 11/10/14.
 */
public enum Layer {
    BACKGROUND(0),
    MENU(100),
    MAP(200),
    LOCATION(300),
    UNIT(400),
    ITEMS(500),
    BUFFS(600);

    private final int value;

    private Layer(final int newValue) {
        this.value = newValue;
    }

    public int getValue() {
        return new Integer(this.value);
    }
}
