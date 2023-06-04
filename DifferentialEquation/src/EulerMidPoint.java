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

    public static double yAbsolute(double x) {
        return Math.exp(x * x - 1);
        // Hàm y chính xác
    }

    public static void main(String[] args) {
        // f(x, y) = 2 * x * y
        double x = 1;
        double y = 1;
        int n = 20; // Số bước
        double h = 0.01;
        double eulerMidPoint = eulerMidPoint(x, y, h, n);
        double eulerMidPoint_half = eulerMidPoint(x, y, h / 2, n * 2);
        double yAbsolute = yAbsolute(x + n * h);
        double absoluteError = Math.abs(yAbsolute - eulerMidPoint);
        System.out.println("Xấp xỉ vi phân: " + eulerMidPoint);
        System.out.printf("Sai số tuyệt đối: " + absoluteError);
    }
}
