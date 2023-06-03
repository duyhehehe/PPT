public class EulerMidPoint {
    public static double eulerMidPoint(double x, double y, double h, int n) {
        double ym;
        for (int i = 0; i < n; ++i) {
            ym = y + h / 2 * function(x, y); // y[i + 1/2] = y[i] + h / 2 * f(x[i], y[i])
            y += h * function(x + h / 2, ym); // y[i + 1] = y[i] + h * f(x[i + 1/2], y[i + 1/2])
            x += h; // x[i + 1] = x[i] + h
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
        int n = 20; // Số lần lặp
        double h = 0.01;
        System.out.println(eulerMidPoint(x, y, h, n));
    }
}
