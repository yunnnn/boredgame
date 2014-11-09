package CoreObjects;

import java.util.Random;

/**
 * Created by yun on 11/8/14.
 */
public final class Dice {

    private static final Random r = new Random(); // only seed it once

    public static int roll(final int min, final int max) {
        return r.nextInt((max - min) + 1) + min;
    }
}
