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

    public static double yAbsolute(double x) {
        return Math.exp(x * x - 1);
        // Hàm y chính xác
    }

    public static void main(String[] args) {
        // f(x, y) = 2 * x * y
        double x = 1;
        double y = 1;
        int n = 20; // Số lần lặp
        double h = 0.01;
        double euler = euler(x, y, h, n);
        double euler_half = euler(x, y, h / 2, n * 2);
        double yAbsolute = yAbsolute(x + n * h);
        double absoluteError = Math.abs(yAbsolute - euler);
        System.out.println("Xấp xỉ vi phân: " + euler);
        System.out.printf("Sai số tuyệt đối: " + absoluteError);
    }
}
