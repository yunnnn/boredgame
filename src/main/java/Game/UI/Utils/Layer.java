package Game.UI.Utils;

/**
 * Created by yun on 11/10/14.
 */
public enum Layer {
    BACKGROUND(1000),
    MENU(900),
    MAP(800),
    GRID(700),
    LOCATION(600),
    UNIT(500),
    ITEMS(400),
    BUFFS(300);

    private final Integer value;

    private Layer(final Integer newValue) {
        this.value = newValue;
    }

    public int getValue() {
        return this.value;
    }
}
