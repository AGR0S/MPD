package isel.mpd.painter0.utils;

import java.awt.*;
import java.util.Random;

public class RandomUtils {
    public static Random random = new Random();

    /**
     * returns a random integer using random variable above, between
     * li (inclusive) and ls (exclusive)
     * @param li
     * @param ls
     * @return
     */
    public static int getRandomInt(int li, int ls) {
        // TO DO
        return random.nextInt(ls - li) + li;
    }

    /**
     * returns a random Point with coordinates between 0 (inclusive) and sizeX and sizeY (exclusive)
     * for x and y coordinates
     * @param sizeX
     * @param sizeY
     * @return
     */
    public static Point getRandomPoint(int sizeX, int sizeY) {
        // TO DO
        return new Point(random.nextInt(sizeX), random.nextInt(sizeY));
    }
}
