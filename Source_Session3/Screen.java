package vn.edu.techkids;

import java.util.Scanner;

/**
 * Created by qhuydtvt on 4/21/2016.
 */
public class Screen {
    public static final int width = 400;
    public static final int height = 600;

    public static boolean isInRange(int x, int y) {
        return x > 0 && x < width && y > 0 && y < height;
    }
}
