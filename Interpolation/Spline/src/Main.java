import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // y = e^x
        double[] x = {0, 1, 2, 3};
        double[] y = {1, 2.718282, 7.389056, 20.085537};
        Spline.interpolate(3, x, y);
    }
}