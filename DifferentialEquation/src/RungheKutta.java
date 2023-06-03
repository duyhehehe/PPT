public class RungheKutta {
    public static double rungheKutta(double x, double y, double h, int n) {
        double k1, k2, k3, k4;
        for (int i = 0; i < n; ++i) {
            k1 = function(x, y);
            k2 = function(x + h / 2, y + k1 * h / 2);
            k3 = function(x + h / 2, y + k2 * h / 2);
            k4 = function(x + h, y + k3 * h);
            y += h / 6 * (k1 + 2 * k2 + 2 * k3 + k4);
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
        System.out.println(rungheKutta(x, y, h, n));
    }
}
