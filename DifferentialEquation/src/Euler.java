public class Euler {
    public static double euler(double x, double y, double h, int n) {
        for (int i = 0; i < n; ++i) {
            y += h * function(x, y); // y[i + 1] = y[i] + h * f(x[i], y[i])
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
        System.out.println(euler(x, y, h, n));
    }
}
