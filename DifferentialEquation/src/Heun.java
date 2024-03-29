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

    public static double yAbsolute(double x) {
        return Math.exp(x * x - 1);
        // Hàm y chính xác
    }

    public static void main(String[] args) {
        // f(x, y) = 2 * x * y
        double x = 1;
        double y = 1;
        int n = 10; // Số bước
        double h = 0.1;
        double heun = heun(x, y, h, n);
        double heun_half = heun(x, y, h / 2, n * 2);
        double yAbsolute = yAbsolute(x + n * h);
        double absoluteError = Math.abs(heun - yAbsolute);
        System.out.println("Xấp xỉ vi phân: " + heun);
        System.out.printf("Sai số tuyệt đối: " + absoluteError);
    }
}
