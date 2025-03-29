package General;

import Geometry.Point;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * The type General methods.
 */
public class GeneralMethods {
    /**
     * Equals epsilonit boolean.
     *
     * @param x the x
     * @param y the y
     * @return the boolean
     */
    public static boolean equalsEpsilonit(double x, double y) {
        return Math.abs(x - y) <= Consts.Epsilon;
    }

    /**
     * Average double.
     *
     * @param x the x
     * @param y the y
     * @return the double
     */
    public static double average(double x, double y) {
        return (x + y) * Consts.Half;
    }

    /**
     * Range boolean.
     *
     * @param minx the minx
     * @param z    the z
     * @param maxx the maxx
     * @return the boolean
     */
    public static boolean range(double minx, double z, double maxx) {
        return Math.abs(Math.abs(maxx - minx) - (Math.abs(z - minx) + Math.abs(maxx - z))) <= Consts.Epsilon;
    }

    /**
     * List to set list.
     *
     * @param objectsList the objects list
     * @return the list
     */
    public static List<Point> listToSet(List<Point> objectsList) {
        Set<Point> objectSet = new HashSet<>(objectsList);
        return new ArrayList<>(objectSet);

    }

    /**
     * Random color color.
     *
     * @return the color
     */
    public static Color randomColor(){
        Random random = new Random();
        float r = random.nextFloat();
        float b = random.nextFloat();
        float g = random.nextFloat();
        return new Color(r,g,b);
    }

}
