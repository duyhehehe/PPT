public class Heun {
    public static double heun(double x, double y, double h, double n) {
        double yPredict;
        for (int i = 0; i < n; ++i) {
            yPredict = y + h * function(x, y);
            y += h / 2 * (function(x, y) + function(x + h, yPredict));
            x += h;
        }
        return y;
    }

    public static double function(double x, double y) {
        return 2 * x * y;
    }

    public static void main(String[] args) {
        // f(x, y) = 2 * x * y
        double x = 1;
        double y = 1;
        int n = 2; // Số lần lặp
        double h = 0.1;
        System.out.println(heun(x, y, h, n));
    }
}
